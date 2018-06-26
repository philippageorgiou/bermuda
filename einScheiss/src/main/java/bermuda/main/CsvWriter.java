package bermuda.main;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CsvWriter {

	private String dateiname;

	public CsvWriter(String dateiname) {
		this.dateiname = dateiname;
	}

	public void write(Ergebnis ergebnis)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		try (Writer writer = Files.newBufferedWriter(Paths.get(dateiname))) {
			StatefulBeanToCsv<Ergebnis> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withOrderedResults(true).build();
			beanToCsv.write(ergebnis);
		}

	}

	public void write(ParameterModel parameterModel)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		try (Writer writer = Files.newBufferedWriter(Paths.get(dateiname))) {
			StatefulBeanToCsv<ParameterModel> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withOrderedResults(true).build();
			beanToCsv.write(parameterModel);
		}

	}

}
