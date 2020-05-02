package com.ep.testCases;


import org.testng.annotations.Test;

import com.ep.pageObjects.IdentificationTypesPage;

public class TC_004_IdentificationTypesTest extends BaseClass
{
	@Test (priority=6)
	public void openIdTypesPageTest() throws InterruptedException
	{
		IdentificationTypesPage ip = new IdentificationTypesPage(driver);
		ip.clickApplicationMenu();
		Thread.sleep(2000);
		String xpath = "//ul[@class='navbar-nav mr-auto']//li[1]//div[1]//a";
		selectDropDownValue(xpath,"Identification Types");
		Thread.sleep(2000);
		
		String xpath1 = "//*[@id='DataTables_Table_0_length']/label/select/option";
		selectDropDownValue(xpath1,"100");
	}
	
//	@Test (priority=6)
//	public void openIdTypesPageTest() throws InterruptedException
//	{
//		IdentificationTypesPage ip = new IdentificationTypesPage(driver);
//		ip.clickApplicationMenu();
//		String value = "Id";
//		driver.findElement(By.xpath("//a[starts-with(text(),'"+value+"')]")).click();
//	}
	
	@Test (priority=7)
	public void findIfIdTypeExistsTest()
	{
		IdentificationTypesPage ip = new IdentificationTypesPage(driver);		
		//boolean id = ip.isIdTypeExists("SSN Card");
		if(ip.isIdTypeExists("SSN Card")==true)
		{
			System.out.println("No such setting exist.");
		}
	}

	@Test (priority=8)
	public void createIdType()
	{
		IdentificationTypesPage ip = new IdentificationTypesPage(driver);
		ip.clickCreateNewIdType("SSN Card");
	}
	
	@Test (priority=9)
	public void editIdType()
	{
		IdentificationTypesPage ip = new IdentificationTypesPage(driver);
		performAction("SSN Card", edit);
		ip.clickEditIdType("SSN Card_2");
		System.out.println("Setting Key edited");
	}
	
	@Test (priority=10)
	public void seeDetailsOfIdType()
	{
		IdentificationTypesPage ip = new IdentificationTypesPage(driver);
		performAction("SSN Card_2", details);
		if(ip.isDetailsPresent()==true)
		{
			System.out.println("ID Type Details are visible");
		}
	}
	
	@Test (priority=11)
	public void deletSetting()
	{
		IdentificationTypesPage ip = new IdentificationTypesPage(driver);
		performAction("SSN Card_2", delete);
		ip.clickDelete();
		System.out.println("ID Type Key deleted");
	}
}
