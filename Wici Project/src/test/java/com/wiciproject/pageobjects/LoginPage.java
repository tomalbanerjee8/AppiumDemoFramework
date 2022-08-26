package com.wiciproject.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wiciproject.genericmethod.GenericMethods;



public class LoginPage extends BaseClass{
	
	@FindBy (xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]") 
	private WebElement Username;


	public LoginPage(){
	}

	public LoginPage enterUserName(String username) {
		utils.waitForPageLoad(10);
		Username.clear();	
		Username.sendKeys(username);
		return this;
	}
	public String getUserNameText() {
		utils.waitForPageLoad(10);
		String getElement= new GenericMethods().getText(Username);
		return getElement;
	}
}

