package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandWomenpage 
{
public WebDriver driver;
	
	By womenpage=By.xpath("//a[contains(text(),'Women')]");
	By kurta=By.xpath("//a[contains(text(),'Kurtas & Suits')]");
	
	
	

	public LandWomenpage(WebDriver driver) 
	{
		this.driver=driver;
	}

	

	
	
	public WebElement getwomenP()
	{
		return driver.findElement(womenpage);
	}
	
	
	public WebElement getkurta()
	{
		return driver.findElement(kurta);
	}
	
   

}
