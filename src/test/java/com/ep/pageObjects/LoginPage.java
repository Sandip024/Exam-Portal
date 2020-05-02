package com.ep.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (id="loginLink")
	@CacheLookup 
	WebElement linkLogin;

	@FindBy (id="Email")
	@CacheLookup 
	WebElement textUsername;

	@FindBy (id="Password")
	@CacheLookup 
	WebElement textPassword;

	@FindBy (xpath="//input[@class='btn btn-primary']")
	@CacheLookup 
	WebElement buttonLogin;

	@FindBy (xpath="//input[@class='btn btn-secondary']")
	@CacheLookup 
	WebElement buttonForgetPassword;

	@FindBy (id="Email-error")
	@CacheLookup 
	WebElement emailError;

	@FindBy (id="Password-error")
	@CacheLookup 
	WebElement passwordError;

	@FindBy (xpath="//li[contains(text(),'Invalid login attempt.')]")
	@CacheLookup 
	WebElement invalidLoginAttempt;

	public void clickLoginLink()
	{
		linkLogin.click();
	}

	public void setUserName(String uname)
	{
		textUsername.clear();
		textUsername.sendKeys(uname);
	}	

	public void setPassword(String pwd)
	{
		textPassword.clear();
		textPassword.sendKeys(pwd);
	}	

	public void clickLogin()
	{
		buttonLogin.click();
	}	

	public boolean isEmailError()
	{
		boolean email_error = emailError.isDisplayed();
		return email_error;
	}

	public boolean isPasswordError()
	{
		boolean pwd_error = passwordError.isDisplayed();
		return pwd_error;
	}

	public boolean isInvalidAttempt()
	{
		boolean invalid_error = invalidLoginAttempt.isDisplayed();
		return invalid_error;
	}


	public void clickForgetPassword()
	{
		buttonForgetPassword.click();
	}


}
