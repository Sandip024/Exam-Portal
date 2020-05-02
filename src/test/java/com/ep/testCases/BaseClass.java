package com.ep.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ep.pageObjects.LoginPage;
import com.ep.utilities.ReadConfig;


public class BaseClass
{
	ReadConfig readconfig = new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username =readconfig.getUsername();
	public String password =readconfig.getPassword();
	public int delete =readconfig.delete();
	public int edit =readconfig.edit();
	public int details =readconfig.details();

	public static WebDriver driver;
	//public static Logger logger;

	@Parameters ("browser")
	@BeforeClass
	public void setup(String Br) throws InterruptedException
	{
		//	PropertyConfigurator.configure("log4j.properties");
		//	logger = org.apache.log4j.Logger.getLogger("DM_Maven");

		if(Br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(Br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		driver.get(baseURL);
		login(username, password);
	}

	@AfterClass
	public void tearDown() throws InterruptedException
	{
		//logout();
		//driver.quit();
	}

	//  *********************************************************************************************************************************************
	//  *******************************Following Are Utility Methods*********************************************************************************
	//	*********************************************************************************************************************************************

	//  *********************(1).Login Method *******************************************************************************************************
	public void login(String uname,String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		//lp.clickLoginLink();
		lp.setUserName(uname);
		lp.setPassword(pwd);
		lp.clickLogin();
	}


	//	**********************(2).Logout Method *****************************************************************************************************
	//	public void logout() throws InterruptedException
	//	{
	//		LoginPage lp = new LoginPage(driver);
	//		lp.clickLogout();
	//	}


	//  *********************(3).Screenshot Method **************************************************************************************************
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname+"_"+ timeStamp+ ".png" );
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}


	//  ******************(4).Drop-down Selection Method ************************
	public static void selectDropDownValue(String xpathExpression, String value)
	{
		List<WebElement> dropdownlist = driver.findElements(By.xpath(xpathExpression));
		//System.out.println("Total available drop-down options are: "+dropdownlist.size());

		for ( int i=0; i<dropdownlist.size(); i++)
		{
			//System.out.println((i+1)+"."+dropdownlist.get(i).getText());
			if(dropdownlist.get(i).getText().equals(value))
			{
				dropdownlist.get(i).click();
				break;
			}
		}
	}
	
	

	//  ******************(4).Action's Generic Method ************************

	public static void performAction(String settingkey, int action)
	{
		List <WebElement> row = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr"));
		int rowCount = row.size();
		
		List <WebElement> cell = driver.findElements(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[1]/td"));
		int cellCount = cell.size();
		//System.out.println("Number of cells are: "+cellCount);
		
		for(int i=1;i<=rowCount;i++)
		{
			String setting_key = driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr["+i+"]/td[1]")).getText();
			if(setting_key.equalsIgnoreCase(settingkey))

			{
				//System.out.println("Deleting Setting Key: "+settingkey);
				driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr["+i+"]/td["+cellCount+"]/a["+action+"]")).click();
				System.out.println("****************");
				break;
			}
		}
	}
}
