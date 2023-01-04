package testcases;

import org.testng.annotations.Test;

import pages.DemoPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	private WebDriver dr;
	private LoginPage lp;
	private DemoPage dp;
	
	
	
  @Test(priority=0)
  public void GrammarlySuccessfull_001() throws InterruptedException {
	  
	    
		
	    lp.loginToApplication();
	   
	    String wrongSpelling = lp.getTextOfBeforeCorrection();
	    System.out.println(wrongSpelling);
	    
	    String act = lp.getTextAfterCorrection();
	    
	    String exp = "errors";
	    Assert.assertEquals(act, exp);
	    System.out.println("actual: " + act + " expected: " + exp);
	    
	    Thread.sleep(2000);
	    
	    lp.homeBtnClicked();
	    
	   
	
	    
	   
  }
  
  @Test(priority=1)
  public void GrammarlyUnsuccessfull_002() throws InterruptedException {
	  
	  lp.loginToApplication();
	  String frenchSpelling = dp.getFrenchWord();
	  System.out.println(frenchSpelling);
	  
	  String act1 = dp.afterClickingFrenchWord();
	  String exp1 = "vivra";
	  Assert.assertEquals(act1, exp1);
	  System.out.println("actual: " + act1 + " expected: " + exp1);
	  
	  Thread.sleep(2000);
	  
	  lp.homeBtnClicked();
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  dr= TestBase.getInstance();
	  lp = new LoginPage(dr);
	  dp = new DemoPage(dr);
	  
	  
  }

  
  
  @AfterMethod
  public void afterMethod() {
  
	  dr.quit();
  }

}
