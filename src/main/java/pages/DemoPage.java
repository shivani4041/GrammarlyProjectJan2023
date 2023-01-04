package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
	
	private WebDriver dr;
	public DemoPage(WebDriver driver) 
	{
		this.dr = driver;
		PageFactory.initElements(dr, this);
		
		
	}
	
	
	
	@FindBy(xpath="//span[text()='vivr']")
	WebElement frenchWord;
	
	@FindBy(xpath="//div[@data-name='card/apply-insert'][1]")
	WebElement frenchWordCorrection;
	
	
	
	
	
	
	public String getFrenchWord() {
		
		frenchWord.click();
		String a = frenchWord.getText();
		return a;
				
	}
	
	public String afterClickingFrenchWord() {
	
	frenchWordCorrection.click();
	String b = frenchWordCorrection.getText();
	return b;
	}
	
	}


