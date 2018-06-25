package bermuda.main;

import com.opencsv.bean.CsvBindByName;

public class ParameterModel {

	public int getCountSimulation() {
		return countSimulation;
	}

	public void setCountSimulation(int countSimulation) {
		this.countSimulation = countSimulation;
	}

	public ParameterModel() {
	}

	public double getStartShortrate() {
		return startShortrate;
	}

	public void setStartShortrate(double startShortrate) {
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

	public ParameterModel(int countSimulation, double startShortrate, double meanShortrate,
			double reversionSpeedShortrate, double volatilityShortrate, int durationCallableBond,
			double couponRateCallableBond, double faceValueCallableBond) {
		this.countSimulation = countSimulation;
		this.startShortrate = startShortrate;
		this.meanShortrate = meanShortrate;
		this.reversionSpeedShortrate = reversionSpeedShortrate;
		this.volatilityShortrate = volatilityShortrate;
		this.durationCallableBond = durationCallableBond;
		this.couponRateCallableBond = couponRateCallableBond;
		this.faceValueCallableBond = faceValueCallableBond;
	}

	@CsvBindByName(column = "COUNT_SIMULATION")
	private int countSimulation;

	@CsvBindByName(column = "START_SHORTRATE")
	private double startShortrate;

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

	public static ParameterModel aModel() {
		return new ParameterModel(1, 2, 3, 4, 5, 6, 7, 8);
	}

	@Override
	public String toString() {
		return "ParameterModel [countSimulation=" + countSimulation + ", startShortrate=" + startShortrate
				+ ", meanShortrate=" + meanShortrate + ", reversionSpeedShortrate=" + reversionSpeedShortrate
				+ ", volatilityShortrate=" + volatilityShortrate + ", durationCallableBond=" + durationCallableBond
				+ ", couponRateCallableBond=" + couponRateCallableBond + ", faceValueCallableBond="
				+ faceValueCallableBond + "]";
	}

}
