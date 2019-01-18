package BambooSparkPages;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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

public class BambooSparkSelectPage {
	
	@iOSFindAll({@iOSFindBy(className="UIACollectionCell")})
	@AndroidFindAll({@AndroidFindBy(id="com.wacom.mate:id/img_file_thumb")})
	private  List<MobileElement> AllNotes;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	@AndroidFindBy(id="com.wacom.mate:id/btn_close")
	private  MobileElement BackButton;
	
	@iOSFindBy(xpath="Dsads")
	@AndroidFindBy(id="com.wacom.mate:id/btn_overflow")
	private  MobileElement ThreeDotMenuButton;
	
	@iOSFindBy(id="libraryEditViewRotate")
	@AndroidFindBy(id="com.wacom.mate:id/btn_rotate")
	private  MobileElement RotateButton;
	
	@iOSFindBy(id="Combine")
	@AndroidFindBy(id="com.wacom.mate:id/library_selection_overflow_menu_merge")
	private  MobileElement ThreeDotMenuCombineOption;
	
	@iOSFindBy(id="OK")
	@AndroidFindBy(id="com.wacom.mate:id/btn_yes")
	private  MobileElement CombineNotAllowedWindowsOkButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[8]")
	@AndroidFindBy(id="com.wacom.mate:id/btn_share")
	private  MobileElement ExportButton;
	
	
	@iOSFindBy(id="Export as JPG")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_image")
	private  MobileElement ExportAsJPGOption;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_png")
	private  MobileElement ExportAsPNGOption;
	
	@iOSFindBy(id="Export as PDF")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_pdf")
	private  MobileElement ExportAsPDFOption;
	
	@iOSFindBy(id="Export as WILL")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_ink_file")
	private  MobileElement ExportAsWILLOption;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[10]")
	@AndroidFindBy(id="com.wacom.mate:id/btn_delete")
	private  MobileElement DeleteButton;

	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")
	@AndroidFindBy(id="com.wacom.mate:id/btn_no")
	private  MobileElement DeleteMultipleNotesOptionCancelOption;
	
	@iOSFindBy(id="Delete")
	@AndroidFindBy(id="com.wacom.mate:id/btn_yes")
	private  MobileElement DeleteMultipleNotesOptionDeleteOption;
	
	@iOSFindBy(id="Cancel")
	@AndroidFindBy(id="com.wacom.mate:id/btn_close")
	private MobileElement MergeCancelOption;

	@iOSFindBy(xpath="//UIACollectionCell/UIAButton[@name='Combine']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_close")
	private MobileElement CombineConfirmationButton;
	
	@iOSFindBy(xpath="//UIAActionSheet/UIAButton[@name='Cancel']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_close")
	private MobileElement exportCancelOption;
	
