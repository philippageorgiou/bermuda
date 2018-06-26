package bermuda.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CashflowAllPathsTest {

	private InterestsAllPaths interestsAllPaths;

	@Test
	public void getValues() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		CashflowAllPaths cashflowAllPaths = new CashflowAllPaths(aModel, interestsAllPaths);
		CashflowPath path = cashflowAllPaths.generatePath();
		double[] values = path.getValues();
		assertThat(values).hasSize(aModel.getDurationCallableBond() + 1);

	}

	@Test
	public void generateAllPaths() throws Exception {
		ParameterModel aModel = ParameterModel.aModel();
		CashflowAllPaths cashflowAllPaths = new CashflowAllPaths(aModel, interestsAllPaths);
		List<CashflowPath> paths = CashflowAllPaths.generateAllPaths();
		assertThat(paths).hasSize(aModel.getCountSimulation());

	}

}
