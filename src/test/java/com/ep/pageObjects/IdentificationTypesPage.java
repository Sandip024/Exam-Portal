package com.ep.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentificationTypesPage
{
WebDriver driver;
	
	public IdentificationTypesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Application')]")
	@CacheLookup 
	WebElement application_menu;
	
	public void clickApplicationMenu() 
	{
		application_menu.click();
	}
	
	
	@FindBy(xpath="//label[contains(text(),'Search:')]//input")
	@CacheLookup 
	WebElement search;
	
	@FindBy(className="dataTables_empty")
	@CacheLookup 
	WebElement empty_table;
		
	public boolean isIdTypeExists(String Id_Name)
	{
		search.sendKeys(Id_Name);
		boolean tablestatus = empty_table.isDisplayed();
		return tablestatus;
	}

	
	@FindBy(xpath="//a[contains(text(),'Create New')]")
	@CacheLookup 
	WebElement create_setting;
	
	@FindBy(id="Description")
	@CacheLookup 
	WebElement Description;

	@FindBy(id="Active")
	@CacheLookup 
	WebElement active_button;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	@CacheLookup 
	WebElement click_Create;
	
	public void clickCreateNewIdType(String Id_Name)
	{
		create_setting.click();
		Description.clear();
		Description.sendKeys(Id_Name);
		active_button.click();
		click_Create.click();	
	}
	
	public void clickEditIdType(String Id_Name)
	{
		
		Description.clear();
		Description.sendKeys(Id_Name);
		active_button.click();
		click_Create.click();
		
	}
	
	
	@FindBy(xpath="//input[@class='btn btn-danger']")
	@CacheLookup 
	WebElement click_Delete;
	
	public void clickDelete()
	{
		click_Delete.click();
	}
	
	
	@FindBy(xpath="//h6[contains(text(),'Identification Type Details')]")
	@CacheLookup 
	WebElement confirm_Details;
	
	@FindBy(xpath="//a[contains(text(),'Back to List')]")
	@CacheLookup 
	WebElement back_To_List;
	
	public boolean isDetailsPresent()
	{
		boolean detail = confirm_Details.isDisplayed();
		back_To_List.click();
		return detail;
	}
}
