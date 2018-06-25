package bermuda.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class CsvEinleser {

	public List<ParameterModel> leseParameter(String dateiname) throws IllegalStateException, FileNotFoundException {
		URL url = getClass().getResource(dateiname);
		File file = new File(url.getPath());
		return new CsvToBeanBuilder(new FileReader(file)).withType(ParameterModel.class).build().parse();

	}

}
