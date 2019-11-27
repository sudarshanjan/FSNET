package com.GenericFunctions;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	
	public static void connectDB() throws SQLException, ClassNotFoundException {
		
		
		  // Connect to database
	    String hostName = "fsnetserverdb.database.windows.net"; // update me
	    String dbName = "fsnet_qa_new"; // update me
	    String user = "serveradmin"; // update me
	    String password = "YUc8U\\UqkQb.[288"; // update me
	    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
	        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
	    Connection connection = null;
		
	    
	    try {
	        connection = DriverManager.getConnection(url);
	        String schema = connection.getSchema();
	        System.out.println("Successful connection - Schema: " + schema);

	        System.out.println("Query data example:");
	        System.out.println("=========================================");

	        
	        //For adding GP
	        
	       // http://qa.vanillavc.com/user/setPassword?code=260110&id=90
	        	
	        	//Executing SQL query and fetching the result
	      		Statement st = connection.createStatement();
	      		
	      		String emailGP = "kempgp3@mailinator.com"; 
	      		
	      		//String sqlStr = "SELECT * FROM  Users WHERE email='"+emailGP+"'";
	      		
	      		String sqlStr = "SELECT emailConfirmCode, id FROM  Users WHERE email='"+emailGP+"';";
	      		
	      		
	      		
	      		ResultSet rs = st.executeQuery(sqlStr);
	      		
	      		
	      		while (rs.next()) {
	      			
	      			String emailCode = rs.getString("emailConfirmCode");
	      			String gpID = rs.getString("id");
	      			System.out.println("username list is "+ emailCode);
	      			System.out.println("GP ID is "+ gpID);
	      	  		if(emailCode == null || emailCode.isEmpty() ) {
	      	  			System.out.println("Email code is "+ emailCode+ ". User is alerady created");
	      	  		}else{
	      	  		
	      	  			//String url1 = "http://qa.vanillavc.com/register/"+usernamesList+"";
	      	  			String url1 = "http://qa.vanillavc.com/user/setPassword?code="+emailCode+"&id="+gpID+"";
	      	  	  		System.out.println("URL is "+ url1);
	      	  	  		driver.get(url1);
	      	  	  		break;
	      	  		}
	      			
	      		}
	    	} catch (Exception e) {
	    		 e.printStackTrace();
	    	}
	        
	        
	        
	     //for adding LP or GP delegate
	    /*	//Executing SQL query and fetching the result
	  		Statement st = connection.createStatement();
	  		String sqlStr = "SELECT * FROM  Users WHERE email='bobgpsign1@mailinator.com'";
	  		
	  		ResultSet rs = st.executeQuery(sqlStr);
	  		
	  		
	  		while (rs.next()) {
	  			
	  			String usernamesList = rs.getString("emailConfirmCode");
	  			System.out.println("username list is "+ usernamesList);
	  	  		if(usernamesList == null){
	  	  			
	  	  		}else{
	  	  		
	  	  			String url1 = "http://qa.vanillavc.com/register/"+usernamesList+"";
	  	  	  		System.out.println("URL is "+ url1);
	  	  	  		driver.get(url1);
	  	  	  		break;
	  	  		}
	  			
	  		}
		} catch (Exception e) {
			 e.printStackTrace();
		}*/
	    
	    
	    
		}
	
	
	
}