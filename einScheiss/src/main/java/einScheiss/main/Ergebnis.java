package einScheiss.main;

public class Ergebnis {

	private ParameterModel parameterModel;

	public Ergebnis(ParameterModel parameterModel) {
		this.parameterModel = parameterModel;
	}

	@Override
	public String toString() {
		return "Ergebnis [parameterModel=" + parameterModel + "]";
	}

}
