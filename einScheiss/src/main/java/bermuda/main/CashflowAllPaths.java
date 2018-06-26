package bermuda.main;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CashflowAllPaths {

	private ParameterModel aModel;
	private List<InterestsPath> simulatedInterestPaths;
	private InterestsPath interestsPath;
	private int countPath;

	public CashflowAllPaths(ParameterModel aModel, List<InterestsPath> simulatedInterestPaths) {
		this.aModel = aModel;
		this.simulatedInterestPaths = simulatedInterestPaths;
		this.countPath = simulatedInterestPaths.size();
	}

	public CashflowPath generatePath() {
		return new CashflowPath(aModel, interestsPath);
	}

	public static List<CashflowPath> generateAllPaths() {
		double[] interests;
		ListIterator<Integer> countPath  interestsAllPaths;
		
		List<CashflowPath> list = new ArrayList<>();
		for (int i = 0; i < aModel.getCountSimulation; i++) {

			for (int j = 0; j < array.length; j++) {

			}
		}

		return list;
	}

}
