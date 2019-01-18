package BambooSparkPages;

import java.io.IOException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helpers.Helpers;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkSplitPage {
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Cancel']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_close")
	private static MobileElement CancelSplitButton;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Split']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_overflow")
	private static MobileElement AcceptSplitButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]")
	@AndroidFindBy(id="com.wacom.mate:id/split_bar")
	private static MobileElement SplitBar;
	
	
	
	public void ClickOnTheCancelSplitButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CancelSplitButton));
		CancelSplitButton.click();
	}
	
	public void splitNote() throws InterruptedException
	{
	
		Helpers.DriverSwipeOperation(AcceptSplitButton.getLocation().getX(),SplitBar.getLocation().getY(), Helpers.drawingEndX, SplitBar.getLocation().getY(), 2000);
		Thread.sleep(2000);
	}
	
	
	
	public void ClickOnTheAcceptSplitButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(AcceptSplitButton));
		AcceptSplitButton.click();
	}
	
}
