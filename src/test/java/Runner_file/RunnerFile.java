package Runner_file;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject_File.BaseClass;
import Utilitiy.ReadConfig;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "src/test/java/FeatureFile" }, glue = "StepDefination", plugin = {
		"Utilitiy.Step_Details" }, tags = "@Test")
public class RunnerFile extends BaseClass {
	// private BaseClass obj1;
	private TestNGCucumberRunner testng_cucumber_runner;

	@BeforeSuite
	public void extentReport() throws Throwable {
		BaseClass.spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + ReadConfig.get_from_config("extent_report_path"));
		BaseClass.extent.attachReporter(spark);

	}

	@AfterSuite
	public void extentFlush() {
		BaseClass.extent.flush();
	}

	@BeforeClass(alwaysRun = true)
	public void set_up_class() throws Throwable {
		testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumber_feature) {
		testng_cucumber_runner.runScenario(pickle.getPickle());
	}

	@DataProvider(name = "features")
	public Object[][] scenarios() {
		if (testng_cucumber_runner == null) {
			System.out.println("Runnner is returning null: dataprovider");
			testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
		} else {
			System.out.println("Runner is not null: dataprovider");
		}
		return testng_cucumber_runner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tear_down_class() throws Throwable {
		try {
			testng_cucumber_runner.finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
