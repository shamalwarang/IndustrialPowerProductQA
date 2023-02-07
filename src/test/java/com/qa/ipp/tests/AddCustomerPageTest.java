package com.qa.ipp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ipp.utils.Constants;

public class AddCustomerPageTest extends BaseTest{
	
	String custId = "";

	@BeforeClass
	public void AccountPageSetup() throws InterruptedException{
		System.out.println("Before class");
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.ClickCustomer();
		addCustomerPage = homePage.ClickAddCustomer();
		
	}   		
	@Test(priority=1)
	public void NewCustomerHeaderTest() {
		String CustomerHeader = addCustomerPage.CustomerPageHeader();
		System.out.println("Page Header is :" +CustomerHeader);
		Assert.assertEquals(CustomerHeader, Constants.NEWCUSTOMER_PAGE_HEADER);
	}
	
	@Test(priority=2)
	public void CreateCustomerTest() throws InterruptedException {
		addCustomerPage.createCustomer("Shamal","India", "Pune", "MH", "55555","shamal@gmail.com","Shamal Service Contact","8888888888");
		
	}
	
	@Test(priority=3)
	public void CustomerServiceInformation(){
		custId = addCustomerPage.CreateCustomerServiceInformation("5","4","3","6" , "2","7");
	}
	
	@Test(priority=4)
	public void CreateCustomerScheduledMaintenance() throws InterruptedException  {
		
		addCustomerPage.CreateCustomerScheduledMaintenance();
	}
	
	@Test(priority=5)
	public void ValidateCustomerId() throws InterruptedException  {
		
		boolean isFound = addCustomerPage.ValidateCustomerId(custId);
		Assert.assertEquals(isFound, false);
	}
	
	@Test(priority=6)
	public void WorkOrder() throws InterruptedException  {
		
		addCustomerPage.WorkOrder();
	}
}
