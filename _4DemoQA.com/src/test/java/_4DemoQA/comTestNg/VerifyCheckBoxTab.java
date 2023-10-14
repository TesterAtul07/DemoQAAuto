package _4DemoQA.comTestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Browser;
import Pages.CheckBoxPage;
import Pages.ElementsPage;
import Pages.HomePage;

public class VerifyCheckBoxTab extends Browser{
	
	private WebDriver driver;
	private CheckBoxPage checkBoxPage;
	private ElementsPage elementsPage;
	private HomePage homePage;
	public String TestID ;
    static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browsername) throws Exception {
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);		
		
		if(browsername.equals("chrome"))
		{
		  driver = launchChrome();
		}
		
		if(browsername.equals("firefox"))
		{
			driver = launchFireFox();	
		}
		
		if(browsername.equals("microsoftEdge"))
		{
			driver = launchEdge();
		}
		
						
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	@BeforeClass
	public void creatingPOMObject()
	{
		checkBoxPage = new CheckBoxPage(driver);
		elementsPage = new ElementsPage(driver);
		    homePage = new HomePage(driver);
		
	}
	
	@BeforeMethod
	public void launchURL()
	{
		driver.get(null);
	
	}
	
	@Test
	public void VerifyTextBoxTab() throws InterruptedException
	{
	  TestID = "QA001";
		homePage.clickOnElementsTab();
		elementsPage.clickOnCheckBoxTab();
		checkBoxPage.clickOnExpandAllButton();
		checkBoxPage.clickOnOfficeCheckBox();
	}
	
	@AfterMethod
	public void  ScreenshotOfFailedTestCases(ITestResult result) throws IOException 
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
	 DemoQAUtility.Utilities.captureScreenshot(driver, "test-output//FailedTestScreenshot", TestID);
	     }
	}
	
	@AfterClass
	public void clearingObject()
	{
		checkBoxPage = new CheckBoxPage(driver);
		elementsPage = new ElementsPage(driver);
		    homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}

}
