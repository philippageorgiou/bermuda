package bermuda.main;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class ShortratePath {

	private ParameterModel aModel;
	private double[] values;

	public ShortratePath(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		double[] r = new double[aModel.getDurationCallableBond() + 1];
		r[0] = aModel.getStartShortrate();
		for (int j = 1; j <= aModel.getDurationCallableBond(); j++) {
			r[j] = aModel.getMeanShortrate() * (aModel.getReversionSpeedShortrate() + r[j - 1])
					+ aModel.getVolatilityShortrate() * generator.nextNormalizedDouble();
		}
		values = r;
	}

	public double[] getValues() {
		return values;
	}

}
