package bermuda.main;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class StatisticCalculator {

	public DescriptiveStatistics calculateStd(ShortratePath shortratePath) {
		DescriptiveStatistics stats = new DescriptiveStatistics();

		double[] values = shortratePath.getValues();
		for (int i = 0; i < values.length; i++) {
			stats.addValue(values[i]);
		}
		return stats;
	}

}
