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
		// r[0] = aModel.getStartShortrate();
		for (int j = 0; j <= pointCount; j++) {
			r[j] = startShortrate[j]
					+ (Math.pow(aModel.getVolatilityShortrate(), 2) / 2
							* Math.pow(aModel.getReversionSpeedShortrate(), 2))
							* (Math.pow(1 - Math.exp((aModel.getReversionSpeedShortrate() * (-j))
									/ aModel.getInterestToShortrateScale()), 2))
					+ aModel.getMeanShortrate() * (aModel.getReversionSpeedShortrate() + r[j - 1])
							/ aModel.getInterestToShortrateScale()
					+ aModel.getVolatilityShortrate() * Math.sqrt(1 / aModel.getInterestToShortrateScale())
							* generator.nextNormalizedDouble();
		}
		values = r;
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
