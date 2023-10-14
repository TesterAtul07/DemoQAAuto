package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
	
	@FindBy (xpath = "//span[text()='Text Box']")
	private WebElement textBoxTab;
	
	@FindBy (xpath = "//span[text()='Check Box']")
	private WebElement checkBoxTab;
	
	@FindBy (xpath = "//span[text()='Radio Button']")
	private WebElement  radioButtonTab;
	
	private WebDriver driver;
	private JavascriptExecutor js;
	public ElementsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		js = (JavascriptExecutor)driver;
		
	}
	
	public void clickOnTextBoxTab() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", textBoxTab);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-20)");
		textBoxTab.click();
		Thread.sleep(500);
	}
	
	public void clickOnCheckBoxTab() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", checkBoxTab);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		checkBoxTab.click();
		Thread.sleep(500);
	}
	
	public void clickOnRadioButtonTab() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView(true)", radioButtonTab);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		radioButtonTab.click();
		Thread.sleep(500);
	}

}
