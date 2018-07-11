package com.seleniumeasy.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;

import com.seleniumeasy.util.Configuration;
import com.seleniumeasy.util.Driver; 

public class TestBase {
	
	protected WebDriver driver;

	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		driver = Driver.getDriver(null);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(Configuration.getProperty("url"));
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		Driver.quit();
	}
}
