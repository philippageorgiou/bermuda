package bermuda.main;

import org.junit.Test;

public class AnwendungTest {
	@Test
	public void testName() throws Exception {
		Anwendung.main(new String[] { "model.csv", "startShortrate.csv" });
	}
}
