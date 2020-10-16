package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage1;
import com.qa.hubspot.pages.LoginPage1;
import com.qa.hubspot.util.Constants;

public class LoginPageTest1 {

	LoginPage1 loginpage1;
	BasePage1 basepage1;
	Properties prop;
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		basepage1 = new BasePage1();
		loginpage1 = new LoginPage1(driver);
		prop = basepage1.init_Properties1();
		driver = basepage1.driver_init1(prop);

	}

	@Test(priority = 1)
	public void signUpLinkIsDisplayed() {
		Assert.assertTrue(loginpage1.signUpLinkIsDisplayed());

	}

	@Test(priority = 2)
	public void loginPageTitleVerify() {
		String title1 = loginpage1.verifyLoginPageTitle();
		Assert.assertEquals(title1, Constants.Loginpage_title);

	}

	@Test(priority = 3)
	public void doLoginVerify() {
		loginpage1.doLogin1(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void verifyForgotPasswordLink() {
		Assert.assertTrue(loginpage1.forgotPasswordLinkisDisplayed());
	}

	@Test(priority = 5)
	public void verifyShowPasswordLink() {
		Assert.assertTrue(loginpage1.showPasswordLinkisDisplayed());
	}

	@AfterMethod
	public void tearDOwn1() {
		driver.quit();
	}

}
