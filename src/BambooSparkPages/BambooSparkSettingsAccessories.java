package BambooSparkPages;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Helpers.Helpers;
import Pages.Page;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkSettingsAccessories {
	
	@iOSFindBy(xpath="//UIANavigationBar/UIAButton[@name='Settings']")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private MobileElement BackToSettingsButton;
	
	@iOSFindBy(id="Bamboo smartpad Accessories ")
	@AndroidFindBy(id="com.wacom.mate:id/custom_duplicate_view_txt_title")
	private MobileElement titleText;
	
	@iOSFindBy(id="LEARN MORE")
	@AndroidFindBy(id="com.wacom.mate:id/custom_duplicate_view_button")
	private MobileElement learnMoreButton;
	
	
	public  void ClickOnTheBackToSettingsButton()
	{
		if(Device.DriverName.equals("Android"))
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		BackToSettingsButton.click();
		}
	}
	
	
	public boolean verifyBambooSmartpadAccessoriesTitleIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		
		if(titleText.getText().equals("Bamboo smartpad Accessories "))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verifyLearnMoreButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		
		if(learnMoreButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verifyThatNoErrorIsDisplayed() throws InterruptedException
	{
		Thread.sleep(15000);
		String getPageSource=Device.Driver.getPageSource();
		
		if(!getPageSource.contains("Error") || !getPageSource.contains("Sorry for the inconvenience"))
		{
		//	Assert.assertTrue(getPageSource.contains("Take handwritten notes and ideas further"));
			return true;
		}else
		{
			return false;
		}
	}
	
	public  void ClickOnTheLearnMoreButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(learnMoreButton));
		learnMoreButton.click();
	}
	
	public void goBackToBambooSpark()
	{
		if(Device.DriverName.equals("Android"))
		{
			((AndroidDriver)Device.Driver).pressKeyCode(AndroidKeyCode.BACK);
		}
	}
	

	
	
	

}
