package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {
	
	@FindBy (xpath = "//label[@for='impressiveRadio']")
	private WebElement impressiveRadioButton;
	
	private WebDriver driver;
	
	public RadioButtonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnImpressiveRadioButton() throws InterruptedException
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", impressiveRadioButton);
		Thread.sleep(500);
	    js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(500);
		impressiveRadioButton.click();
		
	}

}
