package com.qa.ipp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ipp.utils.Constants;

public class CreateWorkOrderTest extends BaseTest{
	String custId;
	@BeforeClass
	public void CreateWorkOrdePageSetup() throws InterruptedException{
		System.out.println("Before class");
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.ClickCustomer();
		addCustomerPage = homePage.ClickAddCustomer();
		addCustomerPage.createCustomer("Shamal Warang1","India", "Pune", "MH", "55555","shamal@gmail.com","Shamal Service Contact","8888888888");
		custId = addCustomerPage.CreateCustomerServiceInformation("5","4","3","6" , "2","7");
		addCustomerPage.CreateCustomerScheduledMaintenance();
		addCustomerPage.ValidateCustomerId(custId);
		System.out.println("AddCustomerPage ============================ 1");
		createWorkOrderPage = addCustomerPage.WorkOrder();
	}   
	
	@Test(priority=1)
	public void WorkOrderDisplay() {
		Assert.assertTrue(createWorkOrderPage.WorkOrder());
	}
		
	@Test(priority=2)
	public void ClickOnWorkOrderLink() {
		createWorkOrderPage.ClickWorkOrder();
	}
	
	
	@Test(priority=4)
	public void ClickOnCreateWorkOrderLink() {
		createWorkOrderPage.ClickCreateWorkOrder();
	}
	
	@Test(priority=5)
	public void NewWorkOrderHeaderTest() {
		String WorkOrderHeader = createWorkOrderPage.NewWorkOrderPageHeader();
		System.out.println("Page Header is :" +WorkOrderHeader);
		Assert.assertEquals(WorkOrderHeader, Constants.NEWWORKORDER_PAGE_HEADER);
	}
	
	@Test(priority=6)
	public void CreateCustomerWO() throws InterruptedException {
		
		createWorkOrderPage.CreateCustomerWO("Shamal Warang1","Testing");
		
	}
}
