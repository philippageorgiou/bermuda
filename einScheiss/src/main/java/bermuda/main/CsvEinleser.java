package bermuda.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class CsvEinleser {

	public List<ParameterModel> leseParameter(String dateiname)
			throws IllegalStateException, FileNotFoundException, MalformedURLException {
		return new CsvToBeanBuilder(new FileReader(new File(dateiname))).withType(ParameterModel.class).build().parse();

	}

}
