package BambooSparkPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Helpers.Helpers;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkHomePage {

	@iOSFindAll({@iOSFindBy(className="UIACollectionCell")})
	@AndroidFindAll({@AndroidFindBy(id="com.wacom.mate:id/img_file_thumb")})
	private static List<MobileElement> AllNotes;
	
	@iOSFindBy(uiAutomator="ewq")
	@AndroidFindBy(id="com.wacom.mate:id/btn_overflow")
	private static MobileElement ThreeDotMenu;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_select")
	private static MobileElement SelectOption;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_settings")
	private static MobileElement SettingsOption;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[4]")
	@AndroidFindBy(id="com.wacom.mate:id/cloud_image_btn")
	private static MobileElement CloudOption;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")
	@AndroidFindBy(id="com.wacom.mate:id/btn_device_state")
	private static MobileElement DeviceStateOption;

	
	public  void ClickOnTheMenu()
	{
		if(Device.DriverName.equals("Android"))
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		ThreeDotMenu.click();
		}
	}
	

	
	public  void ClickOnTheSelectOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		SelectOption.click();
	}
	
	public  void ClickOnTheSettingsOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SettingsOption));
		SettingsOption.click();
	}
	
	public  void ClickOnTheFirstNote()
	{
		if(Device.DriverName.equals("Android"))
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		}
		
		AllNotes.get(0).click();
	}
	
	public  void ClickOnTheSecondNote()
	{
		if(Device.DriverName.equals("Android"))
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		}
		
		AllNotes.get(1).click();
	}
	
	public boolean verifyThereIsANoteOnTheHomePage()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		}
		
		if(AllNotes.size()>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean SelectOptionIsVisible() throws Exception
	{
		try
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		return true;
		}catch(Exception e)
		{
			throw new Exception("'Select' element is not visible!!!");
		}
		
	}
	
	public boolean SettingsOptionIsVisible() throws Exception
	{
		try
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SettingsOption));
		return true;
		}catch(Exception e)
		{
			throw new Exception("'Settings' element is not visible!!!");
		}
	}
	
	public void CloseTheMenuOptions()
	{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.TapAction(2, 400);
		}
		
	}
	
	public void countAllNotes()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		}
		Helpers.allNotesCount=AllNotes.size();
		System.out.println(Helpers.allNotesCount);
	}
	
	public void countCurrentNotes()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		}
		Helpers.currentNotesCount=AllNotes.size();
		System.out.println(Helpers.currentNotesCount);
		
	}
	
	public boolean verifyNoteSplitWasSuccessful()
	{
		if(Helpers.allNotesCount+1==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyNoteCancelSplitWasSuccessful()
	{
		if(Helpers.allNotesCount==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyNoteDeletionWasSuccessful()
	{
		if(Helpers.allNotesCount-1==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyMergeWasSuccessful()
	{
		if(Helpers.allNotesCount-1==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyMergeCancelWasSuccessful()
	{
		if(Helpers.allNotesCount==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	
	public boolean verifyDeletionOfMultipleNotesWasSuccessful()
	{
		if(Helpers.allNotesCount-2==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	

	public boolean verifyLassoToolDublicateToNewPageWasSuccessful()
	{
		if(Helpers.allNotesCount+1==Helpers.currentNotesCount)
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	
	public boolean notesAreDisplayed()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		}
		
		if(AllNotes.size()>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	//Only For Android
	public boolean threeDotMenuIsDisplayed()
	{
		if(Device.DriverName.equals("Android"))
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
		if(ThreeDotMenu.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		}
		return true;
	}
	
	
	public boolean selectOptionIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
		if(SelectOption.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean settingsOptionIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SettingsOption));
		if(SettingsOption.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	

	public boolean cloudOptionIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CloudOption));
		if(CloudOption.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean deviceStateOptionIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeviceStateOption));
		if(DeviceStateOption.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public void quickPreviewZoomOut() throws InterruptedException
	{	
	
	if(Device.DriverName.equals("Android"))
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenu));
	}else
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectOption));
	}
	
		Helpers.LongPressByElement(AllNotes.get(0));
	}
	
}
