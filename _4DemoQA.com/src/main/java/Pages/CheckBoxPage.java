package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
	
	@FindBy (xpath = "//button[@aria-label='Expand all']")
	private WebElement expandAllButton; 
	
	@FindBy (xpath = "(//span[@class='rct-checkbox'])[10]")
	private WebElement officeCheckBox;
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public CheckBoxPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	public void clickOnExpandAllButton() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", expandAllButton);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		expandAllButton.click();
	}
	
	public void clickOnOfficeCheckBox() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", officeCheckBox);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		officeCheckBox.click();
	}

}
