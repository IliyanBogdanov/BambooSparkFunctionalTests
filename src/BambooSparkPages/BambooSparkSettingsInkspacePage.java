package BambooSparkPages;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Helpers.Helpers;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkSettingsInkspacePage {
	
	@iOSFindBy(id="dsa")
	@AndroidFindBy(id="com.wacom.mate:id/library_dialog_close_button")
	private  MobileElement CloseButton;
	
	@iOSFindBy(id="SIGN UP")
	@AndroidFindBy(id="com.wacom.mate:id/btn_inkspace_login")
	private  MobileElement signUpButton;
	
	@iOSFindBy(id="Make your smartpad more powerful")
	@AndroidFindBy(id="com.wacom.mate:id/library_dialog_page_title")
	private  MobileElement titleElement;

	
	public  void ClickOnTheCloseInkspaceWindowButton()
	{		
		if(Device.DriverName.equals("Android"))
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CloseButton));
		CloseButton.click();
	}
	}
	
	public boolean signUpButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(signUpButton));
		
		if(signUpButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	

	
	public boolean inkspaceTitleTextIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(signUpButton));
		
		if(Device.DriverName.equals("Android"))
		{
		if(titleElement.getText().equals("Get your ideas further"))
		{
			return true;
		}else
		{
			return false;
		}
		}
		if(titleElement.getText().equals("Make your smartpad more powerful"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public  void clickOnTheSignUpButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpButton.click();
	}
	
	public boolean verifyThatNoErrorIsDisplayed() throws InterruptedException
	{
		Thread.sleep(14000);
		String getPageSource=Device.Driver.getPageSource().toString();
		System.out.println(getPageSource);
		if(!getPageSource.contains("Error"))
		{
			Assert.assertTrue(getPageSource.contains("The new Wacom ID will also replace the Wacom Cloud account"));
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
