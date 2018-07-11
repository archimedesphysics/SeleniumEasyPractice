package com.seleniumeasy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
	private WebDriver driver; 
	
	

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Alerts & Modals")
	public WebElement allertsLink; 
	
	public void gotoAlerts(){
		
		allertsLink.click();
	}
	
}
