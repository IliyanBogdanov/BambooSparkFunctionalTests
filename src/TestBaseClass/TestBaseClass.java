package TestBaseClass;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Helpers.Helpers;
import Pages.Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class TestBaseClass {
	
	

	
	@Parameters({ "DriverName" })
	@BeforeMethod
	public static void StartBambooSpark(@Optional("Test") String DriverName) throws MalformedURLException
	{
		//iOSPhone, Android, iOSTablet
		//Device.DriverName=DriverName;
		Device.DriverName="Android";
		Device.StartBambooSparkApp();
	}

	@AfterMethod
	public static void CloseBambooSpark() throws MalformedURLException
	{
		Device.AppClose();
	}
		
}
