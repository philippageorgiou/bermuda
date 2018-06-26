package bermuda.main;

import java.util.List;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;

public class PathPlotter {

	public static void plotInterest(List<InterestsPath> paths) {
		JavaPlot p = new JavaPlot();
		PlotStyle myPlotStyle = new PlotStyle();
		myPlotStyle.setStyle(Style.LINES);
		p.newGraph3D();
		for (int j = 0; j < paths.size(); j++) {
			double[][] array = new double[paths.get(0).getValues().length][3];
			for (int i = 0; i < array.length; i++) {
				array[i] = new double[] { i, j, paths.get(j).getValues()[i] };
			}
			DataSetPlot s = new DataSetPlot(array);
			s.setPlotStyle(myPlotStyle);
			p.addPlot(s);
		}
		p.plot();
	}

	public static void plotShortrate(List<ShortratePath> paths) {
		JavaPlot p = new JavaPlot();
		PlotStyle myPlotStyle = new PlotStyle();
		myPlotStyle.setStyle(Style.LINES);
		p.newGraph3D();
		for (int j = 0; j < paths.size(); j++) {
			double[][] array = new double[paths.get(0).getValues().length][3];
			for (int i = 0; i < array.length; i++) {
				array[i] = new double[] { i, j, paths.get(j).getValues()[i] };
			}
			DataSetPlot s = new DataSetPlot(array);
			s.setPlotStyle(myPlotStyle);
			p.addPlot(s);
		}
		p.plot();
	}

	public static void plotCashFlow(List<CashflowPath> paths) {
		JavaPlot p = new JavaPlot();
		PlotStyle myPlotStyle = new PlotStyle();
		myPlotStyle.setStyle(Style.LINES);
		p.newGraph3D();
		for (int j = 0; j < paths.size(); j++) {
			double[][] array = new double[paths.get(0).getValues().length][3];
			for (int i = 0; i < array.length; i++) {
				array[i] = new double[] { i, j, paths.get(j).getValues()[i] };
			}
			DataSetPlot s = new DataSetPlot(array);
			s.setPlotStyle(myPlotStyle);
			p.addPlot(s);
		}
		p.plot();
	}
}
