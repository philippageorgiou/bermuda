package bermuda.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvEinleser {

	private static final String NOT_ENOUGH_START_SHORTRATE_IN_FILE = "Not enough startShortrates in file";

	public List<ParameterModel> leseParameter(String dateiname, String startShortratesDatei) throws Exception {
		List<ParameterModel> models = new CsvToBeanBuilder(new FileReader(new File(dateiname)))
				.withType(ParameterModel.class).build().parse();
		List<double[]> startShortrates = leseVektoren(startShortratesDatei);
		checkFilesValid(startShortrates, models);
		for (int j = 0; j < models.size(); j++) {
			models.get(j).setStartShortrate(startShortrates.get(j));
		}
		return models;

	}

	private void checkFilesValid(List<double[]> startShortrates, List<ParameterModel> models) throws Exception {
		if (startShortrates.size() < models.size()) {
			System.out.println(NOT_ENOUGH_START_SHORTRATE_IN_FILE);
		}
	}

	private List<double[]> leseVektoren(String dateiname) throws IOException {
		FileReader fileReader = new FileReader(new File(dateiname));
		CSVReader csvReader = new CSVReader(fileReader);
		List<String[]> list = csvReader.readAll();
		ArrayList<double[]> result = new ArrayList<>();
		for (String[] strings : list) {
			double[] startInterestRates = new double[strings.length];
			for (int i = 0; i < startInterestRates.length; i++) {
				startInterestRates[i] = Double.valueOf(strings[i]);
			}
			result.add(startInterestRates);
		}
		fileReader.close();
		csvReader.close();
		return result;
	}
}
