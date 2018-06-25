package bermuda.main;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.junit.Test;

public class InterestRatePathTest {
	@Test
	public void testName() throws Exception {
		ParameterModel aModel = null;
		GaussianRandomGenerator generator = null;
		InterestRatePath interestRatePath = new InterestRatePath(new ShortratePath(aModel, generator));
	}
}
