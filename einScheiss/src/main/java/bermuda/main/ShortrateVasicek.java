package bermuda.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.random.GaussianRandomGenerator;

public class ShortrateVasicek {

	private ParameterModel aModel;
	private GaussianRandomGenerator generator;

	public ShortrateVasicek(ParameterModel aModel, GaussianRandomGenerator generator) {
		this.aModel = aModel;
		this.generator = generator;
	}

	public ShortratePath generatePath() {
		return new ShortratePath(aModel, generator);
	}

	public List<ShortratePath> generateAllPaths() {
		List<ShortratePath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			list.add(generatePath());
		}
		return list;
	}

}
