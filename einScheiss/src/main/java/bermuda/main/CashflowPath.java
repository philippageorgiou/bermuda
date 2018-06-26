package bermuda.main;

public class CashflowPath implements ValuePath {

	private double[] values;
	private ParameterModel aModel;
	private double coupon;

	public CashflowPath(ParameterModel aModel, InterestsPath interesRatePath) {
		this.aModel = aModel;
		double coupon = aModel.getCouponRateCallableBond() * aModel.getFaceValueCallableBond();
		double[] interests = interesRatePath.getValues();
		double[] cashflow = new double[aModel.getDurationCallableBond()];
		for (int j = 0; j <= cashflow.length - 1; j++) {
			double discount = 1 / (1 + interests[j]);

			if (optionCall(j, discount) || aModel.isLastYear(j)) {
				cashflow[j] = calculateDiscountedCashout(discount, j, aModel.getFaceValueCallableBond() + coupon);
				values = cashflow;
				return;
			}
			cashflow[j] = calculateDiscountedCashout(discount, j, coupon);
		}
		values = cashflow;
	}

	private double calculateDiscountedCashout(double discount, int year, double betrag) {
		return betrag * Math.pow(discount, year + 1);
	}

	private boolean optionCall(int timeStep, double discount) {
		int timeToMaturity = aModel.getDurationCallableBond() - timeStep;
		double timeValueBond = aModel.getFaceValueCallableBond() * Math.pow(discount, timeToMaturity);
		for (int i = 1; i <= timeToMaturity; i++) {
			timeValueBond += coupon * Math.pow(discount, i);
		}
		return timeValueBond > aModel.getFaceValueCallableBond();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bermuda.main.ValuePath#getValues()
	 */
	@Override
	public double[] getValues() {
		return values;
	}

	public String[] getValuesAsStrings() {
		String[] val = new String[values.length];
		for (int i = 0; i < val.length; i++) {
			val[i] = "" + values[i];
		}
		return val;
	}
}
