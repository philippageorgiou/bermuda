package bermuda.main;

import java.util.List;

import org.junit.Test;

public class CsvWriterTest {
	@Test
	public void writeToCsv() throws Exception {
		// hiermit l�sst sich irgendwie die Reihenfolge setzen
		// HeaderColumnNameMappingStrategy<ParameterModel>
		// headerColumnNameMappingStrategy = new HeaderColumnNameMappingStrategy();
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("testdatei.csv");
		CsvWriter csvWriter = new CsvWriter("ergebnisse.csv");

		for (ParameterModel parameterModel : modelle) {
			Ergebnis ergebnis = new ErgebnisBerechner(parameterModel, 0L).berechne();
			csvWriter.write(ergebnis);
		}
	}
}
