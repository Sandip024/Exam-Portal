package com.ep.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage
{
	WebDriver driver;
	
	public SettingsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Application')]")
	@CacheLookup 
	WebElement application_menu;
	
	@FindBy(xpath="//label[contains(text(),'Search:')]//input")
	@CacheLookup 
	WebElement search;
	
	@FindBy(className="dataTables_empty")
	@CacheLookup 
	WebElement empty_table;
	
	@FindBy(xpath="//a[contains(text(),'Create New')]")
	@CacheLookup 
	WebElement create_setting;
	
	@FindBy(id="SettingKey")
	@CacheLookup 
	WebElement setting_key;

	@FindBy(id="SettingValue")
	@CacheLookup 
	WebElement setting_value;

	@FindBy(id="Active")
	@CacheLookup 
	WebElement active_button;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	@CacheLookup 
	WebElement click_Create;
	
	@FindBy(xpath="//input[@class='btn btn-danger']")
	@CacheLookup 
	WebElement click_Delete;
	
	@FindBy(xpath="//h6[contains(text(),'Setting Details')]")
	@CacheLookup 
	WebElement confirm_Details;
	
	@FindBy(xpath="//a[contains(text(),'Back to List')]")
	@CacheLookup 
	WebElement back_To_List;
	
	
	
	public void clickApplicationMenu()
	{
		application_menu.click();
	}
	
	public void searchSetting(String settings_key)
	{
		search.sendKeys(settings_key);
	}

	public boolean isTableEmpty()
	{
		boolean tablestatus = empty_table.isDisplayed();
		return tablestatus;
	}
	
	public void clickCreateNewSetting()
	{
		create_setting.click();
	}
	
	public void enterSettingKey(String settings_key)
	{
		setting_key.clear();
		setting_key.sendKeys(settings_key);
	}
	
	public void enterSettingValue(String settings_value)
	{	
		setting_value.clear();
		setting_value.sendKeys(settings_value);
	}
	
	public void clickActive()
	{
		active_button.click();
	}
	
	public void clickCreate()
	{
		click_Create.click();
	}
	
	public void clickDelete()
	{
		click_Delete.click();
	}
	
	public boolean isDetailsPresent()
	{
		boolean detail = confirm_Details.isDisplayed();
		return detail;
	}
	
	public void backToList()
	{
		back_To_List.click();
	}
	
	
	
	
	
	
	
	
	
}
