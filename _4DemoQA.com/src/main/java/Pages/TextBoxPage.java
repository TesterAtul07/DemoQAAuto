package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
	
	@FindBy (xpath = "//input[@placeholder='Full Name']")
	private WebElement fullNameFeild;
	
	@FindBy (xpath = "//input[@placeholder='name@example.com']")
	private WebElement emailFeild;
	
	@FindBy (xpath = "//textarea[@placeholder='Current Address']")
	private WebElement currentAddressFeild;
	
	@FindBy (xpath ="//textarea[@id='permanentAddress']")
	private WebElement permenantAddressFeild;
	
	@FindBy (xpath = "//button[text()='Submit']")
	private WebElement submitButton;
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public TextBoxPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	public void clickOnFullNameFeild() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", fullNameFeild);
        Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-20)");
		fullNameFeild.click();

	}
	
	public void sendDataIntoFullNameFeild(String FullName) throws InterruptedException
	{
		fullNameFeild.sendKeys(FullName);
		Thread.sleep(500);

	}
	
	public void clickOnEmailFeild() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", emailFeild);
        Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-20)");
		emailFeild.click();
	}
	
	public void sendDataIntoEmailFeild(String email) throws InterruptedException
	{
		emailFeild.sendKeys(email);
		Thread.sleep(500);
	}
	
	public void clickOnCurrentAddressFeild() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", currentAddressFeild);
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-20)");
		currentAddressFeild.click();

	}
	
	public void sendDataIntoCurrentAdressFeild(String cAddress) throws InterruptedException
	{
		currentAddressFeild.sendKeys(cAddress);
		Thread.sleep(500);
	}
	
	public void clickOnPermanantAddressFeild() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", permenantAddressFeild);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		permenantAddressFeild.click();
	}
	
	public void  sendDataIntoPermanantAddressFeild(String pAddress) throws InterruptedException
	{
		permenantAddressFeild.sendKeys(pAddress);
		Thread.sleep(500);
	}
	
	public void clickOnSubmitButton() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", submitButton);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		submitButton.click();
	}

}
