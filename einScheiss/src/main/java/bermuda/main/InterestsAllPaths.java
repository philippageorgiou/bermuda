package bermuda.main;

import java.util.ArrayList;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class InterestsAllPaths {

	private ParameterModel aModel;
	private GaussianRandomGenerator generator;

	public InterestsAllPaths(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		this.generator = generator;
	}

	public InterestsPath generatePath() {
		return new InterestsPath(new ShortratePath(aModel, generator));
	}

	public ArrayList<InterestsPath> generateAllPaths() {
		ArrayList<InterestsPath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			list.add(generatePath());
		}
		return list;
	}

}
