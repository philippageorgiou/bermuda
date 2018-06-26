package bermuda.main;

import java.util.ArrayList;

public class MonteCarlo {

	private double[] c;
	private double valueCallableBond;
	private ParameterModel aModel;
	private ArrayList<CashflowPath> cashflowAllPaths;

	public MonteCarlo(ParameterModel aModel, ArrayList<CashflowPath> cashflowAllPaths) {
		this.aModel = aModel;
		this.cashflowAllPaths = cashflowAllPaths;
	}

	public double generateValueCallabelBond() {
		for (int i = 0; i < aModel.getCountSimulation(); i++) {
			c = cashflowAllPaths.get(i).getValues();
			for (int j = 0; j < c.length; j++) {
				valueCallableBond += c[j];
			}
		}
		valueCallableBond = valueCallableBond / aModel.getCountSimulation();
		return valueCallableBond;

	}
}
