package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.CorrelatedRandomVectorGenerator;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.junit.Test;

public class MathTest {

	private static final int SD = 1;
	private static final int MEAN = 0;
	private static final long SEED = 0;
	private static final double[] MEAN_VECTOR = { 0, 0, 0 };

	@Test
	public void LUDecomposition() throws Exception {
		RealMatrix coefficients = new Array2DRowRealMatrix(new double[][] { { 2, 3, -2 }, { -1, 7, 6 }, { 4, -3, -5 } },
				false);
		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(new double[] { 1, -2, 1 }, false);
		RealVector solution = solver.solve(constants);

		ArrayRealVector expectedVector = new ArrayRealVector(
				new double[] { -0.3698630137, 0.1780821918, -0.602739726 });
		assertThat(solution.toString()).isEqualTo(expectedVector.toString());
	}

	@Test
	public void useGaussDistribution() throws Exception {
		NormalDistribution distribution = new NormalDistribution(MEAN, SD);
		double lowerTail = distribution.cumulativeProbability(1); // P(X <= 1)
		double upperTail = 1.0 - distribution.cumulativeProbability(1); // P(X >= 1)

		assertThat(lowerTail).isEqualTo(0.841344746068543);
		assertThat(upperTail).isEqualTo(0.15865525393145696);
	}

	@Test
	public void gaussianRandomGenerator_YieldsRandomNumber_ForFixedSeed() throws Exception {
		RandomGenerator generator = RandomGeneratorFactory.createRandomGenerator(new Random(SEED));
		GaussianRandomGenerator gauﬂGenerator = new GaussianRandomGenerator(generator);
		double normalizedDouble = gauﬂGenerator.nextNormalizedDouble();
		assertThat(normalizedDouble).isEqualTo(0.8025330637390305);
	}

	@Test
	public void generateRandomVectorWithGivenGaussDistribution() throws Exception {
		RandomGenerator randomGenerator = RandomGeneratorFactory.createRandomGenerator(new Random(SEED));
		GaussianRandomGenerator rawGenerator = new GaussianRandomGenerator(randomGenerator);

		RealMatrix covariance = new Array2DRowRealMatrix(new double[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } },
				false);
		CorrelatedRandomVectorGenerator generator = new CorrelatedRandomVectorGenerator(MEAN_VECTOR, covariance,
				1.0e-12 * covariance.getNorm(), rawGenerator);

		double[] randomVector = generator.nextVector();
		assertThat(randomVector).isEqualTo(new double[] { 0.8025330637390305, -0.9015460884175122, 2.080920790428163 });
	}
}
