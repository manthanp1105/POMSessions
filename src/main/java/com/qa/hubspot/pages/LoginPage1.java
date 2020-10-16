package com.qa.hubspot.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage1;

public class LoginPage1 extends BasePage1 {

	Properties prop;
	WebDriver driver;
	By emailid = By.id("username");
	By passwordfield = By.id("password");
	By loginbutton = By.id("loginBtn");
	By signuplink = By.linkText("Sign up");
	By showpasswordlink = By.id("password-help");
	By forgotpasswordlink = By.linkText("Forgot my password");


	public LoginPage1(WebDriver driver) {
		this.driver = driver;
	}

	public boolean signUpLinkIsDisplayed() {
		return driver.findElement(signuplink).isDisplayed();

	}
	public String verifyLoginPageTitle() {
		return driver.getTitle();
		
	}
	public void doLogin1(String username, String pwd) {
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(passwordfield).sendKeys(pwd);
		driver.findElement(loginbutton).click();	
	}
	public boolean showPasswordLinkisDisplayed() {
		return driver.findElement(showpasswordlink).isDisplayed();
		
	}
	public boolean forgotPasswordLinkisDisplayed() {
		return driver.findElement(forgotpasswordlink).isDisplayed();
		
	}


}
