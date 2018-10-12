package com.crm.qa.pages;

import org.testng.Assert;

import com.crm.qa.base.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends TestBase {

	
	//Page factory or Object repository
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Returns page title
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public void validateCRMImage(){
		Assert.assertTrue(crmLogo.isDisplayed());
	}
	
	public HomePage loginAction(String username, String ppassword) {
		
		userName.sendKeys(username);
		password.sendKeys(ppassword);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginButton);
		
		return new HomePage();
	}
}
