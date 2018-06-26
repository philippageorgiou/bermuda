package bermuda.main;

import java.util.List;

public class Ergebnis {

	public List<ShortratePath> getShortratePaths() {
		return shortratePaths;
	}

	public List<InterestsPath> getInterestsPaths() {
		return interestsPaths;
	}

	public List<CashflowPath> getCashFlowPaths() {
		return cashFlowPaths;
	}

	public double getCallableBond() {
		return callableBond;
	}

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
