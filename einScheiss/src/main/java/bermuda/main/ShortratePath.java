package bermuda.main;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class ShortratePath implements ValuePath {

	private ParameterModel aModel;
	private double[] values;

	public ShortratePath(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		int pointCount = aModel.getDurationCallableBond() * aModel.getInterestToShortrateScale();
		double[] r = new double[pointCount + 1];
		double[] startShortrate = aModel.getStartShortrate();
		r[0] = startShortrate[0];
		for (int j = 1; j <= pointCount; j++) {

			r[j] = kalibriereStartShortrate(aModel, startShortrate, j)
					+ aModel.getMeanShortrate() * (aModel.getReversionSpeedShortrate() + r[j - 1]) * timeStep(aModel, 1)
					+ aModel.getVolatilityShortrate() * Math.sqrt(timeStep(aModel, 1))
							* generator.nextNormalizedDouble();
		}
		values = r;
	}

	private double kalibriereStartShortrate(ParameterModel aModel, double[] startShortrate, int j) {
		return startShortrate[j]
				+ (Math.pow(aModel.getVolatilityShortrate(), 2) / (2 * Math.pow(aModel.getReversionSpeedShortrate(), 2))
						* Math.pow(1 - Math.exp(aModel.getReversionSpeedShortrate() * timeStep(aModel, -j)), 2));
	}

	private double timeStep(ParameterModel aModel, int j) {
		return (j * 1.0) / aModel.getInterestToShortrateScale();
	}

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

	public int getScale() {
		return aModel.getInterestToShortrateScale();
	}

}
