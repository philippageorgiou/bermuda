package bermuda.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvEinleser {

	public List<ParameterModel> leseParameter(String dateiname)
			throws IllegalStateException, FileNotFoundException, MalformedURLException {
		return new CsvToBeanBuilder(new FileReader(new File(dateiname))).withType(ParameterModel.class).build().parse();

	}

	private List<String[]> leseVektoren(String dateiname) throws IOException {
		FileReader fileReader = new FileReader(new File(dateiname));
		CSVReader csvReader = new CSVReader(fileReader);
		List<String[]> list = new ArrayList<>();
		list = csvReader.readAll();
		fileReader.close();
		csvReader.close();
		return list;
	}
}
