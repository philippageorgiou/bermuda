package bermuda.main;

public class InterestRatePath {

	private double[] values;

	public InterestRatePath(ShortratePath shortratePath) {
		double[] shortrateValues = shortratePath.getValues();
		double[] y = new double[shortrateValues.length];
		y[0] = 0;
		for (int j = 0; j < shortrateValues.length; j++) {
			for (int k = 1; k < j; k++) {
				y[j] += shortrateValues[k];

			}
			y[j] += (shortrateValues[0] + shortrateValues[j]) / 2;
			y[j] *= 1 / (j + 1);
			y[j] = Math.pow(y[j], j) - 1;
		}
		values = y;
	}

	public double[] getValues() {
		return values;
	}
}
