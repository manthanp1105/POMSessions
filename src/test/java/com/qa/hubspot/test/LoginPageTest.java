package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {

	BasePage basepage;
	LoginPage loginpage;
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setUp() {

		basepage = new BasePage();
		prop = basepage.init_properties();
		driver =basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.Loginpage_title);
	}

	@Test(priority = 2)
	public void signUpLinkTest() {
		Assert.assertTrue(loginpage.signUpLinkDisplayed());
	}

	@Test(priority = 3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
