package com.GenericFunctions;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Initilisation.Initilisation;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.ios.IOSElement;

public class GenericFunctions extends Initilisation{

	
	
	
	public static void openBrowser() throws InterruptedException
	{
		if(Config.getProperty("Browser").equals("chrome"))
		{
			try{
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+Con_ChromeDriver_Path);
			 driver = new ChromeDriver();
			  
			// driver.manage().window().maximize();
			}catch(Exception e)
			{
				System.out.println("***Unable to Open Chrome Driver**");
			}
		}else if(Config.getProperty("Browser").equals("IE"))
		{
			try{
				System.setProperty("webdriver.IE.exe", System.getProperty("user.dir")+Con_IEDriver_Path);
				driver=new InternetExplorerDriver();
				 driver.manage().window().maximize();
				}catch(Exception e)
				{
					System.out.println("**Unable to Open IE Driver**");
				}
		}else if(Config.getProperty("Browser").equals("firefox"))
		{
			try{
				driver=new FirefoxDriver();
				 driver.manage().window().maximize();
				}catch(Exception e)
				{
					System.out.println("**Unable to Open firefox Driver**");
				}
		}
		
		Thread.sleep(1000);
	}
	

		
	public static String getdata(String TC_ID,String fieldname)
	{
		String value=null;
		
		for(int i=0;i<TestData_rows;i++)
		{
			String field=TestDataSheet.getCell(0,i).getContents();
			if(field.equals(TC_ID))
			{
				lclrowstart=i+1;
				for(int k=lclrowstart;k<(TestData_rows);k++)
				{
					String field2=TestDataSheet.getCell(0,k).getContents();
					if(field2.equals(fieldname))
					{
						value=TestDataSheet.getCell(1,k).getContents();
					logger.log(LogStatus.INFO, "Value of "+fieldname+" is "+value);
						break;
					}
					if(field2.equals(""))
					{
						System.out.println("***No Field Name Found***");
						logger.log(LogStatus.FAIL, fieldname+" is not found under Test case ID "+TC_ID);
						break;
					}
				}	
						
			}
			
			
		}
		
		return value;
	}
	
	public static WebElement getObject_Xpath(String expression)
	{
		WebElement Element=null;
		
		
			Element=driver.findElement(By.xpath(Locator.getProperty(expression)));
					
			
		return Element;
	}
	
	public static IOSElement getObject_Xpath_Mobile(String expression)
	{
		IOSElement Element=null;
		
		
			Element=driver2.findElementByXPath(Locator.getProperty(expression));
					
			
		return Element;
	}
	
	public static WebElement getObject_ID(String expression)
	{
		WebElement Element=null;
		
		
			Element=driver.findElement(By.id(Locator.getProperty(expression)));
					
			
		return Element;
	}
	
	public static WebElement getObject_Name(String expression)
	{
		WebElement Element=null;
		
		
			Element=driver.findElement(By.name(Locator.getProperty(expression)));
					
			
		return Element;
	}

	public static IOSElement getObject_Name_Mobile(String expression)
	{
		IOSElement Element=null;
		
		
			Element=driver2.findElementByName(Locator.getProperty(expression));
					
			
		return Element;
	}

	
	public static List<WebElement> getObject_ListItemsXpath(String expression)
	{
		List<WebElement> Element=null;
		
		
			Element=driver.findElements(By.xpath(Locator.getProperty(expression)));
					
			
		return Element;
	}
	
	public static List<IOSElement> getObject_ListItemsXpath_Mobile(String expression)
	{
		List<IOSElement> Element=null;
		
		
			Element=driver2.findElementsByXPath(Locator.getProperty(expression));
					
			
		return Element;
	}
	
	
	
	public static void takeScreenshot(String name)
	{
		try{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Con_ScreenShots_Path+name+".png"));
		logger.log(LogStatus.INFO, logger.addScreenCapture(Con_ScreenShots_Path+name+".jpg"));
		}catch(Exception e)
		{
			logger.log(LogStatus.INFO, "Screenshot capture failure");
			System.out.println("Screen Shoot Capture Failure");
		}
		
	}
	
	
	
}