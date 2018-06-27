package bermuda.main;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CsvWriterTest {
	@Test
	public void writeToCsv() throws Exception {
		// hiermit l�sst sich irgendwie die Reihenfolge setzen
		// HeaderColumnNameMappingStrategy<ParameterModel>
		// headerColumnNameMappingStrategy = new HeaderColumnNameMappingStrategy();

		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("model.csv");
		CsvWriter csvWriter = new CsvWriter();

		for (ParameterModel parameterModel : modelle) {
			Ergebnis ergebnis = new ErgebnisBerechner(parameterModel).berechne();
			csvWriter.write(ergebnis);
		}
	}

	@Test
	public void writeParameterModel() throws Exception {
		CsvWriter csvWriter = new CsvWriter();
		csvWriter.write(ParameterModel.aModel());

	}
}
