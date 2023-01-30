import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailActions {

	private static WebDriver driver;
	GmailActions(WebDriver driver){
		GmailActions.driver=driver;
	 	}
	
	public static void waitforElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void Click(WebElement element) {
		waitforElement(element);
		element.click();
		waitforpageload();
	}
	
	
	public void SendKeys(WebElement element, String text) {
		waitforElement(element);
		element.sendKeys(text);
	}
	
	public void SendKeys(WebElement element, Keys keys) {
		waitforElement(element);
		element.sendKeys(keys);
	}
	
	public void buildActions(WebElement element, String text) {
		waitforElement(element);
		Actions act=new Actions(driver);
		act.moveToElement(element);
		act.click();
		act.sendKeys(text).build().perform();
			
	}
	
	public boolean VerifyText(WebElement element,String Vtext) {
		waitforElement(element);
		return element.getText().contentEquals(Vtext);
	}
	
	public boolean VerifyLabelSelected(WebElement element) {
		waitforElement(element);
		return element.getAttribute("aria-checked").contentEquals("true");
		
	}
	
	public void waitforpageload() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(expectation);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
	
	
	
}
