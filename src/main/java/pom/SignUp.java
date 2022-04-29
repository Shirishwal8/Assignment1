package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	
	

	@FindBy (xpath="//*[@id='language']/div[1]/span") private WebElement language; 
	
	@FindBy (xpath="//div [text()='English']") private WebElement Eng;
	
	@FindBy (xpath="//div [text()='Dutch']") private WebElement Dutch;
	
	@FindBy (xpath="//input [@id='name']") private WebElement name; 

	@FindBy (xpath="//input [@id='orgName']") private WebElement orgName; 

	@FindBy (xpath="//input [@type='email']") private WebElement mail; 
	
	@FindBy (xpath="//span[text()='I agree to the']") private WebElement checkbox; 

	@FindBy (xpath="//button [@type='submit']") private WebElement submit; 
	
	
	public SignUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void setLanguage()
	{
		language.click();
	}
	
	public void setEng()
	{
		Eng.click();
	}
	
	public void setDutch()
	{
		Dutch.click();
	}
	
	public String getTextEnglish()
	{
		String act = Eng.getText();
		 return act ;
	}
	
	public String getTextDutch()
	{
		String act = Dutch.getText();
		return act;
	}
	
	public void setName(String Name)
	{
		name.sendKeys(Name);
	}
	
	public void setOrgName(String organisationName)
	{
		orgName.sendKeys(organisationName);
	}
	
	public void setMail(String mailId)
	{
		mail.sendKeys(mailId);
	}
	
	public void ClickCheckbox()
	{
		checkbox.click();
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
}
