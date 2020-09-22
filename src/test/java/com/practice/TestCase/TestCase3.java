package com.practice.TestCase;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.base.TestBase;
import com.practice.utility.Utility;

public class  TestCase3 extends TestBase {
// new arrival opens new tab and user is able to add item to basket
	public TestCase3() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public void newarraival_itemclick() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Shop")).click();
		WebDriverWait wait1= new WebDriverWait(driver,50);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		
		driver.findElement(By.linkText("Home")).click();
		WebDriverWait wait2= new WebDriverWait(driver,50);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]")));
		
		WebElement newarrival_slide=driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", newarrival_slide);
		WebDriverWait wait3= new WebDriverWait(driver,50);
		java.util.List<WebElement> slide_item= newarrival_slide.findElements(By.tagName("li"));
		SoftAssert sa= new SoftAssert();
		logger=reports.createTest("New Arrival Navigation");
		for (int i=0;i<slide_item.size();i++)
		{
			//System.out.println("This is stock"+ i);
			//slide_item.get(i).click();
			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div["+(i+1)+"]/div/div/ul/li/a[1]/img")).click();
			Thread.sleep(1000);
			Date d= new Date();
			try
			{
				sa.assertFalse("http://practice.automationtesting.in/".equals(driver.getCurrentUrl()), "Navigated to different site");
				//sa.assertFalse("http://practice.automationtesting.in/".equals(driver.getCurrentUrl()), "Navigated to different site");
				sa.assertAll();
				//logger.pass("New Arrival Navigation pass");
				
				String item=driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[1]")).getText();
				String s[]=item.split(" ");
				int cnt=Integer.parseInt(s[0]);
				System.out.println("Cart item"+cnt);
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				String item1=driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[1]")).getText();
				String s1[]=item.split(" ");
				int cnt1=Integer.parseInt(s1[0]);
				if(cnt1-cnt==0)
				{
					logger.pass("Item added successfully "+(i+1));
				}
			}
			catch(AssertionError e)
			{
				System.out.println("failed");
				logger.fail("Stock is not navigating to different URL");
				Utility.getScreenshot(driver,"NewArrivalnavigation");
				logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\NewArrivalnavigation"+d.getDate()+".png");
				
			}
			driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();
			//driver.navigate().back();
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}
		
		driver.close();	
		}
		
}
