package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import configuration.PathConfiguration;

public class Utility {
	
	public String ExcelData(int row,int cell) throws EncryptedDocumentException, IOException
	{

		FileInputStream file=new FileInputStream(PathConfiguration.ExcelsheetPath);
		String value=null;
		   Sheet sel = WorkbookFactory.create(file).getSheet("Sheet1");
		 try {
		  value = sel.getRow(row).getCell(cell).getStringCellValue();
		 
		 }
		 catch(Exception e)
		 {
			 long val=(long) sel.getRow(row).getCell(cell).getNumericCellValue();
			 
			  value=Long.toString(val);
		 }
		return value;
	}
	
	public static void Screenshot(WebDriver driver,String tcID) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		Date d=new Date();
		String date = d.toString().replace(":", "_");
		File save=new File("C:\\Users\\HP\\eclipse-workspace\\Assignment\\target\\Screenshot\\img"+date+"_"+tcID+".jpg");
		FileHandler.copy(scr, save);
		
	}
	
		
		

}
