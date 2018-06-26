package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.junit.Before;
import org.junit.Test;

public class InterestsPathFactoryTest {

	private static final long SEED = 0;
	private GaussianRandomGenerator generator;

	@Before
	public void setUp() {
		RandomGenerator randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random(SEED));
		generator = new GaussianRandomGenerator(randomGenerator);
	}

	@Test
	public void getValues() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		InterestsPathFactory shortrateVasicek = new InterestsPathFactory(aModel, generator);
		ValuePath path = shortrateVasicek.generatePath();
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
		InterestsPathFactory shortrateVasicek = new InterestsPathFactory(aModel, generator);
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
