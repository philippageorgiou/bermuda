package bermuda.main;

public class InterestsPath {

	private double[][] values;

	public InterestsPath(ShortratePath shortratePath) {
		double[] shortrateValues = shortratePath.getValues();
		int yearCount = shortrateValues.length / shortratePath.getScale();
		double[][] y = new double[yearCount + 1][yearCount + 1];
		for (int i = 0; i <= yearCount; i++) {

			for (int j = 0; j <= yearCount; j++) {
				if (j <= i) {
					y[i][j] = 0;
				} else {
					int upperBound = j * shortratePath.getScale();
					int lowerBound = i * shortratePath.getScale();
					for (int k = lowerBound + 1; k < upperBound; k++) {
						y[i][j] += shortrateValues[k];
					}
					y[i][j] += (shortrateValues[lowerBound] + shortrateValues[upperBound]) / 2;
					double scale = 1 / ((upperBound * 1.0 - lowerBound * 1.0) + 1);
					y[i][j] *= scale;
					y[i][j] = Math.exp(-(y[i][j]));
					y[i][j] = Math.pow(y[i][j], -(j - i)) - 1;
				}
			}
		}
		values = y;
	}

	public double[][] getValues() {
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
