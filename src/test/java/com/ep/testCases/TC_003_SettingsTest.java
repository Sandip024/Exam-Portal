package com.ep.testCases;

import org.testng.annotations.Test;

import com.ep.pageObjects.SettingsPage;

public class TC_003_SettingsTest extends BaseClass
{
	@Test (priority=0)
	public void opensettingsPageTest() throws InterruptedException
	{
		SettingsPage sp = new SettingsPage(driver);
		sp.clickApplicationMenu();
		Thread.sleep(2000);
		String xpath = "//ul[@class='navbar-nav mr-auto']//li[1]//div[1]//a";
		selectDropDownValue(xpath,"Settings");
		Thread.sleep(2000);
		
		String xpath1 = "//*[@id='DataTables_Table_0_length']/label/select/option";
		selectDropDownValue(xpath1,"100");
	}
	
	@Test (priority=1)
	public void findIfSettingExistsTest()
	{
		SettingsPage sp = new SettingsPage(driver);
				
		sp.searchSetting("Logoff_Time");
		if(sp.isTableEmpty()==true)
		{
			System.out.println("No such setting exist.");
		}
	}

	@Test (priority=2)
	public void createNewSetting()
	{
		SettingsPage sp = new SettingsPage(driver);
		sp.clickCreateNewSetting();
		sp.enterSettingKey("Logoff_Time");
		sp.enterSettingValue("5");
		sp.clickActive();
		sp.clickCreate();
	}
	
	@Test (priority=3)
	public void editSetting()
	{
		SettingsPage sp = new SettingsPage(driver);
		performAction("Logoff_Time", edit);
		sp.enterSettingKey("Logoff_Time");
		sp.enterSettingValue("6");
		sp.clickActive();
		sp.clickCreate();
		System.out.println("Setting Key edited");
	}
	
	@Test (priority=4)
	public void seeDetailsOfSetting()
	{
		SettingsPage sp = new SettingsPage(driver);
		performAction("Logoff_Time", details);
		if(sp.isDetailsPresent()==true)
		{
			System.out.println("Details are visible");
		}
		sp.backToList();
	}
	
	
	@Test (priority=5)
	public void deletSetting()
	{
		SettingsPage sp = new SettingsPage(driver);
		performAction("Logoff_Time", delete);
		sp.clickDelete();
		System.out.println("Setting Key deleted");
	}
		
}