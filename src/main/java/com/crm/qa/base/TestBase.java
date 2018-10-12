package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase()  {
		
		try{
			prop=new Properties();
			String currentDir = System.getProperty("user.dir");
			FileInputStream ip=new FileInputStream(currentDir+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
			
		}
		catch(IOException ie){
			ie.printStackTrace();	
		}
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			String currentDir = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", currentDir+"/chromedriver.exe");
			driver=new ChromeDriver();	
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
