package bermuda.main;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class CsvWriterTest {
	@Test
	public void writeToCsv() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("model.csv", "startShortrate.csv");
		CsvWriter csvWriter = new CsvWriter();

		for (ParameterModel parameterModel : modelle) {
			Ergebnis ergebnis = new ErgebnisBerechner(parameterModel).berechne();
			csvWriter.write(ergebnis);
		}
	}

	@Test
	@Ignore
	public void writeParameterModel() throws Exception {
		CsvWriter csvWriter = new CsvWriter();
		csvWriter.write(ParameterModel.aModel());

	}
}
