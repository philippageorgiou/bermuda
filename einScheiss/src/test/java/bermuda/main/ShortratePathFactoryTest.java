package bermuda.main;

import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ShortratePathFactoryTest {
	private static final long SEED = 10;
	private RandomGenerator randomGenerator;
	private ParameterModel aModel;
	private GaussianRandomGenerator generator;

	@Before
	public void setUp() {
		randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random(SEED));
		aModel = ParameterModel.aModel();
		generator = new GaussianRandomGenerator(randomGenerator);
	}

	private List<ShortratePath> generatePaths() {
		ShortratePathFactory shortrateVasicek = new ShortratePathFactory(aModel, generator);
		List<ShortratePath> paths = shortrateVasicek.generateAllPaths();
		return paths;
	}

	@Test
	public void plotPaths() throws Exception {
		List<ShortratePath> paths = generatePaths();
		PathPlotter.plotShortrate(paths);
	}
}
