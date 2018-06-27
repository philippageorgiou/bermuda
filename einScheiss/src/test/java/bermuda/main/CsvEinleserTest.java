package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CsvEinleserTest {

	@Test
	public void leseParameter_ConvertsLinesToParameterModel() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("model.csv", "vektoren.csv");
		assertThat(modelle).hasSize(6);
		assertThat(modelle.get(0).getStartShortrate()).isEqualTo(new double[] { 1, 1, 1, 1, 1, 1 });
		// assertThat(modelle.get(0).toString()).isEqualTo("");
	}
}
