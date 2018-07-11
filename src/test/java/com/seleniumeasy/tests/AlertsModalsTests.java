package com.seleniumeasy.tests;

import static org.testng.Assert.assertEquals;
import static com.seleniumeasy.util.TestUtil.*; 
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumeasy.base.TestBase;
import com.seleniumeasy.pages.AlertsandModalsPage;
import com.seleniumeasy.pages.MenuPage;

public class AlertsModalsTests extends TestBase {

	@BeforeMethod
	public void setUpMethod(){
		
		MenuPage menu=new MenuPage(driver); 
		menu.gotoAlerts();
		
		
	}
	@Test
	public void bootstrapAlerts(){
		
		AlertsandModalsPage alerts= new AlertsandModalsPage(driver); 
		alerts.clickBootStrapAlerts();
		alerts.successAuto.click();
		String expected="I'm an autocloseable success message. I will hide in 5 seconds."; 
		String actual=alerts.successAutoMessage.getText();
		// verify that text is visible
		assertEquals(actual, expected);
		
		//verify that text is not visible anymore. 
		WebDriverWait wait= new WebDriverWait(driver, 6); 
		Boolean gone= wait.until(ExpectedConditions.invisibilityOf(alerts.successAutoMessage)); 
		Assert.assertTrue(gone);
		
		//click on normal success
		alerts.successNormal.click();
		String expected1= "I'm a normal success message. To close use the appropriate button.";
		String actual1=alerts.successNormalMessage.getText();
		assertEquals(expected1, actual1.substring(1).trim()); 
		alerts.close.click();
		 
		assertEquals(alerts.successNormalMessage.getAttribute("style"),"display: none;"); 
		
		
	}
	@Test
	public void bootstrapModals() {
	
		AlertsandModalsPage alerts= new AlertsandModalsPage(driver); 
		alerts.bootstrapModals.click();
		
		driver.switchTo().activeElement(); 
		alerts.singleModalButton.click(); 
		String expected="This is the place where the content for the modal dialog displays"; 
		WebDriverWait wait= new WebDriverWait(driver, 6); 
		 wait.until(ExpectedConditions.visibilityOf(alerts.singleModalBody)); 
		
		assertEquals(alerts.singleModalBody.getText(), expected); 
		
		alerts.saveChanges.click(); 
	//	driver.switchTo().activeElement();
		
		alerts.multipleModalButton.click();
		WebDriverWait wait2= new WebDriverWait(driver, 6); 
		 wait2.until(ExpectedConditions.visibilityOf(alerts.multiModalBody1)); 
	
		driver.switchTo().activeElement();
		String expected2="Click launch modal button to launch second modal."; 	
		assertEquals(alerts.multiModalBody1.getText(), expected2);
		alerts.launchModalinFirstModal.click();
		driver.switchTo().activeElement();
		wait2.until(ExpectedConditions.visibilityOf(alerts.multipleModal2Body)); 
		String expected3="This is the place where the content for the modal dialog displays.";
		assertEquals(alerts.multipleModal2Body.getText(), expected3);
		alerts.multipleModal2CloseBtn.click();
		driver.switchTo().activeElement();
		wait2.until(ExpectedConditions.visibilityOf(alerts.multipleModal2Body)); 
		String expected4="This is the place where the content for the modal dialog displays.";
		assertEquals(alerts.multipleModal2Body.getText(), expected4);
		//close the first modal
		Actions actions=new Actions(driver); 
		actions.moveToElement(alerts.multiModal1CloseBtn).click().build().perform();
		
		String expected5= "Bootstrap Modal Example for Automation"; 
		assertEquals(alerts.headerModalExample.getText(), expected5);
		
	}
	
	@Test
	public void windowPopupModal(){
		
		AlertsandModalsPage alerts= new AlertsandModalsPage(driver);
		alerts.windowModalLink.click();
		String expectedheader="Window popup Modal Example for Automation"; 
		assertEquals(alerts.windowModalHeader.getText(), expectedheader);
		alerts.singlePopupBtn.click();
		switchToNewWindowByTitle(driver, 2); 
		//System.out.println(driver.getTitle()); 
		driver.close();
		
	
	}
}
