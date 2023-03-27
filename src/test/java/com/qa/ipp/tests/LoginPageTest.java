package com.qa.ipp.tests;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import com.qa.ipp.utils.Constants;


public class LoginPageTest extends BaseTest{
	
	//Adding for testing 
	
	Logger log = Logger.getLogger(LoginPageTest.class.getName());
	
	//PropertyConfigurator.configure("C:\\Users\\shamal.w\\eclipse-workspace-new\\IndustrialPowerProduct\\src\\main\\resources\\log4j.properties");

	@Test(priority=2)
	public void LoginPageTitle() {
		log.info("Printing Title");
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("Page Title is :" +actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void LoginPageUrl() {
		log.info("Launching URL");
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Test(priority=3)
	public void cantAccessAccountLink() {
		log.warn("Check create account access link");
		log.fatal("Hey just a warning");
		Assert.assertTrue(loginPage.CantAccessAccountLink());
		
	}
	
	/*@Test(priority=5)
	public void forgotPasswordLink() {
		Assert.assertTrue(loginPage.isForgotPWLinkdisplayed());
	}*/
	//Testing 25 March
	// Testing 27 March Sneha
	@Test(priority=4)
	public void Login() throws InterruptedException {
		log.info("Page Chaining");
		System.out.println("Login LoginPageTest");
	 homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	 System.out.println("Login LoginPageTest");
	 Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
}
// Test
