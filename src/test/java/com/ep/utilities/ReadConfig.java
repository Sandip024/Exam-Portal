package com.ep.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;

//**** Create a Constructor for ReadConfig **********************
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");  //Source file path
		try 
		{
			FileInputStream fis = new FileInputStream(src);        // Declaring the source file as input file.
			prop = new Properties();							   // Creating an object of properties class.
			prop.load(fis);										   // Loading the source file
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}

//***** Now fetch the data from the source file i.e. config.properties in our case ********
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseURL");         		  // Get base URL.
		return url;
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");   		  // Get Username
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");   		  // Get Password
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromepath");		  // Get Chrome driver
		return chromepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = prop.getProperty("firefoxpath");	  // Get Firefox driver
		return firefoxpath;
	}
	
	public int delete()
	{
		int delete = Integer.parseInt(prop.getProperty("delete"));	         // delete plant
		return delete;
	}
	
	public int edit()
	{
		int edit = Integer.parseInt(prop.getProperty("edit"));	         // delete plant
		return edit;
	}
	
	public int details()
	{
		int details = Integer.parseInt(prop.getProperty("details"));	 // delete plant
		return details;
	}
	
}
