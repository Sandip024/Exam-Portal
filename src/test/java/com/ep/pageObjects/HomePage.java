package com.ep.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Q')]")
	@CacheLookup 
	WebElement xpath;

	@FindBy(id="navbarDropdownMenuLink")
	@CacheLookup 
	WebElement logoff;

	@FindBy(xpath="//select[@id='search_OrganizationId']")
	@CacheLookup 
	WebElement org;
	
	@FindBy(xpath="//div[@class='container body-content text-center']//img")
	@CacheLookup 
	WebElement chart;
	
	
	public void isMenuPresent(String menu)
	{
		String xpath = "//ul/li/a[contains(text(),'"+menu+"')]";
		if(driver.findElement(By.xpath(xpath))!= null)
		{
			System.out.println(menu+" Menu is Present");
		}else
		{
			System.out.println(menu+" Menu is Absent");
		}
	}
	
	public void isLogoffPresent()
	{
		if (logoff.isDisplayed())
		{
			System.out.println("Logoff Menu is Present");
		}else
		{
			System.out.println("Logoff Menu is Absent");
		}
	}
	public void clickOrg()
	{
			org.click();
	}
	
	public void ischartPresent()
	{
		if (chart.isDisplayed())
		{
			System.out.println("Chart is Present");
		}else
		{
			System.out.println("Chart is Absent");
		}
	}
	
	
}
