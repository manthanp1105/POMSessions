package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;

	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			System.out.println("Please provide the browser ");
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream in = new FileInputStream("/Users/manthan/eclipse-workspace/POMSessions/src/"
					+ "main/java/com/qa/hubspot/configuration/config.properties");
			try {
				prop.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

}
