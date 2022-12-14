package parallel;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.appender.FileManager;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constantsFiles.Constants;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjectsFiles.PageObject;
//import webdriverManager.DriverManager;

public class Login extends UIRunner {
	WebDriver driver = getDriver1();

	PageObject pageobj;
	public static org.apache.log4j.Logger logger;
	public void setup() throws IOException {

		logger=Logger.getLogger("CloudApp");
	
		PropertyConfigurator.configure("log4j.properties");
		
	}
	

	
	
	@Given("User enters the website through URL https:\\/\\/cloudstudio.visionet.com\\/Login")
	public void user_enters_the_website_through_url_https_cloudstudio_visionet_com_login() throws IOException {
		setup();
		
		
			driver.get("https://cloudstudio.visionet.com/Login");
		
			driver.manage().window().maximize();
			logger.info(" Url is opened");

		} 
	
	
	

@When("User fills the Username and Password from given {string} and {string}")
public void user_fills_the_username_and_password_from_given_and(String Username, String Password) throws InterruptedException, IOException {
	
	pageobj = new PageObject(driver);
	pageobj.Username.sendKeys(Username);
	Thread.sleep(2000);
	logger.info("User enters username");
	pageobj.password.sendKeys(Password);
	logger.info("User enters Password");
	Thread.sleep(4000);
}

@When("User clicks on Login button")
public void user_clicks_on_login_button() throws InterruptedException, IOException {

	pageobj.Login.click();
	Thread.sleep(3000);
	logger.info("User clicks on login button");
}
	
/*
 * @Then("User clicks on AWS") public void user_clicks_on_aws() throws
 * InterruptedException {
 * 
 * 
 * //WebElement
 * dropdown1=driver.findElement(By.xpath("//li[contains(text(),' AWS ')]"));
 * WebElement Dropdown=driver.findElement(By.xpath(
 * "/html/body/div[1]/div[2]/header/div/div[2]/button[1]")); Actions act=new
 * Actions(driver); act.moveToElement(Dropdown).click().perform();
 * //act.moveToElement(dropdown1).click().perform(); List<WebElement>
 * options=Dropdown.findElements(By.xpath("//li[@role='menuitem']"));
 * 
 * System.out.println(options.size());
 */
		/*
		 * WebElement
		 * AWS=driver.findElement(By.xpath("//li[contains(text(),' AWS ')]"));
		 * WebElement
		 * Azure=driver.findElement(By.xpath("//li[contains(text(),' Azure ')]"));
		 * WebElement
		 * GCP=driver.findElement(By.xpath("//li[contains(text(),' GCP ')]"));
		 */
	 
	
		/*
		 * Actions act=new Actions(driver);
		 * act.moveToElement(Dropdown).
		 * Thread.sleep(2000);
		 * 
		 */
		
		/*
		 * List<WebElement> dropdown1=
		 * driver.findElements(By.xpath("//li[contains(text(),' AWS ')]"));
		 */
	  
	  //act.moveToElement(dropdown1).click().build().perform(); 
	  //List<WebElement> dropdown2= driver.findElements(By.xpath("//li[contains(text(),' Azure ')]"));
	  //act.moveToElement((WebElement) dropdown1).click().build().perform();
	 	 
/*
		 * act.moveToElement(AWS).click().build().perform();
		 * act.moveToElement(Dropdown).build().perform();
		 * act.moveToElement(Azure).build().perform();
		 * act.moveToElement(GCP).click().build().perform();
		 */
	 


}



	
	
	
	


