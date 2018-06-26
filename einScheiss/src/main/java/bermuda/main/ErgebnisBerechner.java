package bermuda.main;

import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;

public class ErgebnisBerechner {

	private ParameterModel parameterModel;
	private ShortratePathFactory shortratePathFactory;

	public ErgebnisBerechner(ParameterModel parameterModel, long seed) {
		this.parameterModel = parameterModel;
		RandomGenerator randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random(seed));
		GaussianRandomGenerator generator = new GaussianRandomGenerator(randomGenerator);
		shortratePathFactory = new ShortratePathFactory(parameterModel, generator);
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
