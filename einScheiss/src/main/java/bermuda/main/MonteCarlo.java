package bermuda.main;

import java.util.List;

public class MonteCarlo {

	private ParameterModel aModel;
	private List<CashflowPath> cashflowAllPaths;

	public MonteCarlo(ParameterModel aModel, List<CashflowPath> cashflowAllPaths) {
		this.aModel = aModel;
		this.cashflowAllPaths = cashflowAllPaths;
	}

	public double generateCallableBond() {
		double[] c;
		double valueCallableBond = 0;
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
