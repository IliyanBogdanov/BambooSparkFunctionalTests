package TestBaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.Helpers;
import Helpers.IOSElementsInDifferentLanguages;
import Helpers.Reader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Device {
	public static AppiumDriver<MobileElement> Driver;
	//iOSPhone, Android, iOSTablet
	public static String DriverName;
	public static WebDriverWait WaitForElement;
	
	
	public static void StartBambooSparkApp() throws MalformedURLException
	{
		//Helpers.Log.info("Application is run on "+DriverName);
		
		if(DriverName.equals("Android"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-T310");
			//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Wacom Sofia QA's G3");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "G3");
			
			cap.setCapability("appPackage","com.wacom.mate");
			cap.setCapability("appActivity", "com.wacom.mate.LibraryActivity");
			
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
			
			//	cap.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "com.wacom.mate.LibraryActivity,com.wacom.mate.IntroductionActivity,com.wacom.mate.LibraryDialogActivity,com.wacom.mate.SparkTestActivity,com.wacom.mate.PairNewSparkActivity,com.wacom.mate.view.PreviewActivity,com.wacom.mate.SplitActivity,com.wacom.mate.SettingsActivity,com.wacom.mate.EditNoteActivity,com.wacom.mate.NotificationActivity,com.google.android.gms.ads.AdActivity,com.google.android.gms.ads.purchase.InAppPurchaseActivity");
			Driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			

			
		}else
		{
			DesiredCapabilities Capabilities =new DesiredCapabilities();
			Capabilities.setCapability("bundleId", "com.wacom.bamboospark" );
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS" );
			//Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Sofia iPad 3");
			//Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "QA' iPad Pro 9.7");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Antoaneta Stoyanova's iPhone");
			
			
			
			Capabilities.setCapability(MobileCapabilityType.UDID, "c35e79493f50a5709ec42d21f6d9d89fbfab32ac" );
			//Capabilities.setCapability(MobileCapabilityType.UDID, "2d2d6a046ef47593f4c0f848640366fb1d6126ce" );
			Capabilities.setCapability("showIOSLog", false );	  
			//Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "MAC" );
			Driver =new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),Capabilities) ;
			
		}
		WaitForElement=new WebDriverWait(Driver, 50);
		
	}
	
	public static void AppClose()
	{
		Driver.quit();
	}
	
	
	
}
