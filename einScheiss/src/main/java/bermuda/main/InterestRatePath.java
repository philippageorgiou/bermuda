package bermuda.main;

public class InterestRatePath {

	private double[] values;

	public InterestRatePath(ShortratePath shortratePath) {
		double[] shortrateValues = shortratePath.getValues();
		int yearCount = shortrateValues.length / shortratePath.getScale();
		double[] y = new double[yearCount];
		y[0] = 0;
		for (int j = 0; j < yearCount; j++) {
			int upperBound = j * shortratePath.getScale();
			for (int k = 1; k < upperBound; k++) {
				y[j] += shortrateValues[k];
			}
			y[j] += (shortrateValues[0] + shortrateValues[upperBound]) / 2;
			y[j] /= (upperBound + 1);
			y[j] = Math.pow(y[j], j) - 1;
		}
		values = y;
	}

	public double[] getValues() {
		return values;
	}
}
