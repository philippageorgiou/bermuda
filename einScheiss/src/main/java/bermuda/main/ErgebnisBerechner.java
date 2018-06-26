package bermuda.main;

import com.opencsv.bean.CsvBindByName;

public class ErgebnisBerechner {

	private ParameterModel parameterModel;
	private long seed;

	public ErgebnisBerechner(ParameterModel parameterModel, long seed) {
		this.parameterModel = parameterModel;
		this.seed = seed;
	}

	public Ergebnis berechne() {

		@CsvBindByName(column = "")
		private int countSimulation;

		return new Ergebnis(parameterModel);
	}

}
