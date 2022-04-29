package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configuration.PathConfiguration;

public class Baseclass{
	
	public WebDriver Chrome()
	{

		System.setProperty("webdriver.chrome.driver", PathConfiguration.Chromedriver);
		WebDriver driver=new ChromeDriver();		
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver firefox()
	{
		System.setProperty("webdriver.gecko.driver", PathConfiguration.FirefoxDriver);
		WebDriver driver=new FirefoxDriver();		
		driver.manage().window().maximize();
		return driver;
	}
	 

}
