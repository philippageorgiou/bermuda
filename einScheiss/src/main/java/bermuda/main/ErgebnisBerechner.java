package bermuda.main;

import static org.apache.commons.math3.random.RandomGeneratorFactory.createRandomGenerator;

import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

public class ErgebnisBerechner {

	private ParameterModel parameterModel;
	private ShortratePathFactory shortratePathFactory;

	public ErgebnisBerechner(ParameterModel parameterModel) {
		this.parameterModel = parameterModel;
		RandomGenerator randomGenerator = createRandomGenerator(new Random(parameterModel.getSeedSimulation()));
		shortratePathFactory = new ShortratePathFactory(parameterModel, new GaussianRandomGenerator(randomGenerator));
	}

	public Ergebnis berechne() {
		List<ShortratePath> shortratePaths = shortratePathFactory.generateAllPaths();

		List<InterestsPath> interestsPaths = new InterestsPathFactory(parameterModel, shortratePaths)
				.generateAllPaths();
		List<CashflowPath> cashflowPaths = new CashflowPathFactory(parameterModel, interestsPaths).generateAllPaths();
		double callableBond = new MonteCarlo(parameterModel, cashflowPaths).generateCallableBond();
		return new Ergebnis(shortratePaths, interestsPaths, cashflowPaths, callableBond);
	}

}
