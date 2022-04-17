package org.qa.opencart.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	private FileInputStream ip;
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		
	
		
		prop=init_prop();
		
		String browserName=prop.getProperty("browser");
		highlight=prop.getProperty("highlight");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass correct browser: either chrome or Firefox");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		String url=prop.getProperty("url").trim();
		getDriver().get(url);
		
		return getDriver();
		
		
	}
	
	public static synchronized WebDriver  getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties init_prop() {
		
		  prop= new Properties();
		  
		  String envName = System.getProperty("env");// qa/dev/stage/uat

			if (envName == null) {
				System.out.println("Running on PROD env: ");
							
			try {
				ip = new FileInputStream("./src/test/resources/Properties/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			}
			return prop;
			 
			}
		
	public String getScreenshots() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


