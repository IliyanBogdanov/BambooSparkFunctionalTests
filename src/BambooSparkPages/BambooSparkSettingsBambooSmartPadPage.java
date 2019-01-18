package BambooSparkPages;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helpers.Helpers;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkSettingsBambooSmartPadPage {
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")
	@AndroidFindBy(id="com.wacom.mate:id/settings_toolbar_action_image")
	private static MobileElement GoBackToSettingsMenuButton;
	
	
	
	public static void ClickOnTheBackToSettingsButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(GoBackToSettingsMenuButton));
		GoBackToSettingsMenuButton.click();
	}

}
