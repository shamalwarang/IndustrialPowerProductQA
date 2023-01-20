package com.qa.ipp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ipp.utils.Constants;
import com.qa.ipp.utils.ElementUtil;

public class HomePage {

	//1. Declare private webdriver
		private WebDriver driver;
		private ElementUtil eleUtil;
		
		private By Dashboard = By.xpath("//*[@id=\"main-wrapper\"]/div[3]/div/h3/b");
		//private By Logo = By.xpath("//*[@id=\"MyLogo\"]/img");
		private By Profile = By.xpath("//*[@id=\"main-wrapper\"]/div[1]/nav/div[2]/ul[2]/li[2]/a");
		private By LoggedinUser = By.xpath("//*[@id=\"main-wrapper\"]/div[1]/nav/div[2]/ul[2]/li[2]/div/ul/li[1]/a");
		private By Logout  = By.xpath("//*[@id=\"main-wrapper\"]/div[1]/nav/div[2]/ul[2]/li[2]/div/ul/li[2]/a");
		private By Customer = By.xpath("//*[@id=\"sidebarnav\"]/li[2]/a");
		private By AddCustomer = By.xpath("//*[@id=\"sidebarnav\"]/li[2]/ul/li[2]/a");
		private By WorkOrder = By.xpath("//*[@id=\"sidebarnav\"]/li[6]/a/span");
		private By CreateWorkOrder = By.xpath("//*[@id=\"sidebarnav\"]/li[6]/ul/li[2]/a");
		
		
		//2. Page constructor
		public HomePage(WebDriver driver) {
			this.driver=driver;
			eleUtil = new ElementUtil(driver);
		}
		
		public String getHomePageTitle() {
			return eleUtil.getPageTitle(Constants.HOME_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
			
		}
		
		public String HomePageHeader() {
			return eleUtil.doGetText(Dashboard);
		}

		/*public boolean HomePageLogo() {
			return eleUtil.doIsDisplayed(Logo);
		}
		*/
		public void HomePageUser() {
			 eleUtil.doClick(Profile);
				eleUtil.doPresenceOfElementLocated(LoggedinUser, Constants.DEFAULT_TIME_OUT);
		}
		
		public boolean HomePageLoggedinuser() {
			return eleUtil.doIsDisplayed(LoggedinUser);
		}
		
		public boolean HomePageLogout() {
			return eleUtil.doIsDisplayed(Logout);
		}
		
		public boolean Customer() {
			return eleUtil.doIsDisplayed(Customer);
		}
		
		public void ClickCustomer() {
			if(Customer()) {
				eleUtil.doClick(Customer);
			}
		}
		
		public boolean AddCustomer() {
			return eleUtil.doIsDisplayed(AddCustomer);
		}
		
		public AddCustomerPage ClickAddCustomer() throws InterruptedException {
			if(AddCustomer()) {
				eleUtil.doClick(AddCustomer);
				Thread.sleep(2000);
			}
			return new AddCustomerPage(driver);
		}
		
		public void Logout() {
			if(HomePageLogout()) {
				eleUtil.doClick(Logout);
			}
		}
		
}
