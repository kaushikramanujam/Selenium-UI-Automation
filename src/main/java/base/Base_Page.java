package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {

	public WebDriver driver;
	 public Properties configProp;
	public static org.apache.log4j.Logger logger;

	public Base_Page(WebDriver driver) {

		this.driver = driver;
		loadElements();
	}

	public void loadElements() {

		PageFactory.initElements(driver, this);
		

	}

}
