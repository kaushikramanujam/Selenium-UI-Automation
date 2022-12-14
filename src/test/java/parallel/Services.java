package parallel;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectsFiles.PageObject;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.appender.FileManager;

import org.apache.log4j.PropertyConfigurator;

public class Services extends UIRunner {
	WebDriver driver = getDriver1();

	PageObject pageobj;
	public static org.apache.log4j.Logger logger;
	public void logger() {
	
	logger=Logger.getLogger("CloudApp");
	PropertyConfigurator.configure("log4j.properties");
	}
	
	@When("User clicks on Service operations from the navigation menu")
	public void user_clicks_on_service_operations_from_the_navigation_menu() throws InterruptedException {
		logger();
	
		 //service operations
	     driver.findElement(By.xpath("//div[@class='c-app']//ul//li[2]//a[@href='/service-operation']")).click();
	 	logger.info(" User clicks on service operations from the navigation menu");
	        Thread.sleep(5000);
	        boolean status=driver.findElement(By.xpath("//h1[text()='Service Operations']")).isDisplayed();
	        if(status==true)
	        {
	            System.out.println("==================="+"Service operation page is displayed"+"=====================");
	        }
	        else
	        {
	            System.out.println("===================="+"Service operation page is not displayed"+"=================");
	        }
	        
	   
	}

	@When("User clicks on Service managements")
	public void user_clicks_on_service_managements() throws InterruptedException {

		
		//service management
        
	       driver.findElement(By.xpath("//div[@class='c-app']//ul//li[3]//a[@href='/service-management']")).click();
	        Thread.sleep(5000);
	        
	        logger.info(" User clicks on Service managements  from the navigation menu");
	        boolean status=driver.findElement(By.xpath("//h1[text()='JIRA Dashboard']")).isDisplayed();
	        if(status==true)
	        {
	            System.out.println("================="+"Service management page is displayed"+"=====================");
	        }
	        else
	        {
	            System.out.println("================"+"Service management  page is not displayed"+"==================");
	        }
	        
	   
	}
	
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"line-chart\"]")));

	@When("User clicks on Financial Governance")
	public void user_clicks_on_financial_governance() throws InterruptedException {
		
		
		//FinancialGovernance
		
		  driver.findElement(By.xpath("//div[@class='c-app']//ul//li[4]//a[@href='/financial-governance']")).click();
	        Thread.sleep(3000);
	        logger.info(" User clicks on Financial Governance from the navigation menu");
	        boolean status=driver.findElement(By.xpath("//h1[text()='Financial Governance']")).isDisplayed();
	        if(status==true)
	        {
	            System.out.println("===================="+"Financial Governance page is displayed"+"===================");
	        }
	        else
	        {
	            System.out.println("================="+"Financial Governance page is not displayed"+"=================");
	        }
	    
	}

	@Then("User is navigated to Reports")
	public void user_is_navigated_to_reports() throws InterruptedException {
		
		
		
		WebElement slider=driver.findElement(By.xpath("//div[@class='ps__thumb-y']"));
		Actions move=new Actions(driver);
		move.dragAndDropBy(slider, 0, 300).build().perform();
		
		  driver.findElement(By.xpath("//div[@class='c-app']//ul//li[8]//a[@href='/report']")).click();
		  Thread.sleep(2000);
	        logger.info(" User clicks on Reports  from the navigation menu");
		  boolean status=driver.findElement(By.xpath("//h1[@class='operations-title m-0']")).isDisplayed();
		  if(status==true)
	        {
	            System.out.println("Reports page is displayed");
	        }
	        else
	        {
	            System.out.println("Reports page is not displayed");
	        }
		  
		
	   
	}

	@Then("User clicks on specific report")
	public void user_clicks_on_specific_report() throws InterruptedException {
		
		
		
		
		Thread.sleep(5000);
		
		WebElement specificrep=driver.findElement(By.xpath("//div[text()='VM Disk Usage']"));
		//div[text()='VMs with Volume Free Space > 50% by Department']
		Thread.sleep(2000);
		specificrep.click();
	}
	@When("User Click on Logout button")
	public void user_navigates_to_account_section() throws InterruptedException {
		
		
		Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div/div[2]/ul/li[2]/a/div/img")).click();
	   Thread.sleep(2000);
	   
	   
	   driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div/div[2]/ul/li[2]/div/a[2]")).click()	;
	   logger.info(" User clicks on logout button");
	   
	   }

	   
	

	@Then("User is navigated to Login screen")
	public void user_is_navigated_to_login_screen() {
		
		boolean status=driver.findElement(By.xpath("//h1[text()='Log In to Your Account']")).isDisplayed();
	    if(status==true)
	    {
	    	System.out.println("================"+"User is successfully logged out  from the application"+"=================");
	    	
	    }
	    else
	    {
	    	System.out.println("==============="+"logout scenario is failed"+"====================");
	    }
	}
	

}
