package bermuda.main;

import java.util.ArrayList;
import java.util.List;

public class CashflowAllPaths {

	private ParameterModel aModel;
	private ArrayList<InterestsPath> simulatedInterestPaths;
	private ArrayList<CashflowPath> cashflowAllPaths;
	private InterestsPath interestsPath;

	public CashflowAllPaths(ParameterModel aModel, Arraylist<InterestsPath> simulatedInterestPaths) {
		this.aModel = aModel;
		this.simulatedInterestPaths = simulatedInterestPaths;
	}

	public CashflowPath generatePath() {
		return new CashflowPath(aModel, interestsPath);
	}

	public List<CashflowPath> generateAllPaths() {
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			interestsPath = simulatedInterestPaths.get(i);

		}

		return list;
	}

}
