package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		testUtil=new TestUtil();
		homePage=loginPage.loginAction(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		homePage.verifyCorrectUserName();
	}
	
	@Test(priority=2)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
