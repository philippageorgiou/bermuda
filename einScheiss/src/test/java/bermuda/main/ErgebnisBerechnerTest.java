package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

//@Ignore
public class ErgebnisBerechnerTest {
	@Test
	public void berechneDieDreiZahlen() throws Exception {

		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("model.csv");

		ErgebnisBerechner ergebnisBerechner = new ErgebnisBerechner(modelle.get(0));
		Ergebnis ergebnis = ergebnisBerechner.berechne();
		StatisticCalculator statisticCalculator = new StatisticCalculator();
		assertThat(statisticCalculator.calculateStd(ergebnis.getShortratePaths().get(0)).getStandardDeviation())
				.isEqualTo(1);
	}

}
