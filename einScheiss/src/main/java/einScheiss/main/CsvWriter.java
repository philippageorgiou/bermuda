package einScheiss.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.opencsv.CSVWriter;

public class CsvWriter {

	private String dateiname;

	public CsvWriter(String dateiname) {
		this.dateiname = dateiname;
	}

	public void write(Ergebnis ergebnis) throws IOException {
		Path path = Paths.get(dateiname);
		Files.createDirectories(path.getParent());

		File file = new File(dateiname);
		FileWriter writer = new FileWriter(file);
		CSVWriter csvWriter = new CSVWriter(writer);
		csvWriter.writeNext(new String[] { ergebnis.toString() });
	}

}
