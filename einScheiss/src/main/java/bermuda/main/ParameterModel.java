package bermuda.main;

import java.util.Arrays;

import com.opencsv.bean.CsvBindByName;

public class ParameterModel {

	@CsvBindByName(column = "SEED_SIMULATION")
	private long seedSimulation;
	@CsvBindByName(column = "COUNT_SIMULATION")
	private int countSimulation;
	@CsvBindByName(column = "START_SHORTRATE")
	private double[] startShortrate;
	@CsvBindByName(column = "MEAN_SHORTRATE")
	private double meanShortrate;
	@CsvBindByName(column = "REVERSION_SPEED_SHORTRATE")
	private double reversionSpeedShortrate;
	@CsvBindByName(column = "VOLATILITY_SHORTRATE")
	private double volatilityShortrate;
	@CsvBindByName(column = "DURATION_CALLABLE_BOND")
	private int durationCallableBond;
	@CsvBindByName(column = "COUPON_RATE_CALLABLE_BOND")
	private double couponRateCallableBond;
	@CsvBindByName(column = "FACE_VALUE_CALLABLE_BOND")
	private double faceValueCallableBond;
	@CsvBindByName(column = "INTEREST_TO_SHORTRATE_SCALE")
	private int interestToShortrateScale;

	public int getCountSimulation() {
		return countSimulation;
	}

	public void setCountSimulation(int countSimulation) {
		this.countSimulation = countSimulation;
	}

	public double[] getStartShortrate() {
		return startShortrate;
	}

	public void setStartShortrate(double[] startShortrate) {
		this.startShortrate = startShortrate;
	}

	public double getMeanShortrate() {
		return meanShortrate;
	}

	public void setMeanShortrate(double meanShortrate) {
		this.meanShortrate = meanShortrate;
	}

	public double getReversionSpeedShortrate() {
		return reversionSpeedShortrate;
	}

	public void setReversionSpeedShortrate(double reversionSpeedShortrate) {
		this.reversionSpeedShortrate = reversionSpeedShortrate;
	}

	public double getVolatilityShortrate() {
		return volatilityShortrate;
	}

	public void setVolatilityShortrate(double volatilityShortrate) {
		this.volatilityShortrate = volatilityShortrate;
	}

	public int getDurationCallableBond() {
		return durationCallableBond;
	}

	public void setDurationCallableBond(int durationCallableBond) {
		this.durationCallableBond = durationCallableBond;
	}

	public double getCouponRateCallableBond() {
		return couponRateCallableBond;
	}

	public void setCouponRateCallableBond(double couponRateCallableBond) {
		this.couponRateCallableBond = couponRateCallableBond;
	}

	public double getFaceValueCallableBond() {
		return faceValueCallableBond;
	}

	public void setFaceValueCallableBond(double faceValueCallableBond) {
		this.faceValueCallableBond = faceValueCallableBond;
	}

	public long getSeedSimulation() {
		return seedSimulation;
	}

	public void setSeedSimulation(long seedSimulation) {
		this.seedSimulation = seedSimulation;
	}

	public ParameterModel() {
	}

	public ParameterModel(long seedSimulation, int countSimulation, double[] startShortrate, double meanShortrate,
			double reversionSpeedShortrate, double volatilityShortrate, int durationCallableBond,
			double couponRateCallableBond, double faceValueCallableBond, int interestToShortrateScale) {
		this.countSimulation = countSimulation;
		this.startShortrate = startShortrate;
		this.meanShortrate = meanShortrate;
		this.reversionSpeedShortrate = reversionSpeedShortrate;
		this.volatilityShortrate = volatilityShortrate;
		this.durationCallableBond = durationCallableBond;
		this.couponRateCallableBond = couponRateCallableBond;
		this.faceValueCallableBond = faceValueCallableBond;
		this.interestToShortrateScale = interestToShortrateScale;
		this.seedSimulation = seedSimulation;
	}

	public static ParameterModel aModel() {
		int interestToShortrateScale2 = 360;
		int durationCallableBond2 = 5;
		double[] startShortrates = new double[(1 + durationCallableBond2) * interestToShortrateScale2];
		Arrays.fill(startShortrates, 1);
		return new ParameterModel(10, 10, startShortrates, 0.04, 3, 0.2, durationCallableBond2, 0.10, 10000,
				interestToShortrateScale2);
	}

	@Override
	public String toString() {
		return "ParameterModel [seedSimulation=" + seedSimulation + ", countSimulation=" + countSimulation
				+ ", startShortrate=" + Arrays.toString(startShortrate) + ", meanShortrate=" + meanShortrate
				+ ", reversionSpeedShortrate=" + reversionSpeedShortrate + ", volatilityShortrate="
				+ volatilityShortrate + ", durationCallableBond=" + durationCallableBond + ", couponRateCallableBond="
				+ couponRateCallableBond + ", faceValueCallableBond=" + faceValueCallableBond
				+ ", interestToShortrateScale=" + interestToShortrateScale + "]";
	}

	public int getInterestToShortrateScale() {
		return interestToShortrateScale;
	}

	public void setInterestToShortrateScale(int interestToShortrateScale) {
		this.interestToShortrateScale = interestToShortrateScale;
	}

	public boolean isLastYear(int j) {
		return j == durationCallableBond - 1;
	}
}
