package bermuda.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class Anwendung {

	public static void main(String[] args) {
		try {
			CsvEinleser csvEinleser = new CsvEinleser();
			List<ParameterModel> modelle = csvEinleser.leseParameter(args[0], args[1]);
			CsvWriter csvWriter = new CsvWriter();
			List<Ergebnis> ergebnisse = new ArrayList();
			int i = 1;
			for (ParameterModel parameterModel : modelle) {
				Ergebnis ergebnis = new ErgebnisBerechner(parameterModel).berechne();
				ergebnisse.add(ergebnis);
				csvWriter.write(ergebnis);
				System.out.println("Model " + i++ + " simulated with valueCallableBond " + ergebnis.getCallableBond());
			}
			PathPlotter.plotShortrate(ergebnisse.get(0).getShortratePaths());
			csvWriter.writeCallableBonds(ergebnisse);
			System.out.println("successfully written csv files for every ParameterModel");

		} catch (CsvDataTypeMismatchException | IOException | CsvRequiredFieldEmptyException e) {
			System.out.println("failed");
		} catch (Exception e) {
			System.out.println("wrong data input");
		}
	}

}
