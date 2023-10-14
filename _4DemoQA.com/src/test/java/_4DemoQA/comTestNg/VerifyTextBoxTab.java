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
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.TextBoxPage;

public class VerifyTextBoxTab extends Browser{
	
	
	private WebDriver driver;
	private ElementsPage elementsPage;
	private HomePage homePage;
	private TextBoxPage textBoxPage;
	private String TestID;
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
		elementsPage = new ElementsPage(driver);
		    homePage = new HomePage(driver);
		textBoxPage = new TextBoxPage(driver);
		
	}
	
	@BeforeMethod
	public void launchURL()
	{
		driver.get(null);
	
	}
	
	@Test
	public void VerifyTextBoxTabTest() throws InterruptedException
	{
	
		TestID = "QA002";
		
		homePage.clickOnElementsTab();
		elementsPage.clickOnTextBoxTab();
		textBoxPage.clickOnFullNameFeild();
		textBoxPage.sendDataIntoFullNameFeild(null);
		textBoxPage.clickOnEmailFeild();
		textBoxPage.sendDataIntoEmailFeild(null);
		textBoxPage.clickOnCurrentAddressFeild();
		textBoxPage.sendDataIntoCurrentAdressFeild(null);
		textBoxPage.clickOnPermanantAddressFeild();
		textBoxPage.sendDataIntoPermanantAddressFeild(null);
		textBoxPage.clickOnSubmitButton();
		
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
		elementsPage = new ElementsPage(driver);
		    homePage = new HomePage(driver);
		textBoxPage = new TextBoxPage(driver);

	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
}
