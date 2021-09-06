package FinalFrame.FinalMyntra;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LandWomenpage;
import resources.myntrabase;

public class ValidateWomenName extends myntrabase
{
	public static Logger log =LogManager.getLogger(myntrabase.class.getName());
	@BeforeTest
	public void baseNavigation() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		 log.info("Driver is initialized");
		driver.get("https://www.myntra.com/");
		 log.info("text");
	}
	
	@Test
	public void validateName()
	{
		LandWomenpage l=new LandWomenpage(driver);
		l.getwomenP().click();
		l.getkurta().click();
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

}
