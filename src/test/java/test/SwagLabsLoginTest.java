package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import utility.ExtentReport;
import utility.SwagLabsPageElement;


@Listeners(utility.Listeners.class)
public class SwagLabsLoginTest extends SwagLabsPageElement {

	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports = ExtentReport.getReports();
	}
	
	@BeforeMethod
	public void openApplication() {
		driver = Browser.openBrowser();
	}
	
	@Test
	public void swagLabsLoginTest() throws EncryptedDocumentException, IOException {
		test = reports.createTest("swagLabsLoginTest");
		SwagLabsLoginPage swaglabsloginpage = new SwagLabsLoginPage(driver);
		swaglabsloginpage.enterUserID(0,0);
		swaglabsloginpage.enterPassword(1,0);
		swaglabsloginpage.clickOnLogin();
		
		String expectedURL = "https://www.saucedemo.com";
		Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
	}
	
	@AfterMethod
	public void addResult(ITestResult result) {
		if(result.getStatus() == result.SUCCESS) 
		{
			test.log(Status.PASS,result.getName());
		}
		else if(result.getStatus() == result.FAILURE) 
		{
			test.log(Status.FAIL,result.getName());
		}
		else 
		{
			test.log(Status.SKIP,result.getName());
		}
	}
	
	@AfterMethod
	public void flushReport() {
		reports.flush();
	}
}
