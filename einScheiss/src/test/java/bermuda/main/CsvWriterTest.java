package bermuda.main;

import org.junit.Test;

public class CsvWriterTest {
	@Test
	public void writeToCsv() throws Exception {
		// hiermit lässt sich irgendwie die Reihenfolge setzen
		// HeaderColumnNameMappingStrategy<ParameterModel>
		// headerColumnNameMappingStrategy = new HeaderColumnNameMappingStrategy();
		CsvWriter csvWriter = new CsvWriter("ergebnisse.csv");
		csvWriter.write(new Ergebnis(new ParameterModel(1, 2, 3, 4, 5, 6, 7, 8, 365)));
	}
}
