package bermuda.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class InterestAllPaths {

	private ParameterModel aModel;
	private GaussianRandomGenerator generator;

	public InterestAllPaths(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		this.generator = generator;
	}

	public InterestRatePath generatePath() {
		return new InterestRatePath(new ShortratePath(aModel, generator));
	}

	public List<InterestRatePath> generateAllPaths() {
		List<InterestRatePath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			list.add(generatePath());
		}
		return list;
	}

}
