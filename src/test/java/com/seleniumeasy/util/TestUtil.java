package com.seleniumeasy.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtil {

	public static void switchToNewWindowByTitle(WebDriver driver, WebElement title){
		
		//String firstWindow= driver.getWindowHandle(); 
		
		Set<String> handler= driver.getWindowHandles(); 
		
		Iterator<String> it= handler.iterator(); 
		
		String parentWindowId= it.next();
		System.out.println(parentWindowId);
		
		
		
		
		}
		
	
		
	}
	
	
	


