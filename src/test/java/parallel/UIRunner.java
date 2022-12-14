package parallel;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import driverfactory.BrowserType;
import driverfactory.DriverFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
//import utilitiesFiles.CommonUtilities;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/parallel", glue = "parallel", monochrome = true, plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
		"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "rerun:target/failedrerun.txt" }, publish = true
//tags="@Service_Operations"
)

public class UIRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public static WebDriver driver2;

	public static String Device_name;
	private static List<WebDriver> driverPool = new ArrayList<WebDriver>();

	@BeforeSuite

	void setUpSuite() {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
	}

	public static WebDriver getDriver(BrowserType type) {

		driver = DriverFactory.getInstance().getDriver(type);
		driverPool.add(driver);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getDriver1() {
		driver = DriverFactory.getInstance().getDriver1();
		driverPool.add(driver);
		return driver;
	}

	@Parameters("browser")
	@BeforeMethod
	public void config_driver(String browser) throws IOException {

		// String device = Config.projectconfig_Values("Browser");

		if (browser.equalsIgnoreCase("chrome")) {
			// PageObjectAddToCart.CartInstance=null;
			Device_name = browser;
			getDriver(BrowserType.CHROME);

		} else if (browser.equalsIgnoreCase("firefox")) {

			Device_name = browser;
			getDriver(BrowserType.FIREFOX);

		} else if (browser.equalsIgnoreCase("edge")) {

			Device_name = browser;
			getDriver(BrowserType.Edge);

		}
	}

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = false) public Object[][] scenarios() { return
	 * super.scenarios();
	 * 
	 * }
	 */

	public static void takeScreenshot() throws Exception {
		String GetFilepath = GetCurrentWorkingDirectory("src/main/resources");
//	    System.out.println(GetFilepath);

		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		screenShotName = new File(GetFilepath + timeStamp + ".png");
		FileUtils.copyFile(scrFile, screenShotName);

		String filePath = screenShotName.toString();
		String path = ("<br><img src='" + screenShotName + "' height='700' width='900'/><br>");
		Reporter.log(path);
	}

	@AfterSuite
	public void Report() throws Exception {
		if (driver != null) {
			for (WebDriver webDriver : driverPool) {
				// webDriver.quit();
			}
		}
	}

	public static String GetCurrentWorkingDirectory(String Filename) {
		String userDirectory = new File(Filename).getAbsolutePath();
		System.out.println(userDirectory);
		return userDirectory;
	}

}
