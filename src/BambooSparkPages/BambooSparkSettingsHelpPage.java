package BambooSparkPages;

import org.junit.Assert;

import TestBaseClass.Device;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class BambooSparkSettingsHelpPage {

	public boolean verifyThatNoErrorIsDisplayed() throws InterruptedException
	{
		Thread.sleep(15000);
		String getPageSource=Device.Driver.getPageSource().toString();
		System.out.println(getPageSource);
		if(!getPageSource.contains("Error"))
		{
			Assert.assertTrue(getPageSource.contains("It’s easy to get started with Bamboo "));
			return true;
		}else
		{
			return false;
		}
	}
	
	public void goBackToBambooSpark()
	{
		if(Device.DriverName.equals("Android"))
		{
			((AndroidDriver)Device.Driver).pressKeyCode(AndroidKeyCode.BACK);
		}
	}
	
}
