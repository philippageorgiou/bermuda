package bermuda.main;

import java.util.List;

public class Ergebnis {

	private List<ShortratePath> shortratePaths;
	private List<InterestsPath> interestsPaths;
	private List<CashflowPath> cashFlowPaths;
	private double callableBond;

	public Ergebnis(List<ShortratePath> shortratePaths, List<InterestsPath> interestsPaths,
			List<CashflowPath> cashFlowPaths, double callableBond) {
		this.shortratePaths = shortratePaths;
		this.interestsPaths = interestsPaths;
		this.cashFlowPaths = cashFlowPaths;
		this.callableBond = callableBond;
	}

}
