package com.WEBTESTS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.GenericFunctions;
import com.mongodb.diagnostics.logging.Logger;
import com.relevantcodes.extentreports.LogStatus;

public class WEB_Tests extends GenericFunctions{

	public static void Login() throws InterruptedException 
	{
		logger = extent.startTest("Executing login", "Executing login");
		System.out.println("Executing login");
		
		openBrowser();
		driver.manage().window().maximize();
		driver.get(Config.getProperty("QA_URL"));
		Thread.sleep(2000);
//Enter username and password
		GenericFunctions.getObject_ID("username_id").sendKeys(getdata("Login", "username"));
		GenericFunctions.getObject_ID("password_id").sendKeys(getdata("Login", "password"));
		
		
		//Click on login button
		GenericFunctions.getObject_Xpath("loginBtn_Xpath").click();
		Thread.sleep(2000);
		String urlofPage = driver.getCurrentUrl();
		System.out.println("Current url page is "+ urlofPage);
		if(urlofPage.equals("http://qa.vanillavc.com/dashboard")){
			System.out.println("Login successfully");
			logger.log(LogStatus.PASS, "Login successfully");
			Thread.sleep(3000);
			GenericFunctions.getObject_Xpath("DownArrowLink_Xpath").click();
			GenericFunctions.getObject_Xpath("logoutLink_Xpath").click();
			
		} else{
			System.err.println("Login Failed");
			logger.log(LogStatus.FAIL, "Login Failed");
		}
		
		
	}
	public static void CreateFund() throws InterruptedException
	{
		logger = extent.startTest("Executing WEB Test Create fund", "Executing WEB Test Create fund");
		System.out.println("Executing WEB Test Create fund");

		openBrowser();
		driver.manage().window().maximize();
		driver.get(Config.getProperty("QA_URL"));
		Thread.sleep(2000);
//Enter username and password
		GenericFunctions.getObject_ID("username_id").sendKeys(getdata("CreateFund", "username"));
		GenericFunctions.getObject_ID("password_id").sendKeys(getdata("CreateFund", "password"));
		
		
		//Click on login button
		GenericFunctions.getObject_Xpath("loginBtn_Xpath").click();
		Thread.sleep(2000);
		
		
	    
	    driver.findElement(By.xpath("//div[@id='MainDashboard']/div[2]/div[2]/div[2]/div/button")).click();
	    driver.findElement(By.name("legalEntity")).click();
	    driver.findElement(By.name("legalEntity")).clear();
	    driver.findElement(By.name("legalEntity")).sendKeys("Test A3");
	    driver.findElement(By.name("fundCommonName")).click();
	    driver.findElement(By.name("fundCommonName")).clear();
	    driver.findElement(By.name("fundCommonName")).sendKeys("Test A3");
	    driver.findElement(By.xpath("//div[@id='step1Form']/div[2]/div/input")).click();
	    driver.findElement(By.xpath("//div[@id='step1Form']/div[2]/div/input")).clear();
	    driver.findElement(By.xpath("//div[@id='step1Form']/div[2]/div/input")).sendKeys("Test A3");
	    driver.findElement(By.name("fundManagerTitle")).click();
	    driver.findElement(By.name("fundManagerTitle")).clear();
	    driver.findElement(By.name("fundManagerTitle")).sendKeys("Test A3");
	    driver.findElement(By.name("fundManagerCommonName")).click();
	    driver.findElement(By.name("fundManagerCommonName")).clear();
	    driver.findElement(By.name("fundManagerCommonName")).sendKeys("Test A3");
	    driver.findElement(By.xpath("//div[@id='step1Form']/div[4]/div[2]/input")).click();
	    driver.findElement(By.xpath("//div[@id='step1Form']/div[4]/div[2]/input")).clear();
	    driver.findElement(By.xpath("//div[@id='step1Form']/div[4]/div[2]/input")).sendKeys("45500");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/preceding::input[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/preceding::input[2]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/preceding::input[2]")).sendKeys("15500");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/following::select[1]")).click();
	    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/following::select[1]"))).selectByVisibleText("U.S. Fund");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/following::select[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/following::select[2]")).click();
	    new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/following::select[2]"))).selectByVisibleText("Investor Capital Commitments only");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Type*'])[1]/following::select[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Manager’s Capital Commitment'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Manager’s Capital Commitment'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fund Manager’s Capital Commitment'])[1]/following::input[1]")).sendKeys("10");
	    //driver.findElement(By.id("step1Form")).click();
	    driver.findElement(By.xpath("//div[2]/i[2]")).click();
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,380)", "");

	    driver.findElement(By.xpath("//i[2]")).click();
	    jse.executeScript("window.scrollBy(0,350)", "");
	    driver.findElement(By.xpath("//i[2][contains(@class, 'fa fa-chevron-right')]")).click();
	    jse.executeScript("window.scrollBy(0,350)", "");
	    driver.findElement(By.xpath("//i[2][contains(@class, 'fa fa-chevron-right')]")).click();
	 //   driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Upload your Fund Agreement (i.e. Limited Partnership Agreement or similar document).'])[1]/following::button[1]")).click();
	  //  driver.findElement(By.id("uploadBtn")).clear();
	    
	    Actions action = new Actions(driver);
	    WebElement element = driver.findElement(By.id("uploadBtn"));
	    action.moveToElement(element).perform();
	    
	    driver.findElement(By.id("uploadBtn")).sendKeys("D:\\Fsnet\\Doc\\One.doc");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='One.doc'])[1]/following::i[3]")).click();
		
		
	
	}
	public static void TC_03()
	{
		logger = extent.startTest("Executing WEB Test TC_03", "Executing WEB Test TC_03");
		System.out.println("Executing WEB Test TC_03");
		System.out.println(getdata("", "author"));
		logger.log(LogStatus.INFO, "Name Printed");
		logger.log(LogStatus.PASS, "PASS");
		extent.endTest(logger);
	}
}