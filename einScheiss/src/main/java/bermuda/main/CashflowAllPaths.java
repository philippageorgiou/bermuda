package bermuda.main;

import java.util.List;

public class CashflowAllPaths {

	private ParameterModel aModel;
	private InterestsPath interestsPath;
	private List<InterestsPath> simulatedInterestPaths;

	public CashflowAllPaths(ParameterModel aModel, List<InterestsPath> simulatedInterestPaths) {
		this.aModel = aModel;
		this.simulatedInterestPaths = simulatedInterestPaths;
	}

	public CashflowPath generatePath() {
		return new CashflowPath(aModel, interestsPath);
	}

	public List<CashflowPath> generateAllPaths() {
		List<CashflowPath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			interestsPath = simulatedInterestPaths.get(i);
			list.add(generatePath());
		}
		return list;
	}

}
