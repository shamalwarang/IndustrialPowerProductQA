package com.qa.ipp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ipp.utils.Constants;
import com.qa.ipp.utils.ElementUtil;

public class AddCustomerPage {

	// 1. Declare private webdriver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. Page constructor
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By NewCustomer = By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/h3/b");
	private By CustomerName = By.xpath("//*[@id=\"Details_Name\"]");
	private By Address1 = By.xpath("//*[@id=\"Details_ShipTo_AddressLine1\"]");
	private By City = By.xpath("//*[@id=\"locality\"]");
	private By ZipCode = By.xpath("//*[@id=\"postal_code\"]");
	private By State = By.xpath("//*[@id=\"administrative_area_level_1\"]");
	private By SameAddressCheckbox = By.xpath("//*[@id=\"tab_details\"]/div[13]/div[2]/div/label");
	private By NextButton = By.xpath("//*[@id=\"btnSave\"]");
	private By SalesPerson1 = By.xpath("//*[@id=\"tab_details\"]/div[2]/div[2]/div/span");
	private By CustomerType1 = By.xpath("//*[@id=\"tab_details\"]/div[5]/div[1]/div/span");
	private By BranchType1 = By.xpath("//*[@id=\"tab_details\"]/div[6]/div[1]/div/span");
	private By MaintenanceType1 = By.xpath("//*[@id=\"tab_details\"]/div[8]/div[2]/div/div/div/input");
	private By Status = By.xpath("//*[@id=\"tab_details\"]/div[8]/div[1]/div/span/span/span[1]");
	private By ServiceContactEmail = By.xpath("//input[@id='ServiceContactEmail']");
	private By ServiceContactName = By.xpath("//input[@id='ServiceContactName']");
	private By ServiceContactNumber = By.xpath("//input[@id='ServiceContactNumber']");
	private By Role = By.xpath("//*[@id=\"DefaultmServiceContactModal\"]/div/div/div[2]/div[5]/div/span/span/span[1]");
	private By ScrapShipmentCheckbx = By.xpath("//input[@data-val-required='The ShippedMail field is required.']");
	private By ServiceContactSaveBtn = By.xpath("//*[@id='btnSaveServiceContact']");
	
	private By ServicieInformationTag = By.xpath("//a[@id='serviceInformation']");
	private By LaborRate = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[1]/div[1]/div/span/span/input[1]");
	private By ServiceCall = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[1]/div[2]/div/span/span/input[1]");
	private By WateringPrice = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[2]/div[1]/div/span/span/span[1]");
	private By WateringRatePerBattery = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[2]/div[2]/div/span/span/input[1]");
	private By EstimatedTechDaysWatering = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[2]/div[3]/div/span/span/input[1]");
	private By BatteryPMPricing = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[3]/div[1]/div/span/span/span[1]");
	private By BatteryPMRatePerBattery =By.xpath("//*[@id=\"tab_serviceInformation\"]/div[5]/div[2]/div/span/span/input[1]");
	private By EstimatedTechDaysBatteryPM =By.xpath("//*[@id=\"ServiceInformations_3__EstimatedTechDays\"]");
    private By UpdateBtn = By.xpath("//*[@id='btnSave']");
    private By BHE = By.xpath("//*[@id=\"tab_serviceInformation\"]/div[5]/div[1]/div/span");
	
	
    private By SheduledMaintenanceTab = By.xpath("//*[@id=\"scheduledMaintenance\"]");
    private By ScheduleMaintenanceDate = By.xpath("//*[@id=\"scheduledMaintenance\"]");
    private By ScheduleMaintenancePeriod = By.xpath("//*[@id=\"collapse0\"]/div/div[1]/div[1]/div/span/span/span[1]");
    private By WateringScheduleMaintenanceDate = By.xpath("//*[@id=\"SchedulingMaintenances_0__ScheduledDate\"]");
    private By BHEScheduleMaintenanceDate = By.xpath("//*[@id=\"SchedulingMaintenances_3__ScheduledDate\"]");
    private By ScheduledMaintenanceWateringMonths = By.xpath("//*[@id=\"collapse0\"]/div/div[1]/div[2]/div/div/div/input");
    private By ScheduleMaintenanceBHEPeriod = By.xpath("//*[@id=\"collapse3\"]/div/div[1]/div[1]/div/span/span/span[2]");
    private By ScheduleMaintenanceBHEMonths = By.xpath("//*[@id=\"collapse3\"]/div/div[1]/div[2]/div/div");
    private By ScheduledMaintenanceUpdateBtn= By.xpath("//*[@id=\"btnSave\"]");
    private By CustomerInfo = By.xpath("//*[@id=\"tab_details\"]/div[1]/div[1]/label");
    
    
	public String CustomerPageHeader() {
		eleUtil.doPresenceOfElementLocated(this.CustomerInfo , Constants.DEFAULT_TIME_OUT);
		return eleUtil.doGetText(NewCustomer);
	}

