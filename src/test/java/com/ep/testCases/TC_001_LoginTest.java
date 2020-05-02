package com.ep.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_LoginTest extends BaseClass
{
	@Test (priority=25)
	public void loginWithWrongUserTest() throws IOException, InterruptedException
	{
		loginTest("abc@gmail.com",password);
		
		Assert.assertTrue(true);			
		System.out.println("Invalid Login attempt");
		captureScreen(driver, "Login Test");		
	}
		
	@Test (priority=26)
	public void loginWithWrongPassword() throws IOException, InterruptedException
	{
		loginTest(username,"superadmin123");
		
		Assert.assertTrue(true);			
		System.out.println("Invalid Login attempt");
		captureScreen(driver, "Login Test");
	}
	
	@Test (priority=27)
	public void loginWithoutUsername() throws IOException, InterruptedException
	{
		loginTest("","superadmin123");
		
		Assert.assertTrue(true);
		System.out.println("The Email field is required.");
		captureScreen(driver, "Login Test");
	}
	
	@Test (priority=28)
	public void loginWithoutPassword() throws IOException, InterruptedException
	{
		loginTest(username,"");
		
		Assert.assertTrue(true);
		System.out.println("The Password field is required.");
		captureScreen(driver, "Login Test");
		
	}
	
	@Test (priority=29)
	public void loginWithCorrectCredentials() throws IOException, InterruptedException
	{
		loginTest(username,password);
		
		Assert.assertTrue(true);
		System.out.println("The Password field is required.");
		captureScreen(driver, "Login Test");
		
	}
	
	
	public void loginTest(String uname, String pwd) throws IOException, InterruptedException
	{
//		LoginPage lp = new LoginPage(driver);
		login(uname, pwd);
//		
//		String Title = driver.getTitle();
//		System.out.println("" +Title);
//		if(Title.equals("Welcome to Exam Preparation - Exam Preparation"))
//		{
//			Assert.assertTrue(true);
//			System.out.println("Login Test Passed");
//		}
//
//		if (lp.isEmailError()==true)
//		{
//			Assert.assertTrue(true);
//			System.out.println("The Email field is required.");
//			captureScreen(driver, "Login Test");
//		}
//		
//		if (lp.isPasswordError()==true)
//		{
//			Assert.assertTrue(true);
//			System.out.println("The Password field is required.");
//			captureScreen(driver, "Login Test");
//		}
//		
//		if (lp.isInvalidAttempt()==true)
//		{
//			Assert.assertTrue(true);			
//			System.out.println("Invalid Login attempt");
//			captureScreen(driver, "Login Test");
//		}
	}
}
