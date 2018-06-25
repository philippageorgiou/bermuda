package einScheiss.main;

public class Ergebnis {

	private ParameterModel parameterModel;

	public Ergebnis(ParameterModel parameterModel) {
		this.setParameterModel(parameterModel);
	}

	@Override
	public String toString() {
		return "Ergebnis [parameterModel=" + getParameterModel() + "]";
	}

	public ParameterModel getParameterModel() {
		return parameterModel;
	}

	public void setParameterModel(ParameterModel parameterModel) {
		this.parameterModel = parameterModel;
	}

}
