package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		loginPage.validateCRMImage();
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.loginAction(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
	
}