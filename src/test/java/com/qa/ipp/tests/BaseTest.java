package com.qa.ipp.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.qa.ipp.factory.DriverFactory;
import com.qa.ipp.pages.AddCustomerPage;
import com.qa.ipp.pages.CreateWorkOrderPage;
import com.qa.ipp.pages.HomePage;
import com.qa.ipp.pages.LoginPage;


public class BaseTest {
	
	public DriverFactory df;
	public WebDriver driver;
	public LoginPage loginPage;
	public Properties prop;
	public HomePage homePage;
	public AddCustomerPage addCustomerPage;
	public CreateWorkOrderPage createWorkOrderPage;
	
	@BeforeTest
	
	public void setUp() throws InterruptedException {
		System.out.println("Before Test test");
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	  @AfterTest public void tearDown() { 
		  driver.quit(); 
		  }
	 
}
