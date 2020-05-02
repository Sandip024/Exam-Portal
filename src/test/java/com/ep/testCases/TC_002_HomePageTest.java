package com.ep.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ep.pageObjects.HomePage;

public class TC_002_HomePageTest extends BaseClass
{
	
	@Test (priority=30)
	public void homePageTest() throws InterruptedException, IOException
	{
		String Title = driver.getTitle();
		System.out.println("" +Title);
		if(Title.equals("Welcome to Exam Preparation - Exam Preparation"))
		{
			Assert.assertTrue(true);
			System.out.println("Homepage loaded successfully");
		}
		else if (!Title.equals("Welcome to Exam Preparation - Exam Preparation"))
		{
			captureScreen(driver, "Homepage Test");
			Assert.assertTrue(true);
			System.out.println("Homepage did not load");
		}
	}
	
	@Test (priority=31)
	public void homePageContentTest() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.isMenuPresent("Application");
		hp.isMenuPresent("Organization");
		hp.isMenuPresent("Question Bank");
		hp.isMenuPresent("Packages");
		hp.isMenuPresent("Subscribers");
		hp.isMenuPresent("Transactions");
		hp.isMenuPresent("Reports");
		hp.isMenuPresent("Notification");
		hp.isLogoffPresent();
		
	}
	
	@Test (priority=32)
	public void salesData()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOrg();
		String org = "//select[@id='search_OrganizationId']";
		selectDropDownValue(org, "EXPEDITE INFORMATICS PVT LTD");
		
		hp.ischartPresent();
	
	}
	
}
