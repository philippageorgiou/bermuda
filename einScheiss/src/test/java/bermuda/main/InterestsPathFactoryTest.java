package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.junit.Before;
import org.junit.Test;

public class InterestsPathFactoryTest {

	private static final long SEED = 10;
	private GaussianRandomGenerator generator;
	private ParameterModel aModel;
	private RandomGenerator randomGenerator;
	private ArrayList<ShortratePath> shortratePaths;

	@Before
	public void setUp() {
		randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random(SEED));
		aModel = ParameterModel.aModel();
		generator = new GaussianRandomGenerator(randomGenerator);
		shortratePaths = new ShortratePathFactory(aModel, generator).generateAllPaths();
	}

	@Test
	public void getValues() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		InterestsPathFactory shortrateVasicek = new InterestsPathFactory(aModel, shortratePaths);

		ValuePath path = shortrateVasicek.generateAllPaths().get(0);
		double[] values = path.getValues();
		assertThat(values).hasSize(aModel.getDurationCallableBond() + 1);
		assertThat(values[0]).isEqualTo(aModel.getStartShortrate());
	}

	@Test
	public void generateAllPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		List<InterestsPath> paths = generatePaths(aModel);
		assertThat(paths).hasSize(aModel.getCountSimulation());
		assertThat(paths.get(0).getValues()).isEqualTo(new double[] { aModel.getStartShortrate(), 22.012665318695152,
				73.53026551399789, 242.99540049413446, 744.8050553245859, 2251.33803863817, 6757.597054620673 });
	}

	private List<InterestsPath> generatePaths(ParameterModel aModel) {
		InterestsPathFactory shortrateVasicek = new InterestsPathFactory(aModel, shortratePaths);
		List<InterestsPath> paths = shortrateVasicek.generateAllPaths();
		return paths;
	}

	@Test
	public void plotPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		List<InterestsPath> paths = generatePaths(aModel);

		PathPlotter.plotInterest(paths);
	}

}
