package com.Initilisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.Constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Initilisation extends Constants{
	
	public static Properties Config=null;
	public static FileInputStream Configuration=null;
	public static FileInputStream ExcellFile=null;
	public static FileInputStream Locators_File=null;
	public static Properties Locator=null;
	public static Workbook workbook;
	public static Sheet TestCaseSheet;
	public static Sheet TestDataSheet;
	public static int TestCase_rows;
	public static int TestData_rows;
	public static int lclrowstart;
	
	public static WebDriver driver;
	public static AppiumDriver<IOSElement> driver2;
	
	public static ExtentReports extent;
	public static  ExtentTest logger;
	
	public static void  init() throws BiffException, IOException 
	{
		 extent= new ExtentReports(Con_Extent_Report_Path, true);
		 
		 
		 
		 
		try{
		Config=new Properties();
		Configuration=new FileInputStream(System.getProperty("user.dir")+Con_ConfigurationFile_Path);
		Config.load(Configuration);
		}catch(Exception e)
		{
			System.out.println("*******Configuration File Load Fail*******");
		    System.out.println(e.getMessage());
		}
		
		
		Locator=new Properties();
		
		if(Config.getProperty("TypeofApplication").equals("WEB"))
		{
			try{
			ExcellFile=new FileInputStream(System.getProperty("user.dir")+Con_WEB_Excell_Path);
																		 
			}catch(Exception e)
			{
				System.out.println("WEB_Excell_File Load Fail");
			}
		
			Locators_File=new FileInputStream(System.getProperty("user.dir")+Con_WEB_Locators_Path);
			Locator.load(Locators_File);
			
			
			
		}else if(Config.getProperty("TypeofApplication").equals("IOS"))
		{
			try{
				ExcellFile=new FileInputStream(System.getProperty("user.dir")+Con_IOS_Excell_Path);
				}catch(Exception e)
				{
					System.out.println("IOS_Excell_Fiel Load Fail");
				}
			
			Locators_File=new FileInputStream(System.getProperty("user.dir")+Con_IOS_Locators_Path);
			Locator.load(Locators_File);
			
		}else if(Config.getProperty("TypeofApplication").equals("ANDROID"))
		{
			try{
				ExcellFile=new FileInputStream(System.getProperty("user.dir")+Con_ANDROID_Excell_Path);
				}catch(Exception e)
				{
					System.out.println("ANDROID_Excell_Fiel Load Fail");
				}
			
			Locators_File=new FileInputStream(System.getProperty("user.dir")+Con_ANDROID_Locators_Path);
			Locator.load(Locators_File);
		}
		
		
		
	
		
	     workbook=Workbook.getWorkbook(ExcellFile);
	     TestCaseSheet=workbook.getSheet(0);
	     TestCase_rows=TestCaseSheet.getRows();
	     TestDataSheet=workbook.getSheet(1);
	     TestData_rows=TestDataSheet.getRows();
	     
	     
	     // THIS SECTION WILL HAVE INDIVIDUAL SETTINGS 
	    
	     if(Config.getProperty("TypeofApplication").equals("WEB"))
			{
				
			}
	     else if(Config.getProperty("TypeofApplication").equals("IOS"))
			{
				
			}
	     else if(Config.getProperty("TypeofApplication").equals("ANDROID"))
			{
				
			}
	     
	     
	     
	}

}
