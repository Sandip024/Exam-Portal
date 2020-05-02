package com.ep.testCases;

import org.testng.annotations.Test;


import com.ep.pageObjects.TransactionTypesPage;

public class TC_005_TransactionTypesTest extends BaseClass
{
	@Test (priority=12)
	public void openIdTypesPageTest() throws InterruptedException
	{
		TransactionTypesPage ip = new TransactionTypesPage(driver);
		ip.clickApplicationMenu();
		Thread.sleep(2000);
		String xpath = "//ul[@class='navbar-nav mr-auto']//li[1]//div[1]//a";
		selectDropDownValue(xpath,"Transaction Types");
		Thread.sleep(2000);
		
		String xpath1 = "//*[@id='DataTables_Table_0_length']/label/select/option";
		selectDropDownValue(xpath1,"100");
	}
	
	@Test (priority=13)
	public void findIfTransactionTypeExistsTest()
	{
		TransactionTypesPage ip = new TransactionTypesPage(driver);		
		//boolean id = ip.isIdTypeExists("SSN Card");
		if(ip.isTransactionTypeExists("Under_Process")==true)
		{
			System.out.println("No such Transaction Type exist.");
		}
	}

	@Test (priority=14)
	public void createIdType()
	{
		TransactionTypesPage ip = new TransactionTypesPage(driver);
		ip.clickCreateNewTransactionType("Under_Process");
	}
	
	@Test (priority=15)
	public void editIdType()
	{
		TransactionTypesPage ip = new TransactionTypesPage(driver);
		performAction("Under_Process", edit);
		ip.clickEditTransactionType("Held");
		System.out.println("Transaction Type edited");
	}
	
	@Test (priority=16)
	public void seeDetailsOfTransactionType()
	{
		TransactionTypesPage ip = new TransactionTypesPage(driver);
		performAction("Held", details);
		if(ip.isDetailsPresent()==true)
		{
			System.out.println("Transaction Type Details are visible");
		}
	}
	
	@Test (priority=17)
	public void deletSetting()
	{
		TransactionTypesPage ip = new TransactionTypesPage(driver);
		performAction("Held", delete);
		ip.clickDelete();
		System.out.println("Transaction Type deleted");
	}

}