	public  void SelectMultipleNotes()
	{
		Random rnd=new Random();
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackButton));
		//AllNotes=Device.Driver.findElements(By.id("com.wacom.mate:id/img_file_thumb"));
		System.out.println(AllNotes.size());
		for (int i = 0; i < 4; i++) {
			AllNotes.get(i).click();
			int RandomNumber= rnd.nextInt(4);
			for (int j = 0; j <= RandomNumber; j++) {
				RotateButton.click();
			}
			AllNotes.get(i).click();
		}
		
		for (int i = 0; i < 4; i++) {
			AllNotes.get(i).click();
		}
		
	}
	
	public  void ClickOnTheThreeDotButton()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButton));
			ThreeDotMenuButton.click();
		}
	}
	
	public void ClickOnTheCombineOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuCombineOption));
		ThreeDotMenuCombineOption.click();
	}

	
	public  boolean verifyCombineOptionIsNotEnabled() throws InterruptedException
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButton));
			ThreeDotMenuButton.click();

		}
		Thread.sleep(2000);
		
		if(ThreeDotMenuCombineOption.isEnabled())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	

	
	public  void ClickOnTheCombineNotAllowedWindowsOkButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CombineNotAllowedWindowsOkButton));
		CombineNotAllowedWindowsOkButton.click();
	}
	
	public  void ClickOnTheExportButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportButton));
		ExportButton.click();
	}
	

	
	public  void CloseExportOptions()
	{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.TapAction(1, 900);
		}else if(Device.DriverName.equals("iOSPhone"))
		{
			exportCancelOption.click();
		} else
		{
			Helpers.TapAction(1, 300);
		}
	}
	
	public  void ClickOnTheBackButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackButton));
		BackButton.click();	
	}
	
	public  void ClickOnTheDeleteButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteButton));
		DeleteButton.click();
	}

	public  void ClickOnTheDeleteCancelOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteMultipleNotesOptionCancelOption));
		DeleteMultipleNotesOptionCancelOption.click();
	}
	
	public  void ClickOnTheDeleteDeleteOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteMultipleNotesOptionDeleteOption));
		DeleteMultipleNotesOptionDeleteOption.click();
	}
	
	public void mergeTheFirstTwoNotes() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
		for (int i = 0; i < 4; i++) {
		try
		{
				AllNotes.get(0).click();
				AllNotes.get(1).click();
				ClickOnTheThreeDotButton();
				
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuCombineOption));
				ThreeDotMenuCombineOption.click();
				
				Thread.sleep(2000);
				if(CombineNotAllowedWindowsOkButton.isDisplayed())
				{
				
				CombineNotAllowedWindowsOkButton.click();
				
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
				AllNotes.get(0).click();
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(RotateButton));
				RotateButton.click();
				AllNotes.get(1).click();
				}
				if(!Device.DriverName.equals("Android"))
				{
					
				}
		}catch(Exception e)
		{
		if(!Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CombineConfirmationButton));
			CombineConfirmationButton.click();
		}
			break;
		}
		}	
	}
	
	
	
	
	
	public void mergeTheFirstAndTheLastNote() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
		int getAllNotes=AllNotes.size();
		for (int i = 0; i < 4; i++) {
		try
		{
				AllNotes.get(0).click();
				AllNotes.get(getAllNotes-1).click();
				ClickOnTheThreeDotButton();
				
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuCombineOption));
				ThreeDotMenuCombineOption.click();
				
				Thread.sleep(2000);
				if(CombineNotAllowedWindowsOkButton.isDisplayed())
				{
				
				CombineNotAllowedWindowsOkButton.click();
				
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
				AllNotes.get(0).click();
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(RotateButton));
				RotateButton.click();
				AllNotes.get(getAllNotes-1).click();
				}
				if(!Device.DriverName.equals("Android"))
				{
					
				}
		}catch(Exception e)
		{
		if(!Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CombineConfirmationButton));
			CombineConfirmationButton.click();
		}
			break;
		}
		}	
	}
	

	
	public void selectTheFirstTwoNotes()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
		AllNotes.get(0).click();
		AllNotes.get(1).click();
	}
	
	
	public void clickOnTheFirstNote()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
		AllNotes.get(0).click();
	}
	
	public void clickOnTheRotateButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(RotateButton));
		RotateButton.click();
	}
	
	public void clickOnTheMergeCancelButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(MergeCancelOption));
		MergeCancelOption.click();
	}
	
	public boolean combineErrorIsAppearingOnTheScreen()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CombineNotAllowedWindowsOkButton));
		return CombineNotAllowedWindowsOkButton.isDisplayed();
		
	}
	
	public boolean exportOptionsAreDisplayed()
	{
		
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsJPGOption));
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSTablet"))
		{
			if(ExportAsJPGOption.isDisplayed() && ExportAsPDFOption.isDisplayed() && ExportAsPNGOption.isDisplayed() && ExportAsWILLOption.isDisplayed())
			{
				return true;
			}
			else 
			{
				return false;
			}
		}else
		{
			if(ExportAsJPGOption.isDisplayed() && ExportAsPDFOption.isDisplayed() && ExportAsWILLOption.isDisplayed())
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		
		
	}
	
	public void clickOnTheExportAsJPG()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsJPGOption));
		ExportAsJPGOption.click();
	}
	
	public void clickOnTheExportAsPNG()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsPNGOption));
		ExportAsPNGOption.click();
	}

	public void clickOnTheExportAsPDF()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsPDFOption));
		ExportAsPDFOption.click();
	}
	
	public void clickOnTheExportAsWill()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsWILLOption));
		ExportAsWILLOption.click();
	}
	
	public boolean combineCancelButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackButton));
		
		if(BackButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean exportButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportButton));
		
		if(ExportButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean rotateButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(RotateButton));
		
		if(RotateButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean deleteButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteButton));
		
		if(DeleteButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean threeDotMenuButtonIsDisplayed()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButton));
		
			if(DeleteButton.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean combineButtonIsDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuCombineOption));
		
		if(ThreeDotMenuCombineOption.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
}
