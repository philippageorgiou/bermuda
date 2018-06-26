package bermuda.main;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.junit.Test;

public class InterestsPathTest {
	@Test
	public void testName() throws Exception {
		ParameterModel aModel = null;
		GaussianRandomGenerator generator = null;
		InterestsPath interestRatePath = new InterestsPath(new ShortratePath(aModel, generator));
	}
}
