package FinalFrame.FinalMyntra;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


import resources.myntrabase;

public class homepage extends myntrabase
{
	 public static Logger log =LogManager.getLogger(myntrabase.class.getName());
	@Test(priority = 0)
	public void baseNavigation() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get("https://www.myntra.com/");
		 log.info("text");
	}
	@Test(priority = 1)
	public void womenpage()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Women')]")).click();
		
	}
	
	@Test(priority = 3)
	public void selectSection() throws InterruptedException
	{
		Actions aa = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("//header/div[2]/nav[1]/div[1]/div[2]/div[1]/a[1]"));
		WebElement kurta=driver.findElement(By.xpath("//a[contains(text(),'Kurtas & Suits')]"));
		aa.moveToElement(women).moveToElement(kurta).click().build().perform();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void sortingwhats() throws InterruptedException
	{   Actions bb = new Actions(driver);
		WebElement sort=driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		bb.moveToElement(sort);
		WebElement what=driver.findElement(By.xpath("//label[normalize-space()=\"What's New\"]"));
		bb.moveToElement(what).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[3]/ul[1]/li[1]/label[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/main[1]/div[3]/div[1]/section[1]/div[1]/div[4]/ul[1]/li[1]/label[1]")).click();
		driver.findElement(By.xpath("//label[normalize-space()='20% and above']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[1]//a[1]//div[2]//div[1]//span[1]//span[1]")).click();
	}
	
	@Test(priority = 5)
	public void productselection() throws InterruptedException
	{
		Set<String> srr = driver.getWindowHandles();

		Iterator<String> iter = srr.iterator();

		String parentid = iter.next();
		String childid = iter.next();

		driver.switchTo().window(childid);
		driver.findElement(By.xpath("//p[@class='size-buttons-unified-size']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
		Thread.sleep(2000);
		Actions cc = new Actions(driver);
		WebElement s1=driver.findElement(By.xpath("//body/div[contains(@class,'layout')]/div[@id='mountRoot']/div[@id='appContent']/div[contains(@class,'')]/div/div/div/div[contains(@class,'desktop-base-cartLayout')]/div[contains(@class,'itemBlock-base-leftBlock')]/div[@id='cartItemsList']/div[contains(@class,'itemContainer-base-itemMargin')]/div/div[contains(@class,'item-base-item')]/div[contains(@class,'itemContainer-base-item')]/div[contains(@class,'itemContainer-base-itemRight')]/div[contains(@class,'itemContainer-base-details')]/div[1]"));
		if(s1.isDisplayed()) {
			System.out.println("product is present in bag");
		}else {
			System.out.println("product is not present in bag");
		}
		Thread.sleep(3000);
		try {
			WebElement wish =driver.findElement(By.xpath("//button[normalize-space()='Move to WishList']"));
			cc.doubleClick(wish).perform();
		}catch(Exception e){
			System.out.println("task is completed");
			
		}
		
		driver.quit();

	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

		
		
		
		
		

}
