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

public class BambooSparkSettingsAboutPage {

	@iOSFindBy(id="Terms of use and Privacy Policy")
	@AndroidFindBy(id="com.wacom.mate:id/settings_about_txt_terms_of_use")
	private  MobileElement TermOfUseAndPrivacyLink;
	
	@iOSFindBy(id="Google Analytics")
	@AndroidFindBy(id="com.wacom.mate:id/settings_about_txt_google_analytics")
	private  MobileElement GoogleAnalyticsLink;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Settings']")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private  MobileElement BackToSettingsButton;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='About']")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private  MobileElement TermOfUseBackButton;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='About']")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private  MobileElement GoogleAnalyticsBackButton;
	
	@iOSFindBy(id="Wacom Inkspace v1.5")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private  MobileElement titleText;
	
	@iOSFindBy(id="Third Party Libraries")
	@AndroidFindBy(id="com.wacom.mate:id/settings_about_txt_third_party_licenses")
	private  MobileElement thirdPartyLibrariesLink;

	
	@iOSFindBy(id="dsa")
	@AndroidFindBy(id="com.wacom.mate:id/terms_of_use_text")
	private  MobileElement termOfUseText;
	

	
	
	
	
	public  void ClickOnTheTermsOfUseAndPrivacyPolicy()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(TermOfUseAndPrivacyLink));
		TermOfUseAndPrivacyLink.click();
	}
	
	public  void ClickOnTheTermOfUseBackButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(TermOfUseBackButton));
		TermOfUseBackButton.click();
	}
	

	
	public  void ClickOnTheGoogleAnalytics()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(GoogleAnalyticsLink));
		GoogleAnalyticsLink.click();
	}
	

	
	public  void ClickOnTheGoogleAnalyticsBackButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(GoogleAnalyticsBackButton));
		GoogleAnalyticsBackButton.click();
	}
	
	public  void ClickOnTheAboutBackButton()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
			BackToSettingsButton.click();
		}
	}
	
	public  void ClickOnTheThirdPartyLibrariesLink()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(thirdPartyLibrariesLink));
		thirdPartyLibrariesLink.click();
	}
	
	
	public boolean verifyWacomInkspaceTitleIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		if(titleText.getText().contains("Wacom Inkspace"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verifyTermOfUseThirdPartyLibrariesAndGoogleAnalyticsLinksAreDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToSettingsButton));
		if(TermOfUseAndPrivacyLink.isDisplayed() && GoogleAnalyticsLink.isDisplayed() && thirdPartyLibrariesLink.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verifyTermOfUsePageIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(TermOfUseBackButton));
		String getPageSource=Device.Driver.getPageSource();
		
		if(getPageSource.contains("I agree to the Terms of Use and consent"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean verifyGoogleAnalyticsPageIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(GoogleAnalyticsBackButton));
		String getPageSource=Device.Driver.getPageSource();
		
		if(getPageSource.contains("Google Analytics. By clicking the "))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean verifyThatNoErrorIsDisplayedOnTheThirdPartyLibrariesPage() throws InterruptedException
	{
		Thread.sleep(15000);
		String getPageSource=Device.Driver.getPageSource();
		if(!getPageSource.contains("Error")){
			getPageSource.contains("It's easy to get started with Bamboo Spark,");
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
	
	
	  //Assert.assertTrue(Page.BambooSparkSettingsAccessories().verifyBambooSmartpadAccessoriesTitleIsDisplayed());
	//  Assert.assertTrue(Page.BambooSparkSettingsAccessories().verifyLearnMoreButtonIsDisplayed());
	 // Page.BambooSparkSettingsAccessories().ClickOnTheLearnMoreButton();
	  //Assert.assertTrue(Page.BambooSparkSettingsAccessories().verifyThatNoErrorIsDisplayed());
	
	
	
	
}
