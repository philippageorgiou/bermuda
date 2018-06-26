package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

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

	@Before
	public void setUp() {
		RandomGenerator randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random(SEED));
		generator = new GaussianRandomGenerator(randomGenerator);
	}

	@Test
	public void generateAllPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		InterestsPathFactory interestsPathFactory = new InterestsPathFactory(aModel, generator);
		List<InterestsPath> paths = interestsPathFactory.generateAllPaths();

		CashflowPathFactory cashflowPathFactory = new CashflowPathFactory(aModel, paths);
		List<CashflowPath> cashFlowPaths = cashflowPathFactory.generateAllPaths();

		assertThat(cashFlowPaths).hasSize(aModel.getCountSimulation());
		assertThat(cashFlowPaths.get(4).getValues()).isEqualTo(1);

	}

	private List<CashflowPath> generatePaths(ParameterModel aModel) {
		InterestsPathFactory shortrateVasicek = new InterestsPathFactory(aModel, generator);
		List<InterestsPath> paths = shortrateVasicek.generateAllPaths();

		CashflowPathFactory cashflowPathFactory = new CashflowPathFactory(aModel, paths);
		List<CashflowPath> cashFlowPaths = cashflowPathFactory.generateAllPaths();

		return cashFlowPaths;
	}

	@Test
	public void plotPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		List<CashflowPath> paths = generatePaths(aModel);

		PathPlotter.plotCashFlow(paths);
	}

}
