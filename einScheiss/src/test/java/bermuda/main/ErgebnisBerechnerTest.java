package bermuda.main;

import java.util.List;

import org.junit.Test;

import bermuda.main.CsvEinleser;
import bermuda.main.Ergebnis;
import bermuda.main.ErgebnisBerechner;
import bermuda.main.ParameterModel;

public class ErgebnisBerechnerTest {
	@Test
	public void berechneDieDreiZahlen() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter("testdatei.csv");

		ErgebnisBerechner ergebnisBerechner = new ErgebnisBerechner(modelle.get(0));
		Ergebnis ergebnis = ergebnisBerechner.berechne();
	}

}
