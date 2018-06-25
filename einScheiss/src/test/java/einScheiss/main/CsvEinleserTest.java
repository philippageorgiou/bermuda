package einScheiss.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CsvEinleserTest {

	@Test
	public void leseParameter_ConvertsLinesToParameterModel() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("testdatei.csv");
		assertThat(modelle).hasSize(1);
		assertThat(modelle.get(0).toString())
				.isEqualTo("ParameterModel [ersterParameter=1.0, zweiterParameter=2.0, dritterParameter=3.0]");
	}
}
