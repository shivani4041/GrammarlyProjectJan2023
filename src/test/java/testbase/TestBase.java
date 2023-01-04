package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static String getbrowser;
	
	public static WebDriver getInstance() throws IOException
	{
		String file = "./src/main/java/config/config.properties";
		FileInputStream instream = new FileInputStream(new File(file));
		
		prop = new Properties();
		prop.load(instream);
		getbrowser = prop.getProperty("browser");
		System.out.println(getbrowser);
		
		if(getbrowser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\ishaa\\AppData\\Local\\Google\\Chrome\\User Data");
		options.addArguments("--start-maximized");
		
		driver = new ChromeDriver(options);
		}
		else if(getbrowser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoagent"));
			driver = new FirefoxDriver();	
			
		}
		else if(getbrowser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
			driver = new EdgeDriver();
		}
		else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
	
		driver.get(prop.getProperty("url"));
		//driver.manage().window().setSize(new Dimension(600,300));
		//driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
		
		
	}


}
