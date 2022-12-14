package parallel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.appender.FileManager;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constantsFiles.Constants;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectsFiles.PageObject;
//import webdriverManager.DriverManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class Forgotpassword extends UIRunner{
	WebDriver driver = getDriver1();

	PageObject pageobj;

	public static org.apache.log4j.Logger logger;
	ExtentReports extent=new ExtentReports(); 
	  ExtentSparkReporter spark= new ExtentSparkReporter("/CloudApp/test-output/Extentreport.html");
	 
	
	public void logger() throws IOException {
		
		logger=Logger.getLogger("CloudApp");
		PropertyConfigurator.configure("log4j.properties");
			
	}
		
	
	@When("User clicks on Forgotpassword link")
	public void user_clicks_on_forgotpassword_link() throws Exception {
		

		logger(); 

		pageobj = new PageObject(driver);
		pageobj.forgotpwdlink.click();
		logger.info("User click on Forgot password link");
		
		Thread.sleep(3000);
		
		takeScreenshot();
	
	}

	@When("User fills the Email {string} for resetting the password")
	public void user_fills_the_email_for_resetting_the_password(String Email) throws Exception {
		
		Thread.sleep(2000);
		pageobj.EmailAddress.sendKeys(Email);
		Thread.sleep(2000);
		logger.info("User enters email");
		pageobj.sendreq.click();
		Thread.sleep(2000);
		logger.info("User clicks on send request button");
		Thread.sleep(3000);
		takeScreenshot();
	}

	@SuppressWarnings("deprecation")
	
	@Then("User gets the message {string}")
	public void user_gets_the_message(String expmsg) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		  WebElement errorMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='m-0 mt-5 text-center request-text mb-5']")));
		  errorMessage.getText();
		  String actualToastMessage = errorMessage.getText();
		 
		 if (expmsg.equals(actualToastMessage)) {
			  System.out.println("====================================" +
			  "Reset pwd Request is sent. The scenario is PASSED" +
			  "===================================="); } else {
			  System.out.println("====================================" +
			  "Reset pwd Request is not sent The scenario is FAILED" +
			  "===================================="); }
		 
		 Thread.sleep(3000);
			 
		 takeScreenshot();
	}
	

	@Then("User navigates to login screen")
	public void user_navigates_to_login_screen() {
		driver.get("https://cloudstudio.visionet.com/Login");
	
	}
	
}
