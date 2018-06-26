package bermuda.main;

import java.util.ArrayList;
import java.util.List;

public class InterestsPathFactory {

	private ParameterModel aModel;
	private List<ShortratePath> simulatedShortratePaths;

	public InterestsPathFactory(ParameterModel aModel, List<ShortratePath> simulatedShortratePaths) {
		this.aModel = aModel;
		this.simulatedShortratePaths = simulatedShortratePaths;
	}

	private InterestsPath generatePath(ShortratePath interestsPath) {
		return new InterestsPath(interestsPath);
	}

	public List<InterestsPath> generateAllPaths() {
		List<InterestsPath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			list.add(generatePath(simulatedShortratePaths.get(i)));
		}
		return list;
	}

}
