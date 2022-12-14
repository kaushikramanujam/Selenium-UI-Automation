/*
 * package parallel; import java.io.File; import java.io.IOException; import
 * java.text.SimpleDateFormat; import java.util.Calendar;
 * 
 * import org.apache.commons.io.FileUtils; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * import org.openqa.selenium.WebDriver; import org.testng.Assert; import
 * org.testng.Reporter; import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.AfterTest; import org.testng.annotations.BeforeMethod;
 * import org.testng.annotations.BeforeSuite; import
 * org.testng.annotations.BeforeTest; import org.testng.annotations.Test;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.MediaEntityBuilder; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.reporter.ExtentSparkReporter;
 * 
 * 
 * public class Testngreport { //static WebDriver driver ;
 * 
 * 
 * 
 * 
 * 
 * ExtentReports ex = new ExtentReports(); ExtentSparkReporter spark = new
 * ExtentSparkReporter("Extentreport.html");
 * 
 * 
 * 
 * 
 * @Test(priority=1) public void loginPageTitleTest() throws Exception{
 * 
 * 
 * 
 * 
 * ExtentTest test =
 * ex.createTest("Validate Login page title display").assignAuthor("Bhuvana")
 * .assignCategory("SmokeTest").assignDevice("Chrome"); test.log(Status.PASS,
 * "Login page displayed.");
 * test.pass("Browser Launched and navigated to Login page");
 * 
 * getDriver1();
 * 
 * Thread.sleep(1000); //Wait for the results to appear Thread.sleep(2000);
 * takeScreenshot(); //Assert.assertEquals(title,
 * "Free CRM software for customer relationship management, sales, marketing campaigns and support."
 * ); }
 * 
 * @Test(priority=2) public void crmLogoImageTest() throws Exception{
 * 
 * ExtentTest test = ex.createTest("Validate CRM Image").assignAuthor("Bhuvana")
 * .assignCategory("Regression").assignDevice("Edge"); test.log(Status.PASS,
 * "Image displayed"); test.pass("validated CRM Image displayed");
 * 
 * Thread.sleep(1000); //Wait for the results to appear Thread.sleep(2000);
 * takeScreenshot();
 * 
 * ex.attachReporter(spark); }
 * 
 * @Test(priority=3) public void loginTest() throws InterruptedException,
 * IOException{
 * 
 * ExtentTest test =
 * ex.createTest("Validate Login page with Valid details").assignAuthor(
 * "Bhuvana") .assignCategory("FunctionalTest").assignDevice("Safari");
 * test.log(Status.PASS, "Username & Password validated successfully");
 * test.pass("Login sucess"); String screenShotName = "ErrorScreenshot";
 * test.addScreenCaptureFromPath(System.getProperty("user.dir")
 * +"\\ErrorScreenshots\\"+screenShotName+".png"); ex.attachReporter(spark);
 * Thread.sleep(1000);
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * @AfterMethod public void tearDown(){ driver.quit(); }
 * 
 * @BeforeTest public void beforeTest() {
 * 
 * ex.attachReporter(spark); }
 * 
 * @AfterTest public void afterTest() {
 * 
 * driver.quit(); ex.flush();
 * 
 * } TESTNG Report public static void takeScreenshot() throws Exception {
 * 
 * String timeStamp; File screenShotName; File scrFile =
 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //The below
 * method will save the screen shot in d drive with name "screenshot.png"
 * timeStamp = new
 * SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
 * screenShotName = new File(
 * "C:\\Users\\Amrutha.TV\\signet-projects\\CloudApp3\\screenshots\\"+timeStamp+"
 * .png"); FileUtils.copyFile(scrFile, screenShotName);
 * 
 * String filePath = screenShotName.toString(); String path =
 * ("<br><img src='"+screenShotName+"' height='700' width='900'/><br>");
 * 
 * Reporter.log(path);
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 */