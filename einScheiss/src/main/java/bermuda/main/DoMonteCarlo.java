package bermuda.main;

import java.util.ArrayList;

public class DoMonteCarlo {
	private ParameterModel aModel;
	private ArrayList<CashflowPath> cashflowsAllPaths;

	public DoMonteCarlo(ParameterModel aModel, ArrayList<CashflowPath> cashflowAllPaths) {
		this.aModel = aModel;
		this.cashflowsAllPaths = cashflowAllPaths;

		for (int i = 0; i < aModel.getCountSimulation(); i++) {

			;

		}
	}
}
