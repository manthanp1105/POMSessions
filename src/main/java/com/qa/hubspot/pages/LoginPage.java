package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;
	BasePage basepage;
	By emailid = By.id("username");
	By pwd = By.id("password");
	By signuplink = By.linkText("Sign up");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public void doLogin(String username, String password) {
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(signuplink).click();

	}

	public boolean signUpLinkDisplayed() {
		return driver.findElement(signuplink).isDisplayed();
	}
}
