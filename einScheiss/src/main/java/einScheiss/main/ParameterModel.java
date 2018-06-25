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

	public double getErsterParameter() {
		return ersterParameter;
	}

	public void setErsterParameter(double ersterParameter) {
		this.ersterParameter = ersterParameter;
	}

	public double getZweiterParameter() {
		return zweiterParameter;
	}

	public void setZweiterParameter(double zweiterParameter) {
		this.zweiterParameter = zweiterParameter;
	}

	public double getDritterParameter() {
		return dritterParameter;
	}

	public void setDritterParameter(double dritterParameter) {
		this.dritterParameter = dritterParameter;
	}

}
