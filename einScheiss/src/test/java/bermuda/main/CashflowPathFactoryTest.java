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

public class CashflowPathFactoryTest {
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
	public void generateAllPaths() throws Exception {
		InterestsPathFactory interestsPathFactory = new InterestsPathFactory(aModel, shortratePaths);
		List<InterestsPath> paths = interestsPathFactory.generateAllPaths();

		CashflowPathFactory cashflowPathFactory = new CashflowPathFactory(aModel, paths);
		List<CashflowPath> cashFlowPaths = cashflowPathFactory.generateAllPaths();

		assertThat(cashFlowPaths).hasSize(aModel.getCountSimulation());
		assertThat(cashFlowPaths.get(4).getValues()).isEqualTo(1);

	}

	@Test
	public void plotPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		InterestsPathFactory interestsPathFactory = new InterestsPathFactory(aModel, shortratePaths);
		List<InterestsPath> paths = interestsPathFactory.generateAllPaths();

		CashflowPathFactory cashflowPathFactory = new CashflowPathFactory(aModel, paths);
		List<CashflowPath> cashFlowPaths = cashflowPathFactory.generateAllPaths();

		PathPlotter.plotCashFlow(cashFlowPaths);
	}

}
