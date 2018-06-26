package bermuda.main;

public class CashflowPath {

	private double[] values;
	private ParameterModel aModel;
	private double coupon = aModel.getCouponRateCallableBond() * aModel.getFaceValueCallableBond();

	public CashflowPath(ParameterModel aModel, InterestsPath interesRatePath) {
		this.aModel = aModel;
		double discount;
		boolean hasBeenCalled = false;
		boolean callNow = false;
		double[] interests = interesRatePath.getValues();
		double coupon = aModel.getCouponRateCallableBond() * aModel.getFaceValueCallableBond();
		double[] c = new double[aModel.getDurationCallableBond()];

		for (int j = 0; j < c.length - 1; j++) {
			discount = 1 / (1 + interests[j]);
			callNow = optionCall(j, discount);
			if (callNow) {
				c[j] = aModel.getFaceValueCallableBond() * Math.pow(discount, j);
			}
			if (!hasBeenCalled) {
				hasBeenCalled = true;
			} else if (!callNow && !hasBeenCalled) {
				c[j] = coupon * Math.pow(discount, j);
			} else {
				c[j] = 0;
			}
		}

		if (!hasBeenCalled) {
			discount = 1 / (1 + interests[c.length]);
			c[c.length] = (coupon * aModel.getFaceValueCallableBond()) * Math.pow(discount, c.length);
		} else {
			c[c.length] = 0;
		}
	}

	private boolean optionCall(int timeStep, double discount) {
		boolean call;
		int timeToMaturity;
		timeToMaturity = aModel.getDurationCallableBond() - timeStep;
		double timeValueBond = 0;
		for (int i = 1; i < timeToMaturity; i++) {
			timeValueBond += coupon * Math.pow(discount, i);
		}
		timeValueBond += aModel.getFaceValueCallableBond() * Math.pow(discount, timeToMaturity);
		if (timeValueBond > aModel.getFaceValueCallableBond())
			call = true;
		else
			call = false;
		return call;
	}

	public double[] getValues() {

		return values;
	}

}
