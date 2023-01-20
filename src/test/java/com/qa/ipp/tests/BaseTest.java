package com.qa.ipp.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.ipp.factory.DriverFactory;
import com.qa.ipp.pages.AddCustomerPage;
import com.qa.ipp.pages.CreateWorkOrderPage;
import com.qa.ipp.pages.HomePage;
import com.qa.ipp.pages.LoginPage;


public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	AddCustomerPage addCustomerPage;
	CreateWorkOrderPage createWorkOrderPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	  @AfterTest public void tearDown() { 
		  driver.quit(); 
		  }
	 
}
