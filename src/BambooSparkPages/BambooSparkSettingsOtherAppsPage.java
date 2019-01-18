package BambooSparkPages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helpers.Helpers;
import Pages.Page;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkSettingsOtherAppsPage {

	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Settings']")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private  MobileElement BackToSettingsButton;
	
	@iOSFindBy(id="Bamboo Paper")
	@AndroidFindBy(id="com.wacom.mate:id/custom_duplicate_view_txt_title")
	private  MobileElement titleText;
	
	@iOSFindBy(id="DOWNLOAD")
	@AndroidFindBy(id="com.wacom.mate:id/custom_duplicate_view_button")
	private  MobileElement downloadButton;
	
	public  void ClickOnTheBackToSettingsButton()
	{
		if(Device.DriverName.equals("Android"))
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		BackToSettingsButton.click();
		}
	}
	
	public boolean verifyBambooPaperTitleIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		if(titleText.getText().equals("Bamboo Paper"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verifyDownloadButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		if(downloadButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public  void ClickOnTheDownloadButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(downloadButton));
		downloadButton.click();
	}

	
	public boolean verifyThatNoErrorIsDisplayed() throws InterruptedException
	{
		Thread.sleep(15000);
		String getPageSource=Device.Driver.getPageSource();
		System.out.println(getPageSource);
		if(!getPageSource.contains("Error"))
		{
			//Assert.assertTrue(getPageSource.contains("An app that turns your mobile device into a paper notebook."));
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
