package bermuda.main;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class Anwendung {

	public static void main(String[] args)
			throws IllegalStateException, IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter(args[0]);
		CsvWriter csvWriter = new CsvWriter(args[1]);

		for (ParameterModel parameterModel : modelle) {
			Ergebnis ergebnis = new ErgebnisBerechner(parameterModel).berechne();
			csvWriter.write(ergebnis);
		}

	}

}
