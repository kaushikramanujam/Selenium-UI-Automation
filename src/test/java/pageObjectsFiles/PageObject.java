package pageObjectsFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base_Page;
import junit.framework.Assert;
//import utilitiesFiles.CommonUtilities;
//import webdriverManager.DriverManager;

public class PageObject extends Base_Page {

	public PageObject(WebDriver driver) {

		super(driver);

	}
	
	@FindBy(xpath ="/html/body/div[2]/div/div/ul")
	public WebElement Dropdown ;
	
	@FindBy(xpath ="/html/body/div[2]/div/div/ul/li[1]")
	public WebElement AWS ;

	@FindBy(xpath ="/html/body/div[2]/div/div/ul/li[2]")
	public WebElement Azure ;
	
	@FindBy(xpath ="/html/body/div[2]/div/div/ul/li[3]")
	public WebElement GCP ;

	// Forget Password Objects

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement Username ;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement password;

	@FindBy(xpath = "//button[@type='button']")
	public WebElement Login;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/div/form/div[3]/div/div[2]/a")
	public WebElement forgotpwdlink;
	
	//forgot pwd screen

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	public WebElement EmailAddress;

	
	@FindBy(xpath = "//button[@type='button']")
	public WebElement sendreq;

	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/div/div/div/div[1]/p/text()")
	public WebElement password_reset_message;

	
}
