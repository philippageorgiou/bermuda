package einScheiss.main;

import org.junit.Test;

public class CsvWriterTest {
	@Test
	public void writeToCsv() throws Exception {
		CsvWriter csvWriter = new CsvWriter("\\src\\test\\resources\\einScheiss\\main\\ergebnisse.csv");
		csvWriter.write(new Ergebnis(new ParameterModel(1, 2, 3)));
	}
}
