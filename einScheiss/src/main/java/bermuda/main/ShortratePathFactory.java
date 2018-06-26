package bermuda.main;

import java.util.ArrayList;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class ShortratePathFactory {

	private ParameterModel aModel;
	private GaussianRandomGenerator generator;

	public ShortratePathFactory(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		this.generator = generator;
	}

	public ShortratePath generatePath() {
		return new ShortratePath(aModel, generator);
	}

	public ArrayList<ShortratePath> generateAllPaths() {
		ArrayList<ShortratePath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			list.add(generatePath());
		}
		return list;
	}

}
