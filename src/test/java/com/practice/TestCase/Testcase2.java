package com.practice.TestCase;

import java.awt.List;
import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.practice.base.TestBase;
import com.practice.utility.Utility;



public class Testcase2 extends TestBase {

	public Testcase2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	//Home page with 3 new arrivals
	@Test
	public void verifynewarrival() throws InterruptedException, IOException
	{
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
		
		SoftAssert a= new SoftAssert();
		
		logger=reports.createTest("New Arrival");
		try
		{
		a.assertEquals(4, slide_item.size());
		a.assertAll();
		logger.pass("New Arrival pass");
		}
		catch (AssertionError e)
  	{
			logger.fail("Fail new arrival");
			Date d=new Date();
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\NewArrival"+d.getDate()+".png");
			Utility.getScreenshot(driver,"NewArrival");
		}
		
		//extentreport.extent
		//System.out.println("new arraivals "+slide_item.size());
		driver.close();
	}
	
	
}
