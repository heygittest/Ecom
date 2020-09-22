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

public class TestCase4 extends TestBase {

	public TestCase4() throws IOException {
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
		logger=reports.createTest("New Arrival description");
		
			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[1]/div/div/ul/li/a[1]/img")).click();
			
			Date d= new Date();
			
				WebElement ele=driver.findElement(By.xpath("//*[@id='product-160']/div[3]/ul/li[1]/a"));
				System.out.println(driver.findElement(By.xpath("//*[@id='tab-description']/p")).getText());
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='product-160']/div[3]/ul/li[2]")).click();
//				driver.findElement(By.xpath("//*[@id='product-160']/div[3]/ul/li[2]/a")).click();
				String ele2=driver.findElement(By.xpath("//*[@id='product-160']/div[3]/ul/li[2]/a")).getText();
				//System.out.println(ele2.length());
				String review=ele2.substring(9, 10);
				int review_cnt=Integer.parseInt(review);
				if(review_cnt==0)
				{
					System.out.println("No reviews");
				}
				else
				{
					System.out.println( review_cnt +"reviews are avaliable for this product");
				}
				
		
		
		driver.close();	
		}
		
}
