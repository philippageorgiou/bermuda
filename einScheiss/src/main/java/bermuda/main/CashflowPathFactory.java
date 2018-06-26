package bermuda.main;

import java.util.ArrayList;
import java.util.List;

public class CashflowPathFactory {

	private ParameterModel aModel;
	private List<InterestsPath> simulatedInterestPaths;

	public CashflowPathFactory(ParameterModel aModel, List<InterestsPath> simulatedInterestPaths) {
		this.aModel = aModel;
		this.simulatedInterestPaths = simulatedInterestPaths;
	}

	private CashflowPath generatePath(InterestsPath interestsPath) {
		return new CashflowPath(aModel, interestsPath);
	}

	public List<CashflowPath> generateAllPaths() {
		List<CashflowPath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			list.add(generatePath(simulatedInterestPaths.get(i)));
		}
		return list;
	}

}
