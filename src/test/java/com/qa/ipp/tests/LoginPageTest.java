package com.qa.ipp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ipp.utils.Constants;

public class LoginPageTest extends BaseTest{

	@Test(priority=2)
	public void LoginPageTitle() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("Page Title is :" +actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void LoginPageUrl() {
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Test(priority=3)
	public void cantAccessAccountLink() {
		Assert.assertTrue(loginPage.CantAccessAccountLink());
		
	}
	
	/*@Test(priority=5)
	public void forgotPasswordLink() {
		Assert.assertTrue(loginPage.isForgotPWLinkdisplayed());
	}*/
	
	@Test(priority=4)
	public void Login() throws InterruptedException {
		
	 homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	 Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
}
