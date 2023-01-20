package com.qa.ipp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ipp.utils.Constants;

public class HomePageTest extends BaseTest{

	@BeforeClass
	public void HomePageSetup(){
		System.out.println("Before class");
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void HomePageTitle() {
		String actTitle = homePage.getHomePageTitle();
		System.out.println("Home Page Title is :" +actTitle);
		Assert.assertEquals(actTitle,Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void HomePageHeader() {
		String actHeader = homePage.HomePageHeader();
		System.out.println("Home Page Header is :" +actHeader);
		Assert.assertEquals(actHeader, Constants.HOME_PAGE_HEADER);
	}
	
	/*@Test(priority=3)
	public void HomePageLogo() {
		Assert.assertTrue(homePage.HomePageLogo()); 
	}*/
	
	@Test(priority=3)
	public void HomePageUser() {
		homePage.HomePageUser();
	}
	@Test(priority=4)
	public void HomePageLoggedinUserDisplay() {
		Assert.assertTrue(homePage.HomePageLoggedinuser());
	}
	
	@Test(priority=5)
	public void HomePageLogoutDisplay() {
		Assert.assertTrue(homePage.HomePageLogout());
	}
	
	@Test(priority=6)
	public void CustomerDisplay() {
		Assert.assertTrue(homePage.Customer());
	}
	
	@Test(priority=7)
	public void ClickOnCustomerLink() {
		homePage.ClickCustomer();
	}
	
	@Test(priority=8)
	public void AddCustomerDisplay() {
		Assert.assertTrue(homePage.AddCustomer());
	}
	
	@Test(priority=9)
	public void ClickdOnAddCustomerLink() throws InterruptedException {
		homePage.ClickAddCustomer();
	}	
	
	@Test(priority=10)
	public void HomePageLogoutClick() {
		homePage.Logout();
	}
}


