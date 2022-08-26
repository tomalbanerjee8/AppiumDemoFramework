package com.wiciproject.stepdefination;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.OutputType;

import com.wiciproject.genericmethod.BaseUtil;
import com.wiciproject.genericmethod.GenericMethods;
import com.wiciproject.pageobjects.LoginPage;
import com.wiciproject.utility.DriverManager;
import com.wiciproject.utility.TestUtility;

import cucumber.api.Scenario;
import io.cucumber.java.en.Given;

public class GivenStepDefination extends BaseUtil{
	
		private BaseUtil base;
		
		public GivenStepDefination(BaseUtil base) {
		this.base=base;
	}

		DriverManager driverManager= new DriverManager();
		GenericMethods genrericMethods = new GenericMethods();
		TestUtility utils = new TestUtility();
	

//		@Given("I login lounch the app and verify")public void iLoginLounchTheAppAndVerify() throws InterruptedException{
//		utils.waitForPageLoad(10);
//		new LoginPage().enterUserName("12345");
//		String getTextElement =new LoginPage().getUserNameText();
//		assertEquals("Test case failed both are not matching", getTextElement, "12345");
//	}
		
		@Given("I login lounch the app and verify")
		public void iLoginLounchTheAppAndVerifyOne() throws InterruptedException{
			String userID ="12345";
			utils.waitForPageLoad(10);
			new LoginPage().enterUserName(userID);
			base.stepInfo=userID;
			//user id veriable to session context 
			
		}
		
		@Given("I verify the username")
		public void iLoginLounchTheAppAndVerifyOneTwo() throws InterruptedException{
			String getTextElement =new LoginPage().getUserNameText();
			assertEquals("Test case failed both are not matching", getTextElement, base.stepInfo);
			//user id veriable need to get it from session context 
		}
		
		@Given("I login lounch the app and insert username")
		public void iLoginLounchTheAppAndVerifyOneThree() throws InterruptedException{
			String userID ="123456";
			utils.waitForPageLoad(10);
			new LoginPage().enterUserName(userID);
			base.stepInfo=userID;
			//user id veriable to session context 
			
		}
		
		@Given("I verify the username is proper")
		public void iLoginLounchTheAppAndVerifyOneTwoThreeFour() throws InterruptedException{
			String getTextElement =new LoginPage().getUserNameText();
			assertEquals("Test case failed both are not matching", getTextElement,base.stepInfo);
			//user id veriable need to get it from session context 
		}
		
}
