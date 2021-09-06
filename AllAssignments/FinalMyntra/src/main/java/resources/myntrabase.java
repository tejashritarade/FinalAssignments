package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myntrabase 
{
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\FinalMyntra\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		
		
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals(browserName))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Downloads\\SeleniumFolder\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCasename+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;

		

	}

}
