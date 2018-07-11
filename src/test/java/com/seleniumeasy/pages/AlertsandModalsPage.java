package com.seleniumeasy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumeasy.base.TestBase;

public class AlertsandModalsPage extends TestBase {
	private WebDriver driver; 
	
	
	
	
	public AlertsandModalsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Bootstrap Alerts")
	public WebElement bootstrapAlerts; 
	
	@FindBy(id="autoclosable-btn-success")
	public WebElement successAuto; 
	
	@FindBy(id="normal-btn-success")
	public WebElement successNormal;
	
	@FindBy(id="autoclosable-btn-warning")
	public WebElement warningAuto;
	
	@FindBy(id="normal-btn-warning")
	public WebElement warningNormal;
	
	@FindBy(id="autoclosable-btn-danger")
	public WebElement dangerAuto;
	
	@FindBy(id="normal-btn-danger")
	public WebElement dangerNormal;
	
	@FindBy(id="autoclosable-btn-info")
	public WebElement infoAuto;
	
	@FindBy(id="normal-btn-info")
	public WebElement infoNormal;
	
	@FindBy(xpath="//div[contains(text(),'autocloseable success')]")
	public WebElement successAutoMessage; 
	
	@FindBy(xpath="//div[contains(@class,'normal-success')]")
	public WebElement successNormalMessage; 
	
	@FindBy(className="close")
	public WebElement close; 
	
	public void clickBootStrapAlerts(){
		bootstrapAlerts.click();
	}
	
	// Modals
	@FindBy(linkText="Bootstrap Modals")
	public WebElement bootstrapModals; 
	@FindBy (tagName="h2")
	public WebElement headerModalExample; 
	
	@FindBy(xpath="//div[@class='panel-heading'][contains(text(),'Single')]//following-sibling::div/a")
	public WebElement singleModalButton; 
	
	@FindBy(xpath="//div[@id='myModal0']//div[@class='modal-body']")
	public WebElement singleModalBody; 
	
	@FindBy (xpath="//div[@id='myModal0']//div[@class='modal-footer']/a[.='Save changes']")
	public WebElement saveChanges; 
	
	@FindBy(xpath="//div[@class='panel-heading'][contains(text(),'Multiple')]//following-sibling::div/a")
	public WebElement multipleModalButton;
	
	@FindBy(xpath="//div[@id='myModal']//div[@class='modal-body']/p[1]")
	public WebElement multiModalBody1; 
	@FindBy(xpath="//div[@id='myModal']//div[@class='modal-body']/a")
	public WebElement launchModalinFirstModal; 
	@FindBy(xpath="//div[@id='myModal']//div[@class='modal-footer']/a[.='Close']")
	public WebElement multiModal1CloseBtn; 
	
	@FindBy(xpath="//div[@id='myModal2']//div[@class='modal-body']")
	public WebElement multipleModal2Body;
	
	@FindBy(xpath="//div[@id='myModal2']//div[@class='modal-footer']/a[.='Close']")
	public WebElement multipleModal2CloseBtn; 
	
	//WindowPopups
	@FindBy(linkText="Window Popup Modal")
	public WebElement windowModalLink; 
	
	@FindBy(tagName="h2")
	public WebElement windowModalHeader;
	
	@FindBy (linkText="Follow On Twitter")
	public WebElement singlePopupBtn; 
	
	
	
	
	
	@FindBy (linkText="Follow All")
	public WebElement multiplePopupBtn;
}
