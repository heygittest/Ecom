package com.practice.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	
	public  Properties prop;
	public static WebDriver driver;
	public  File file;
	public  FileInputStream fis;
	public static String browser;
	public String url;
	public static ExtentReporter extent;
	public static ExtentTest logger;
	public static ExtentReports reports;
	// init property variable and load property details
	public TestBase() throws IOException
	{
		
		file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\practice\\property\\prop.properties");
		fis=new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
	}
	// get the browser and the url
	@BeforeTest
	public void init() throws InterruptedException
	{
		Date d= new Date();
	
		System.out.println(Calendar.DATE);
		// d.getDate()+ d.getMonth() + d.getYear()+"-" +d.getHours()+d.getMinutes()
		ExtentHtmlReporter extent= new ExtentHtmlReporter(
				new File("C:\\Users\\Ajit\\eclipse-workspace\\practice\\src\\test\\resources\\Reports\\report-"+ getClass().getSimpleName() +"-"+ + d.getDate()+ d.getMonth() + d.getYear()+"-" +d.getHours()+d.getMinutes() +".html"));
        reports=new ExtentReports();
        reports.attachReporter(extent);
        
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Ajit\\eclipse-workspace\\practice\\src\\test\\resources\\browser\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\browser\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.get(url);
		Thread.sleep(500);
	}
	@AfterTest
	public void teardown()
	{
        reports.flush();
	}
	
}
