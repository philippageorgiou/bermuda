package bermuda.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CsvWriter {

	private String folder;

	public CsvWriter(String folder) throws IOException {
		this.folder = folder;
		Path path = Paths.get(folder);
		Files.createDirectories(path);
	}

	public void write(Ergebnis ergebnis)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		writeShortratePaths(ergebnis);
		writeInterestsPaths(ergebnis);
		writeCashflowPaths(ergebnis);

	}

	private void writeInterestsPaths(Ergebnis ergebnis) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(folder + "\\interestsPaths.csv"));
		List<InterestsPath> interestsPaths = ergebnis.getInterestsPaths();
		for (InterestsPath interestsPath : interestsPaths) {
			String[] record = interestsPath.getValuesAsStrings();
			writer.writeNext(record);
		}
		writer.close();
	}

	private void writeCashflowPaths(Ergebnis ergebnis) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(folder + "\\cashflowPaths.csv"));
		List<ShortratePath> shortratePaths = ergebnis.getShortratePaths();
		for (ShortratePath shortratePath : shortratePaths) {
			String[] record = shortratePath.getValuesAsStrings();
			writer.writeNext(record);
		}
		writer.close();
	}

	private void writeShortratePaths(Ergebnis ergebnis) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(folder + "\\shortratePaths.csv"));
		List<ShortratePath> shortratePaths = ergebnis.getShortratePaths();
		for (ShortratePath shortratePath : shortratePaths) {
			String[] record = shortratePath.getValuesAsStrings();
			writer.writeNext(record);
		}
		writer.close();
	}

	public void write(ParameterModel parameterModel)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		try (Writer writer = Files.newBufferedWriter(Paths.get(folder))) {
			StatefulBeanToCsv<ParameterModel> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withOrderedResults(true).build();
			beanToCsv.write(parameterModel);
		}

	}

}
