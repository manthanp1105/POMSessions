package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage1 {
	WebDriver driver;
	Properties prop;

	public WebDriver driver_init1(Properties prop) {

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else
			System.out.println("Please provide valid browser");
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		return driver;
	}

	public Properties init_Properties1() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("/Users/manthan/eclipse-workspace/POMSessions/src/"
					+ "main/java/com/qa/hubspot/configuration/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		return prop;

	}
}
