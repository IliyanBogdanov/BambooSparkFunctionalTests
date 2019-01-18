package BambooSparkPages;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helpers.Helpers;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkSettingsPage {

	@iOSFindBy(id="Bamboo smartpad")
	@AndroidFindBy(id="com.wacom.mate:id/txt_settings_item_discovery")
	private  MobileElement BambooSmartPadOption;
	
	@iOSFindBy(id="Inkspace")
	@AndroidFindBy(id="com.wacom.mate:id/txt_settings_item_wacom_cloud")
	private  MobileElement InkspaceOption;
	
	@iOSFindBy(id="About")
	@AndroidFindBy(id="com.wacom.mate:id/txt_settings_item_about")
	private  MobileElement AboutOption;
	
	@iOSFindBy(id="Accessories")
	@AndroidFindBy(id="com.wacom.mate:id/txt_settings_item_accessories")
	private  MobileElement Accessories;
	
	@iOSFindBy(id="Other Apps")
	@AndroidFindBy(id="com.wacom.mate:id/txt_settings_item_other_apps")
	private  MobileElement OtherApps;
	
	@iOSFindBy(id="Help")
	@AndroidFindBy(id="com.wacom.mate:id/txt_settings_item_help")
	private  MobileElement Help;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Library']")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private  MobileElement backToHomeScreenButton;
	

	
	public  void ClickOnTheBambooSmartIpadOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BambooSmartPadOption));
		BambooSmartPadOption.click();
	}
	
	public  void ClickOnTheInkspaceOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(InkspaceOption));
		InkspaceOption.click();
	}
	
	public  void ClickOnTheAboutOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(AboutOption));
		AboutOption.click();
	}
	
	public  void ClickOnTheAccessoriesOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(Accessories));
		Accessories.click();
	}
	
	public  void ClickOnTheOtherAppsOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(OtherApps));
		OtherApps.click();
	}

	public  void ClickOnTheHelpOption() throws InterruptedException
	{
		Helpers.DriverSwipeOperation(AboutOption.getLocation().getX(), AboutOption.getLocation().getY(), BambooSmartPadOption.getLocation().getX(),  BambooSmartPadOption.getLocation().getY(), 2000);
		Thread.sleep(1000);
		if(Help.isDisplayed())
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(Help));
		Help.click();
		}
	}
	
	public boolean settingsOptionsAreDisplayed() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BambooSmartPadOption));
		//&& Help.isDisplayed()
		if(BambooSmartPadOption.isDisplayed() && AboutOption.isDisplayed() && InkspaceOption.isDisplayed() && Accessories.isDisplayed() && OtherApps.isDisplayed() )
		{
			Helpers.DriverSwipeOperation(AboutOption.getLocation().getX(), AboutOption.getLocation().getY(), BambooSmartPadOption.getLocation().getX(),  BambooSmartPadOption.getLocation().getY(), 2000);
			Thread.sleep(1000);
			if(Help.isDisplayed())
			{
			return true;
			}else
			{
				return false;
			}
		}else
		{
			return false;
		}
	}
	
	public void clickOnTheBackToHomeScreenButton()
	{
		if(Device.DriverName.equals("Android")) 
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(backToHomeScreenButton));
			backToHomeScreenButton.click();
		}
	}
	
}
