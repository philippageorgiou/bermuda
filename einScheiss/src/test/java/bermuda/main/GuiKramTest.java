package bermuda.main;

import org.junit.Test;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.layout.StripeLayout;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.NamedPlotColor;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.utils.Debug;

public class GuiKramTest {
	@Test
	public void minimalBeispiel() throws Exception {
		JavaPlot p = new JavaPlot();
		p.addPlot("sin(x)");
		p.plot();
	}

	@Test
	public void javaPlot3DTest() throws Exception {
		JavaPlot p = new JavaPlot();
		JavaPlot.getDebugger().setLevel(Debug.VERBOSE);

		p.setTitle("Default \"Terminal Title\"");
		p.getAxis("x").setLabel("X axis", "Arial", 20);
		p.getAxis("y").setLabel("Y axis");

		p.getAxis("x").setBoundaries(-30, 20);
		p.setKey(JavaPlot.Key.TOP_RIGHT);

		double[][] plot = { { 1, 1.1 }, { 2, 2.2 }, { 3, 3.3 }, { 4, 4.3 } };
		DataSetPlot s = new DataSetPlot(plot);
		p.addPlot(s);
		p.addPlot("besj0(x)*0.12e1");
		PlotStyle stl = ((AbstractPlot) p.getPlots().get(1)).getPlotStyle();
		stl.setStyle(Style.POINTS);
		stl.setLineType(NamedPlotColor.GOLDENROD);
		stl.setPointType(5);
		stl.setPointSize(8);
		p.addPlot("sin(x)");

		p.newGraph();
		p.addPlot("sin(x)");

		p.newGraph3D();
		double[][] plot3d = { { 1, 1.1, 3 }, { 2, 2.2, 3 }, { 3, 3.3, 3.4 }, { 4, 4.3, 5 } };
		p.addPlot(plot3d);

		p.newGraph3D();
		p.addPlot("sin(x)*sin(y)");

		p.setMultiTitle("Global test title");
		StripeLayout lo = new StripeLayout();
		lo.setColumns(9999);
		p.getPage().setLayout(lo);
		p.plot();

	}

	@Test
	public void new3DPlot() throws Exception {
		JavaPlot p = new JavaPlot();
		p.newGraph3D();
		double[][] plot3d = { { 1, 1.1, 3 }, { 2, 2.2, 3 }, { 3, 3.3, 3.4 }, { 4, 4.3, 5 } };
		p.addPlot(plot3d);
		p.plot();
	}
}
