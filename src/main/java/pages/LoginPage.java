package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver dr;
	public LoginPage(WebDriver driver) 
	{
		this.dr = driver;
		PageFactory.initElements(dr, this);
		
		
	}
	
	
	@FindBy(xpath="//*[@data-name=\"doc-item\"][1]")
	WebElement demoDocument;
	
	
	
	@FindBy(xpath="//span[text()='erors'][1]")
	WebElement erorSpelling;
	
	@FindBy(xpath="//div[@data-name='card/apply-insert']")
	WebElement correctSpelling;
	
	@FindBy(xpath="//div[@aria-label='Grammarly Home']")
	WebElement homebtn;
	
	
	
	

	public void loginToApplication() {
		// TODO Auto-generated method stub
		
		
		demoDocument.click();
		
	}
	
	public String getTextOfBeforeCorrection() {
		
		erorSpelling.click();
		String a = erorSpelling.getText();
		return a;
				
	}

	public String getTextAfterCorrection() {
		
		correctSpelling.click();
		String b = correctSpelling.getText();
		return b;
		
		
	}
	
	public void homeBtnClicked() {
		homebtn.click();
	}
	
	
}
