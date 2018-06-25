package einScheiss.main;

import com.opencsv.bean.CsvBindByName;

public class ParameterModel {
	public int getCountSimulation() {
		return countSimulation;
	}

	public void setCountSimulation(int countSimulation) {
		this.countSimulation = countSimulation;
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
		super();
		this.countSimulation = countSimulation;
		this.startShortrate = startShortrate;
		this.meanShortrate = meanShortrate;
		this.reversionSpeedShortrate = reversionSpeedShortrate;
		this.volatilityShortrate = volatilityShortrate;
		this.durationCallableBond = durationCallableBond;
		this.couponRateCallableBond = couponRateCallableBond;
		this.faceValueCallableBond = faceValueCallableBond;
	}

	@CsvBindByName(column = "Count_Simulation")
	private int countSimulation;

	@CsvBindByName(column = "Start_Shortrate")
	private double startShortrate;

	@CsvBindByName(column = "Mean_Shortrate")
	private double meanShortrate;

	@CsvBindByName(column = "Reversion_Speed_Shortrate")
	private double reversionSpeedShortrate;

	@CsvBindByName(column = "Volatility_Shortrate")
	private double volatilityShortrate;

	@CsvBindByName(column = "Duration_Callable_Bond")
	private int durationCallableBond;

	@CsvBindByName(column = "Coupon_Rate_Callable_Bond")
	private double couponRateCallableBond;

	@CsvBindByName(column = "Face_Value_Callable_Bond")
	private double faceValueCallableBond;

}
