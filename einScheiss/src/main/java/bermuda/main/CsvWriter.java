package bermuda.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CsvWriter {

	int i = 1;
	private CSVWriter callableBondsWriter;

	public CsvWriter() throws IOException {
		callableBondsWriter = new CSVWriter(new FileWriter(".\\valuesCallableBonds.csv"));

	}

	public void write(Ergebnis ergebnis)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		writeShortratePaths(ergebnis);
		// tensoren können nicht gut in csv dargestellt werden
		// writeInterestsPaths(ergebnis);
		writeCashflowPaths(ergebnis);
		i++;
	}

	public void writeCallableBonds(List<Ergebnis> ergebnisse) throws IOException {
		for (int j = 0; j < ergebnisse.size(); j++) {
			callableBondsWriter.writeNext(new String[] { "" + (j + 1), "" + ergebnisse.get(j).getCallableBond() });
		}
		callableBondsWriter.close();
	}

	private void writeInterestsPaths(Ergebnis ergebnis) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(".\\interestsPaths" + i + ".csv"));
		List<InterestsPath> interestsPaths = ergebnis.getInterestsPaths();
		for (InterestsPath interestsPath : interestsPaths) {
			String[] record = interestsPath.getValuesAsStrings();
			writer.writeNext(record);
		}
		writer.close();
	}

	private void writeCashflowPaths(Ergebnis ergebnis) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(".\\cashflowPaths" + i + ".csv"));
		List<CashflowPath> cashflowPaths = ergebnis.getCashFlowPaths();
		for (CashflowPath cashflowPath : cashflowPaths) {
			String[] record = cashflowPath.getValuesAsStrings();
			writer.writeNext(record);
		}
		writer.close();
	}

	private void writeShortratePaths(Ergebnis ergebnis) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(".\\shortratePaths" + i + ".csv"));
		List<ShortratePath> shortratePaths = ergebnis.getShortratePaths();
		for (ShortratePath shortratePath : shortratePaths) {
			String[] record = shortratePath.getValuesAsStrings();
			writer.writeNext(record);
		}
		writer.close();
	}

	public void write(ParameterModel parameterModel)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		try (Writer writer = Files.newBufferedWriter(Paths.get(""))) {
			StatefulBeanToCsv<ParameterModel> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withOrderedResults(true).build();
			beanToCsv.write(parameterModel);
		}

	}

}
