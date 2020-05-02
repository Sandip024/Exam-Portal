package com.ep.testCases;

import org.testng.annotations.Test;

import com.ep.pageObjects.TransactionStatusesPage;

public class TC_006_TransactionsStatusesTest extends BaseClass
{
	@Test (priority=18)
	public void openTransactionStatusesPageTest() throws InterruptedException
	{
		TransactionStatusesPage ip = new TransactionStatusesPage(driver);
		ip.clickApplicationMenu();
		Thread.sleep(2000);
		String xpath = "//ul[@class='navbar-nav mr-auto']//li[1]//div[1]//a";
		selectDropDownValue(xpath,"Transaction Statuses");
		Thread.sleep(2000);
		
		System.out.println("Transaction Statuses page opened.");
		
		String xpath1 = "//*[@id='DataTables_Table_0_length']/label/select/option";
		selectDropDownValue(xpath1,"100");
	}
	
	@Test (priority=19)
	public void findIfTransactionTypeExistsTest()
	{
		TransactionStatusesPage ip = new TransactionStatusesPage(driver);		
		//boolean id = ip.isIdTypeExists("SSN Card");
		if(ip.isTransactionStatusExists("Aborted")==true)
		{
			System.out.println("No such Transaction Status exist.");
		}
	}

	@Test (priority=20)
	public void createIdType()
	{
		TransactionStatusesPage ip = new TransactionStatusesPage(driver);
		ip.clickCreateNew("Aborted");
		
		System.out.println("Transaction Statuse created.");
	}
	
	@Test (priority=21)
	public void editIdType()
	{
		TransactionStatusesPage ip = new TransactionStatusesPage(driver);
		performAction("Aborted", edit);
		ip.clickEdit("Blocked");
		System.out.println("Transaction Status edited");
	}
	
	@Test (priority=22)
	public void seeDetailsOfTransactionType()
	{
		TransactionStatusesPage ip = new TransactionStatusesPage(driver);
		performAction("Blocked", details);
		if(ip.isDetailsPresent()==true)
		{
			System.out.println("Transaction Status Details are visible");
		}
	}
	
	@Test (priority=23)
	public void deletSetting()
	{
		TransactionStatusesPage ip = new TransactionStatusesPage(driver);
		performAction("Blocked", delete);
		ip.clickDelete();
		System.out.println("Transaction Status deleted");
	}

}
