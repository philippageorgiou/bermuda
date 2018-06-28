package bermuda.main;

public class CashflowPath {

	private double[] values;
	private ParameterModel aModel;
	private double coupon;

	public CashflowPath(ParameterModel aModel, InterestsPath interesRatePath) {
		this.aModel = aModel;
		double coupon = aModel.getCouponRateCallableBond() * aModel.getFaceValueCallableBond();
		double[][] interests = interesRatePath.getValues();
		double[] cashflow = new double[aModel.getDurationCallableBond()];

		for (int j = 1; j <= cashflow.length; j++) {
			double discount = 1 / (1 + interests[0][j]);

			if (optionCall(j, interests) || aModel.isLastYear(j)) {
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

	private boolean optionCall(int timeStep, double[][] interests) {
		int timeToMaturity = aModel.getDurationCallableBond() - timeStep;
		double discount = 1 / (1 + interests[timeStep][timeToMaturity]);
		double timeValueBond = aModel.getFaceValueCallableBond() * Math.pow(discount, timeToMaturity);

		for (int j = 1; j < timeToMaturity; j++) {
			discount = 1 / (1 + interests[timeStep][timeStep + j]);
			timeValueBond += coupon * Math.pow(discount, j);
		}
		return timeValueBond > aModel.getFaceValueCallableBond();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bermuda.main.ValuePath#getValues()
	 */
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
