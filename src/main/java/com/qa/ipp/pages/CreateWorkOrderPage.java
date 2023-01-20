package com.qa.ipp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ipp.utils.Constants;
import com.qa.ipp.utils.ElementUtil;

public class CreateWorkOrderPage {

	// 1. Declare private webdriver
		private WebDriver driver;
		private ElementUtil eleUtil;

		// 2. Page constructor
		public CreateWorkOrderPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}

		private By NewWorkOrder =  By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/h3/b");
		private By WorkOrder = By.xpath("//*[@id=\"sidebarnav\"]/li[6]/a/span");
		private By CreateWorkOrder = By.xpath("//*[@id=\"sidebarnav\"]/li[6]/ul/li[2]/a");
		private By CustomerName = By.xpath("//*[@id=\"custName\"]");
		private By CustomerNamePath = By.xpath("//*[@id=\"custName\"]");
		private By Notes = By.xpath("//*[@id=\"NotesId\"]");
		private By MaintenanceType = By.xpath("//*[@id=\"AdHocWorkOrderForm\"]/div/div/div[1]/div/div[7]/div[2]/div/span/span");
		private By SaveBtn = By.xpath("//*[@id=\"btnSave\"]");
		
		public boolean WorkOrder() {
			eleUtil.doPresenceOfElementLocated(WorkOrder, Constants.DEFAULT_TIME_OUT);
			return eleUtil.doIsDisplayed(WorkOrder);
		}

		public void ClickWorkOrder() {
			
			if(WorkOrder()) {
				eleUtil.doClick(WorkOrder);
			}
		
		}

		public boolean CreateWorkOrder() {
			eleUtil.doPresenceOfElementLocated(CreateWorkOrder, Constants.DEFAULT_TIME_OUT);

			return eleUtil.doIsDisplayed(CreateWorkOrder);
		}
		
		public void ClickCreateWorkOrder() {
			if(CreateWorkOrder()) {
				eleUtil.doClick(CreateWorkOrder);
			}
			
		}
		
		public String NewWorkOrderPageHeader() {
			eleUtil.doPresenceOfElementLocated(NewWorkOrder, Constants.DEFAULT_TIME_OUT);

			return eleUtil.doGetText(NewWorkOrder);
		}


		public void CreateCustomerWO(String CustomerName , String Notes) throws InterruptedException {
			
			eleUtil.doPresenceOfElementLocated(this.CustomerName, Constants.DEFAULT_TIME_OUT);

			
			//eleUtil.doClick(this.CustomerName);
			eleUtil.doSendKeys(this.CustomerName, CustomerName);
			
			By CustomerNameFirstElement = By.xpath("//*[@id=\"custName_listbox\"]/li[1]");
			By CustomerNameDropDown = By.xpath("//*[@id=\"custName_listbox\"]/li");
			
			eleUtil.selectValueFromCustomSelect(CustomerNamePath, CustomerNameDropDown, CustomerNameFirstElement, "Shamal Warang1");
			Thread.sleep(1000);
			
			
			
			
			eleUtil.doPresenceOfElementLocated(this.Notes, Constants.DEFAULT_TIME_OUT);
			eleUtil.doSendKeys(this.Notes, Notes);
			
			
			By MaintenanceTypeFirstElement = By.xpath("//*[@id=\"MaintenanceTypeId_listbox\"]/li[1]");
			By MaintenanceTypeDropDown = By.xpath("//*[@id=\"MaintenanceTypeId_listbox\"]/li");
			
			eleUtil.selectValueFromCustomSelect(MaintenanceType, MaintenanceTypeDropDown, MaintenanceTypeFirstElement, "Battery PM");

			
			
			eleUtil.doPresenceOfElementLocated(SaveBtn, Constants.DEFAULT_TIME_OUT);
			eleUtil.doClick(SaveBtn);
			
		}




}



