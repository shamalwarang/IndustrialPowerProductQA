package com.qa.ipp.factory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.ipp.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/** 
	 * This method is use to initialize the webdriver
	 * @param browserName
	 * @return driver
	 * @throws InterruptedException 
	 */

	//Logger log = Logger.getLogger(DriverFactory.class.getName());
	//Logger log = Logger.getLogger(LoginPage.class.getName());
	
	
	public WebDriver init_driver(Properties prop) throws InterruptedException {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser Name is :" + browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			System.out.println("Please pass the Correct Browser Name" + browserName);
		}

		//log.info("Launching Browser");
		
		getDriver().manage().window().maximize();;
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());
		Thread.sleep(2000);
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		return getDriver();
	}
	
	/**
	 * this method returns thread local copy of web driver
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	/**
	 * It returns properties from config file
	 * @return
	 */
	
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	/**
	 * Take screenshot through extent report for failure 
	 * @return
	 */
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
