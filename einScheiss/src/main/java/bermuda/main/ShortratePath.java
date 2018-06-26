package bermuda.main;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class ShortratePath implements ValuePath {

	private ParameterModel aModel;
	private double[] values;

	public ShortratePath(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		int pointCount = aModel.getDurationCallableBond() * aModel.getInterestToShortrateScale();
		double[] r = new double[pointCount + 1];
		r[0] = aModel.getStartShortrate();
		for (int j = 1; j <= pointCount; j++) {
			r[j] = aModel.getMeanShortrate() * (aModel.getReversionSpeedShortrate() + r[j - 1])
					/ aModel.getInterestToShortrateScale()
					+ Math.pow(aModel.getVolatilityShortrate(), 1 / aModel.getInterestToShortrateScale())
							* generator.nextNormalizedDouble();
		}
		values = r;
	}

	public double[] getValues() {
		return values;
	}

	public int getScale() {
		return aModel.getInterestToShortrateScale();
	}

}