	public void createCustomer(String CustomerName, String Address1, String City, String State, String ZipCode, String ServiceContactEmail, String ServiceContactName, String ServiceContactNumber)
			throws InterruptedException {
		System.out.println("createCustomer=======================1");
		eleUtil.doSendKeys(this.CustomerName, CustomerName);
		
		By SalesPersonFirstElement = By.xpath("//*[@id=\"SalesPersonId_listbox\"]/li[1]");
		By SalesPersonDropDown = By.xpath("//*[@id=\"SalesPersonId_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(SalesPerson1, SalesPersonDropDown, SalesPersonFirstElement, "Test user");
		System.out.println("createCustomer=======================2");
		By CustomerFirstElement = By.xpath("//*[@id=\"TypeId_listbox\"]/li[1]");
		By CustomerTypeDropDown = By.xpath("//*[@id=\"TypeId_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(CustomerType1, CustomerTypeDropDown, CustomerFirstElement, "Larger Customer");
		
		By BranchTypeFirstElement = By.xpath("//*[@id=\"BranchId_listbox\"]/li[1]");
		By BranchTypeDropDown = By.xpath("//*[@id=\"BranchId_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(BranchType1, BranchTypeDropDown, BranchTypeFirstElement, "JA");

		By MaintenanceTypeFirstElement = By.xpath("//*[@id=\"MaintenanceTypeId_listbox\"]/li[1]");
		By MaintenanceTypeDropDown = By.xpath("//*[@id=\"MaintenanceTypeId_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(MaintenanceType1, MaintenanceTypeDropDown, MaintenanceTypeFirstElement, "Battery Handling Equipment");

		
		By StatusFirstElement = By.xpath("//*[@id=\"StatusId_listbox\"]/li[1]");
		By StatusDropDown = By.xpath("//*[@id=\"StatusId_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(Status, StatusDropDown, StatusFirstElement, "Active");
		
		
		
		eleUtil.doPresenceOfElementLocated(this.Address1, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(this.Address1, Address1);
System.out.println("createCustomer=======================3");
		eleUtil.doPresenceOfElementLocated(this.City, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(this.City, City);

		eleUtil.doPresenceOfElementLocated(this.State, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(this.State, State);

		eleUtil.doPresenceOfElementLocated(this.ZipCode, Constants.DEFAULT_TIME_OUT);
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("document.getElementById('postal_code').value = " + ZipCode);

		eleUtil.doPresenceOfElementLocated(SameAddressCheckbox, Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(SameAddressCheckbox);

		eleUtil.doPresenceOfElementLocated(NextButton, Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(NextButton);
		
		
		eleUtil.doPresenceOfElementLocated(this.ServiceContactEmail, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(this.ServiceContactEmail, ServiceContactEmail);
		
		eleUtil.doPresenceOfElementLocated(this.ServiceContactName, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(this.ServiceContactName, ServiceContactName);
		
		eleUtil.doPresenceOfElementLocated(this.ServiceContactNumber, Constants.DEFAULT_TIME_OUT);
		js.executeScript("document.getElementById('ServiceContactNumber').value = " + ServiceContactNumber);
System.out.println("createCustomer=======================4");
		
		By RoleFirstElement = By.xpath("//*[@id=\"ServiceRoleId_listbox\"]/li[1]");
		By RoleDropDown = By.xpath("//*[@id=\"ServiceRoleId_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(Role, RoleDropDown, RoleFirstElement, "TestRole");
		
		
		
		eleUtil.doPresenceOfElementLocated(ServiceContactSaveBtn, Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(ServiceContactSaveBtn);
		System.out.println("createCustomer=======================5");
	}
	
	public String CreateCustomerServiceInformation(String LaborRate , String ServiceCall , String WateringRatePerBattery , String EstimatedTechDaysWatering , String BatteryPMRatePerBattery , String EstimatedTechDaysBatteryPM) {
		
		eleUtil.doClick(ServicieInformationTag);
		eleUtil.doPresenceOfElementLocated(this.LaborRate, Constants.DEFAULT_TIME_OUT);

		
		
		for (int i = 0; i< Integer.parseInt(LaborRate); i++) {			
			eleUtil.doClick(By.xpath("//*[@id=\"tab_serviceInformation\"]/div[1]/div[1]/div/span/span/span[2]/span[1]"));
		}
		

		
		eleUtil.doPresenceOfElementLocated(this.ServiceCall, Constants.DEFAULT_TIME_OUT);
		
		for (int i = 0; i< Integer.parseInt(ServiceCall); i++) {			
			eleUtil.doClick(By.xpath("//*[@id=\"tab_serviceInformation\"]/div[1]/div[2]/div/span/span/span[2]/span[1]"));
		}

	
		By WateringPriceFirstElement = By.xpath("//*[@id=\"ServiceInformations_0__PmPricing_listbox\"]/li[1]");
		By WateringPriceDropDown = By.xpath("//*[@id=\"ServiceInformations_0__PmPricing_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(WateringPrice, WateringPriceDropDown, WateringPriceFirstElement, "Per Hour");
		
		
		
        eleUtil.doPresenceOfElementLocated(this.WateringRatePerBattery, Constants.DEFAULT_TIME_OUT);
		
		for (int i = 0; i< Integer.parseInt(WateringRatePerBattery); i++) {			
			eleUtil.doClick(By.xpath("//*[@id=\"tab_serviceInformation\"]/div[2]/div[2]/div/span/span/span[2]/span[1]"));
		}
		
		
eleUtil.doPresenceOfElementLocated(this.EstimatedTechDaysWatering, Constants.DEFAULT_TIME_OUT);
		
		for (int i = 0; i< Integer.parseInt(EstimatedTechDaysWatering) * 4; i++) {			
			eleUtil.doClick(By.xpath("//*[@id=\"tab_serviceInformation\"]/div[2]/div[3]/div/span/span/span[2]/span[1]"));
		}
		
		
		
		By BHEFirstElement = By.xpath("//*[@id=\"ServiceInformations_3__PmPricing_listbox\"]/li[1]");
		By BHEDropDown = By.xpath("//*[@id=\"ServiceInformations_3__PmPricing_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(BHE, BHEDropDown, BHEFirstElement, "Per Hour");
		
		
		
eleUtil.doPresenceOfElementLocated(this.BatteryPMRatePerBattery, Constants.DEFAULT_TIME_OUT);
		
		for (int i = 0; i< Integer.parseInt(BatteryPMRatePerBattery); i++) {			
			eleUtil.doClick(By.xpath("//*[@id=\"tab_serviceInformation\"]/div[5]/div[2]/div/span/span/span[2]/span[1]"));
		}
		
		
		
eleUtil.doPresenceOfElementLocated(this.EstimatedTechDaysBatteryPM, Constants.DEFAULT_TIME_OUT);
		
		for (int i = 0; i< Integer.parseInt(EstimatedTechDaysBatteryPM) * 4; i++) {			
			eleUtil.doClick(By.xpath("//*[@id=\"tab_serviceInformation\"]/div[5]/div[3]/div/span/span/span[2]/span[1]"));
		}
		
		
		By custIDBy = By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/h3/b");
		
		return eleUtil.doGetText(custIDBy).split("# ")[1].split(" -")[0];
		
		
	}
			
	public void CreateCustomerScheduledMaintenance() throws InterruptedException {
			
			
		eleUtil.doClick(SheduledMaintenanceTab);
		
		
		By ScheduleMaintenancePeriodFirstElement = By.xpath("//*[@id=\"SchedulingMaintenances_0__Period_listbox\"]/li[1]");
		By ScheduleMaintenancePeriodDropDown = By.xpath("//*[@id=\"SchedulingMaintenances_0__Period_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(ScheduleMaintenancePeriod, ScheduleMaintenancePeriodDropDown, ScheduleMaintenancePeriodFirstElement, "Weekly");
		
			
			
		eleUtil.doPresenceOfElementLocated(ScheduleMaintenanceDate, Constants.DEFAULT_TIME_OUT);
		eleUtil.doClick(ScheduleMaintenanceDate);
		
		
		eleUtil.doSendKeys(WateringScheduleMaintenanceDate, "12/28/2025");
		eleUtil.doSendKeys(BHEScheduleMaintenanceDate, "12/28/2026");
		
		
		
		By ScheduleMaintenanceBHEPeriodFirstElement = By.xpath("//*[@id=\"SchedulingMaintenances_3__Period_listbox\"]/li[1]");
		By ScheduleMaintenanceBHEPeriodDropDown = By.xpath("//*[@id=\"SchedulingMaintenances_3__Period_listbox\"]/li");
		
		eleUtil.selectValueFromCustomSelect(ScheduleMaintenanceBHEPeriod, ScheduleMaintenanceBHEPeriodDropDown, ScheduleMaintenanceBHEPeriodFirstElement, "Weekly");
		
		  
		
		
		eleUtil.doPresenceOfElementLocated(ScheduledMaintenanceWateringMonths,Constants.DEFAULT_TIME_OUT);
		  eleUtil.doClick(ScheduledMaintenanceWateringMonths);
		  System.out.println("CLICKED");
		  
		  By ScheduleMaintenanceWateringMonthsFirstElement =By.xpath("//*[@id=\"Months0_listbox\"]/li[1]");
		  List <WebElement>ScheduleMaintenanceWateringMonthDropDown = driver.findElements(By.xpath("//*[@id=\"Months0_listbox\"]/li"));		  
		  System.out.println("Total size" +ScheduleMaintenanceWateringMonthDropDown.size() );
		  for (WebElement temp : ScheduleMaintenanceWateringMonthDropDown) 
		    {
			  	temp.click();
	
		     
		        }
		  
		  
		  eleUtil.doPresenceOfElementLocated(ScheduleMaintenanceBHEMonths,Constants.DEFAULT_TIME_OUT);
		  eleUtil.doClick(ScheduleMaintenanceBHEMonths);
		  
		  By ScheduleMaintenanceBHEMonthsFirstElement =By.xpath("//*[@id=\"Months3_listbox\"]/li[1]");
		  List <WebElement>ScheduleMaintenanceBHEMonthsDropDown = driver.findElements(By.xpath("//*[@id=\"Months3_listbox\"]/li"));		  
		  System.out.println("Total size" +ScheduleMaintenanceBHEMonthsDropDown.size());
		  
		  for (int i=0 ; i <ScheduleMaintenanceBHEMonthsDropDown.size();i++) {
			  
			  Thread.sleep(200);
			  ScheduleMaintenanceBHEMonthsDropDown.get(i).click();
			  
		  }
		  
		  
		   eleUtil.doPresenceOfElementLocated(ScheduledMaintenanceUpdateBtn,Constants.DEFAULT_TIME_OUT);
		   eleUtil.doClick(ScheduledMaintenanceUpdateBtn);
	}
	
	public boolean ValidateCustomerId (String curCustId) throws InterruptedException {
		By custIdEle = By.xpath("//*[@id=\"Customergridlist\"]/div[3]/table/tbody/tr/td[1]/a");
		   
		  boolean isIdFound = false;
		  List<WebElement> listOfEle = eleUtil.getElements(custIdEle);
			for (int i = 0; i < listOfEle.size(); i++) {
				String id = listOfEle.get(i).getText();
				if (id.equals(curCustId)) {
					isIdFound = true;
					break;
				}
			}
		   
			Thread.sleep(2000);
			return isIdFound;
	}
	
	public CreateWorkOrderPage WorkOrder() throws InterruptedException {
		return new CreateWorkOrderPage(driver);
	}
	

		
	
			
}
