package bermuda.main;

import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.junit.Before;
import org.junit.Test;

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

	private List<ShortratePath> {
		ShortratePathFactory shortrateVasicek = new ShortratePathFactory(aModel, generator);
		List<ShortratePath> paths = shortrateVasicek.generateAllPaths();
		return paths;
	}

	@Test
	public void plotPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		List<ShortratePath> paths = generatePaths(aModel);
		PathPlotter.plotShortrate(paths);
	}
}
