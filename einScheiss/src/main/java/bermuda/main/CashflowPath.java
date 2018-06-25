package bermuda.main;

public class CashflowPath {

	private double[] values;
	private ParameterModel aModel;

	public CashflowPath(ParameterModel aModel, InterestRatePath interestRate) {
		this.aModel = aModel;
		double[] c = new double[aModel.getDurationCallableBond()];
		for (int j = 0; j < c.length; j++) {

			if (j != c.length && zeitwertBond(interestRate) > aModel.getFaceValueCallableBond()) {

			}
		}

	}

	private double zeitwertBond() {

		return 0;
	}

	public double[] getValues() {

		return values;
	}

}
