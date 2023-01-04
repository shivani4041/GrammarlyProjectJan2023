package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class TestUtility extends TestBase{
	
	//je.executeScript("arguments[0].scrollIntoView(false)", ele);
	//je.executeScript("window.scrollBy(0,400)","");
	
	public static void scrollToElement(WebElement ele)
	{
		
		JavascriptExecutor je = (JavascriptExecutor) driver; /*or TestBase.driver*/
		je.executeScript("arguments[0].scrollIntoView(false)", ele);
		je.executeScript("window.scrollBy(0,400)","");
		
	}
	
	public static void clickOnElementJS(WebElement ele)
	{
		
		JavascriptExecutor je = (JavascriptExecutor) driver; /*or TestBase.driver*/
		je.executeScript("arguments[0].click();", ele);
		
		
	}
	
	public static void waitForElementVisible(WebElement ele)
	{
		//Expilcit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //Explicit Wait
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
