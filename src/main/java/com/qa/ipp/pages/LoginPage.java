package com.qa.ipp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ipp.utils.Constants;
import com.qa.ipp.utils.ElementUtil;

public class LoginPage {

	//1. Declare private webdriver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. Page constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. by locators
	private By username = By.xpath("//*[@type='email']");
	private By nextbutton = By.xpath("//input[@id='idSIButton9']");
	private By password = By.id("i0118");
	private By signin = By.xpath("//input[@id='idSIButton9']");
	private By signin1 = By.xpath("//input[@id='idSIButton9']");
	private By forgotpassword = By.linkText("Forgot my password");
	private By CantAccessAccountLink = By.linkText("Can’t access your account?");
	private By StaySignedIn = By.xpath("//input[@id='idSIButton9']");
	
	
	public String getLoginPageTitle() {
		return eleUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		
	}
	
	public boolean getLoginPageUrl() {
		return eleUtil.waitForURL(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	/*public boolean isForgotPWLinkdisplayed() {
		
		return eleUtil.doIsDisplayed(forgotpassword);
	}*/
	
	public boolean CantAccessAccountLink() {
		return eleUtil.doIsDisplayed(CantAccessAccountLink);
	}
	
	public HomePage doLogin(String un, String pw) 
	{
		System.out.println("Login with" +un + ":" +pw);
		eleUtil.doSendKeys(username, un);
		eleUtil.doClick(nextbutton);
		eleUtil.doPresenceOfElementLocated(forgotpassword, Constants.DEFAULT_TIME_OUT);
		
		
		eleUtil.doSendKeys(password, pw);
		eleUtil.doClick(signin1);
		eleUtil.doPresenceOfElementLocated(StaySignedIn, Constants.DEFAULT_TIME_OUT);
		

		eleUtil.doClick(StaySignedIn);
		return new HomePage(driver);
		

	}


}