package bermuda.main;

import org.junit.Test;

//@Ignore
public class AnwendungTest {
	@Test
	public void testName() throws Exception {
		Anwendung.main(new String[] { "model.csv", "ausgabe" });
	}
}
