package bermuda.main;

import java.io.FileNotFoundException;
import java.util.List;

public class Anwendung {

	public static void main(String[] args) throws IllegalStateException, FileNotFoundException {
		String dateiname = args[0];
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter(dateiname);

		ErgebnisBerechner ergebnisBerechner = new ErgebnisBerechner(modelle.get(0));
		Ergebnis ergebnis = ergebnisBerechner.berechne();
	}

}
