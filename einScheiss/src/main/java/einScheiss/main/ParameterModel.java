package einScheiss.main;

import com.opencsv.bean.CsvBindByName;

public class ParameterModel {
	@CsvBindByName(column = "erster Parameter")
	private double ersterParameter;

	public ParameterModel(double ersterParameter, double zweiterParameter, double dritterParameter) {
		this.ersterParameter = ersterParameter;
		this.zweiterParameter = zweiterParameter;
		this.dritterParameter = dritterParameter;
	}

	@CsvBindByName(column = "zweiter Parameter")
	private double zweiterParameter;

	@CsvBindByName(column = "dritter Parameter")
	private double dritterParameter;

	@Override
	public String toString() {
		return "ParameterModel [ersterParameter=" + ersterParameter + ", zweiterParameter=" + zweiterParameter
				+ ", dritterParameter=" + dritterParameter + "]";
	}

}
