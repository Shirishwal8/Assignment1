package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.Baseclass;
import baseclass.Utility;
import configuration.EnvironmentConfig;
import pom.SignUp;

public class Tests extends Baseclass {
	
	private WebDriver driver;
	Utility util=new Utility();
	
	String tcID;
	
	@BeforeMethod
	public void launchBrowser()
	{
		 driver = Chrome();
		 driver.get(EnvironmentConfig.url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void validateEnglish_Dutch_Present() throws InterruptedException
	{
		tcID="TC01";
		SignUp input=new SignUp(driver);
		input.setLanguage();
		
		String actual = input.getTextEnglish();
		String expected="English";
		Assert.assertEquals(actual, expected);
		
		String actual1=input.getTextDutch();
		String expected1="Dutch";
		Assert.assertEquals(actual1, expected1);
		
		
		
	}
	
	@Test
	public void signUpWithFillingInformation() throws EncryptedDocumentException, IOException
	{
		tcID="TC02";
		
		SignUp input=new SignUp(driver);
		input.setLanguage();
		
		input.setEng();
		input.setName(util.ExcelData(1, 0));
		input.setOrgName(util.ExcelData(1, 1));
		input.setMail(util.ExcelData(1, 2));
		input.ClickCheckbox();
		input.clickSubmit();
		

		
	}
	
	@AfterMethod
	public void failedScreenShots(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			util.Screenshot(driver, tcID);
		}
		
		driver.close();
		
		
	}
	

}
