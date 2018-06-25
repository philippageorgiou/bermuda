package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CsvEinleserTest {

	@Test
	public void leseParameter_ConvertsLinesToParameterModel() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("testdatei.csv");
		assertThat(modelle).hasSize(1);
		assertThat(modelle.get(0).toString()).isEqualTo(
				"ParameterModel [countSimulation=1, startShortrate=2.0, meanShortrate=3.0, reversionSpeedShortrate=4.0,"
						+ " volatilityShortrate=5.0, durationCallableBond=6, couponRateCallableBond=7.0, faceValueCallableBond=8.0]");
	}
}
