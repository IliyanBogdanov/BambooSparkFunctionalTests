package BambooSparkPages;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Helpers.Helpers;
import io.appium.java_client.TouchAction;

import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkDrawPage {

	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='btn action done']")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_save")
	private  MobileElement DrawOrEraseSaveButton;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='btn lasso']")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_selection")
	private  MobileElement SelectionButton;
	
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='eraseToolIcon']")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_eraser")
	private  MobileElement EraseButton;
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='inkToolIcon']")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_pen")
	private  MobileElement DrawButton;
	
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='btn undo']")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_undo")
	private  MobileElement undoButton;
	
	
	@iOSFindBy(id="Redo")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_redo")
	private  MobileElement redoButton;
	
	@iOSFindBy(id="btn redo")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_redo")
	private  MobileElement redoButtoniOSTablet;
	
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='btn lasso']")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_selection")
	private  MobileElement LassoTool;
	
	//@iOSFindBy(xpath="//UIAWindow/UIAEditingMenu/UIAElement[@name='Copy']")
	@iOSFindBy(id="Copy")
	@AndroidFindBy(id="com.wacom.mate:id/context_menu_item_copy")
	private  MobileElement LassoToolCopyOption;
	
	@iOSFindBy(xpath="//UIAEditingMenu/UIAElement[@name='Duplicate to new page']")
	@AndroidFindBy(id="com.wacom.mate:id/context_menu_item_copy_as_new")
	private  MobileElement LassoToolDublicateToNewPageOption;
	
	@iOSFindBy(accessibility="Cut")
	@AndroidFindBy(id="com.wacom.mate:id/context_menu_item_cut")
	private  MobileElement LassoToolCutOption;
	
	@iOSFindBy(xpath="//UIAEditingMenu/UIAElement[@name='Delete']")
	@AndroidFindBy(id="com.wacom.mate:id/context_menu_item_delete")
	private  MobileElement LassoToolDeleteOption;
	
	@iOSFindBy(xpath="//UIACollectionCell/UIAButton[@name='Save']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_yes")
	private  MobileElement SaveChangesSaveOption;
	
	@iOSFindBy(accessibility="Paste")
	@AndroidFindBy(id="com.wacom.mate:id/context_menu_item_paste")
	private  MobileElement LassoToolPasteOption;
	
	@iOSFindBy(accessibility="Show more items")
	@AndroidFindBy(id="com.wacom.mate:id/context_menu_item_paste")
	private  MobileElement LassoToolContextMenuMoreOptions;
	
	
	@iOSFindBy(id="btn cancel")
	@AndroidFindBy(id="com.wacom.mate:id/edit_note_btn_cancel")
	private  MobileElement CancelOption;
	
	
	@iOSFindBy(id="Exit")
	@AndroidFindBy(id="com.wacom.mate:id/btn_yes")
	private  MobileElement CancelDiscardOption;
	
	public  void ClickOnTheDrawOrEraseSaveButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		DrawOrEraseSaveButton.click();
	}
	
	
	public void DrawingAction() throws InterruptedException
	{

		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		if(Device.DriverName.contains("Android"))
		{
			Helpers.DriverSwipeOperation(Helpers.setAndGetRandomStartXBasedOnTheDeviceWidth(), Helpers.setAndGetRandomStartYBasedOnTheDeviceHeight(), Helpers.setAndGetEndXBasedOnTheDeviceWidth(), Helpers.setAndGetEndYBasedOnTheDeviceHeight(), 1000);
		}else 
		{
			TouchAction tc=new TouchAction(Device.Driver);
			tc.press(Helpers.setAndGetRandomStartXBasedOnTheDeviceWidth(), Helpers.setAndGetRandomStartYBasedOnTheDeviceHeight()).moveTo(Helpers.setAndGetEndXBasedOnTheDeviceWidth(), Helpers.setAndGetEndYBasedOnTheDeviceHeight()).release();
			tc.perform();
		}
			Thread.sleep(2000);
	}
	
	public void longPressOnTheUndoOption() throws InterruptedException
	{
		if(Device.DriverName.equals("iOSTablet"))
		{
			
		}
		else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(undoButton));
			Helpers.LongPressByElement(undoButton);
		}
		//Helpers.LongPressByCoordinates(undoButton.getLocation().getX(), undoButton.getLocation().getY());
	}
	
	public boolean verifyUndoOptionIsEnabled()
	{
		Device.WaitForElement.until(ExpectedConditions.visibilityOf(undoButton));
		if(undoButton.isEnabled())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean verifyRedoOptionIsEnabled() throws InterruptedException
	{
		Thread.sleep(2000);
		if(Device.DriverName.equals("iOSTablet"))
		{
			if(redoButtoniOSTablet.isEnabled())
			{
				return true;
			}else
			{
				return false;
			}
		}else
		{
			if(redoButton.isEnabled())
			{
				return true;
			}else
			{
				return false;
			}
		}
	}
	
	
	public boolean verifyRedoOptionIsNotEnabled()
	{
		if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.visibilityOf(redoButtoniOSTablet));
			System.out.println(redoButtoniOSTablet.isEnabled());
			if(!redoButtoniOSTablet.isEnabled())
			{
				return true;
			}else
			{
				return false;
			}
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.visibilityOf(redoButton));
			System.out.println(redoButton.isEnabled());
			if(!redoButton.isEnabled())
			{
				return true;
			}else
			{
				return false;
			}
		}
		
		
	}
	
	
	public void DrawingActionForLassoTool() throws InterruptedException
	{
		TouchAction tc=new TouchAction(Device.Driver);
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));	
		if(Device.DriverName.contains("Android"))
		{
			tc.press(200,400).moveTo(220,400).release().perform();
			//Helpers.DriverSwipeOperation(270,300,270,600,1000);
		}else
		{
			tc.press(100,122).moveTo(120,122).release();
			tc.perform();
		}
	}
	
	public void LassoToolSelection() throws InterruptedException
	{
		Thread.sleep(2000);
		TouchAction tc=new TouchAction(Device.Driver);
		if(Device.DriverName.equals("Android"))
		{
			tc.press(222, 400).moveTo(1,500).moveTo(455, 655).release();
			
			//tc.press(100, 250).moveTo(300,250).moveTo(35, 355).release();
			tc.perform();
			Thread.sleep(2000);
		}else
		{
			tc.press(110,122).moveTo(140,122).moveTo(35,150).release();
			tc.perform();
		}
	}
	
	public void openContextMenu() throws IOException, InterruptedException
	{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.PressAndHold(300, 650);
			//Helpers.PressAndHold(270, 500);
		}else
		{
			Helpers.PressAndHold(140,152);
		}
		//Helpers.PressAndHold(184, 219);
	//	Thread.sleep(2000);
	//	Runtime.getRuntime().exec("/Users/nenko/Documents/android-sdk-macosx/adb shell input touchscreen swipe 184 219 184 219 3000");
	//	Thread.sleep(2000);
		
	}
	
	public void SelectionMove() throws InterruptedException, IOException
	{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.DriverSwipeOperation(290, 700, 520, 700, 800);	
		}else
		{
			Helpers.pressAndMove(140, 152, 150, 152);
		}
	}
	
	
	
	
	
	public void ClickOnTheSelectionButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SelectionButton));
		SelectionButton.click();
	}
	
	public void MakeASelection() throws InterruptedException, IOException
	{
	//	Helpers.DriverSwipeOperation(320, 1050, 700, 1450, 1000);
		Helpers.DragAndDrop();
		Thread.sleep(2000);
	}

	public void LongPressOnTheSelection() throws InterruptedException, IOException
	{


		Helpers.LongPressByCoordinates(475, 1226);
		Thread.sleep(1000);
	}
	
	public void ClickOnTheEraseButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(EraseButton));
		EraseButton.click();
	}
	
	public void EraseAction() throws InterruptedException
	{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.DriverSwipeOperation(Helpers.drawingStartX, Helpers.drawingStartY, Helpers.drawingEndX, Helpers.drawingEndY, 2000);
		}else
		{
			TouchAction tc=new TouchAction(Device.Driver);
			tc.press(Helpers.drawingStartX, Helpers.drawingStartY).moveTo(Helpers.drawingEndX, Helpers.drawingEndY).release();
			tc.perform();
		}
		Thread.sleep(2000);
	}
	
	public void createScreenshotBeforeUndo() throws IOException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		Helpers.CreateScreenshot("BeforeUndo");
	}
	
	public void createScreenshotBeforeLassoSelection() throws IOException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		Helpers.CreateScreenshot("BeforeLassoSelection");
	}
	
	public void createScreenshotAfterLassoSelection() throws IOException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		Helpers.CreateScreenshot("AfterLassoSelection");
	}
	
	

	
	
	
	
	public void clickOnTheUndoButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(undoButton));
		undoButton.click();
	}
	
	public void clickOnTheRedoButton() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(redoButton));
		Thread.sleep(1000);
		redoButton.click();
	}
	
	public void createScreenshotAfterUndo() throws IOException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		Helpers.CreateScreenshot("AfterUndo");
	}

	
	
	public boolean verifyUndoIsPerformedCorrectly()
	{
		boolean redoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndo"), Helpers.getScreenshot("AfterUndo"));
		if(!redoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyUndoLassoToolMove()
	{
		boolean undoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndo"), Helpers.getScreenshot("AfterUndo"));
		if(undoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyUndoLassoToolCopy()
	{
		boolean undoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndo"), Helpers.getScreenshot("AfterUndo"));
		if(undoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyUndoLassoToolCut()
	{
		boolean undoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndo"), Helpers.getScreenshot("AfterUndo"));
		if(undoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyUndoLassoToolDelete()
	{
		boolean undoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndo"), Helpers.getScreenshot("AfterUndo"));
		if(undoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	
	public boolean verifyUndoLassoToolCutAndPaste()
	{
		boolean undoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndo"), Helpers.getScreenshot("AfterUndo"));
		if(undoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	
	public boolean verifyLassoSelectionWasPerformed()
	{
		boolean redoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeLassoSelection"), Helpers.getScreenshot("AfterLassoSelection"));
		if(!redoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public boolean verifyLassoToolIsVisible()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		if(LassoTool.isDisplayed())
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public void clickOnTheLassoTool()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoTool));
		LassoTool.click();
	}
	
	public boolean verifyLassoContextMenuOptionsAreDisplayed() throws InterruptedException
	{
		Thread.sleep(3000);
		
		
		if(LassoToolCopyOption.isDisplayed() && LassoToolCutOption.isDisplayed() && LassoToolDeleteOption.isDisplayed() && LassoToolDublicateToNewPageOption.isDisplayed())
		{
			return true;
		}else if(LassoToolCopyOption.isDisplayed() && LassoToolDublicateToNewPageOption.isDisplayed() && !LassoToolCutOption.isDisplayed() && !LassoToolDeleteOption.isDisplayed())
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolContextMenuMoreOptions));
			LassoToolContextMenuMoreOptions.click();
			Thread.sleep(1000);
			if(LassoToolCutOption.isDisplayed() && LassoToolDeleteOption.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
		
		else
		{
			return false;
		}
	}
	
	public void clickOnTheLassoToolDublicateToNewPageOption() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.visibilityOf(LassoToolDublicateToNewPageOption));
		Thread.sleep(1000);
		LassoToolDublicateToNewPageOption.click();
	}
	
	public void clickOnTheSaveChangesSaveOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SaveChangesSaveOption));
		SaveChangesSaveOption.click();
	}
	
	public void clickOnTheLassoToolDeleteOption() throws InterruptedException
	{
		Thread.sleep(1000);
		if(!LassoToolDeleteOption.isDisplayed())
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolContextMenuMoreOptions));
			LassoToolContextMenuMoreOptions.click();
		}
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolDeleteOption));
		Thread.sleep(1000);
		LassoToolDeleteOption.click();
	}

	public void clickOnTheLassoToolCopyOption() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolCopyOption));
		Thread.sleep(1000);
		LassoToolCopyOption.click();
	}
	

	public void clickOnTheLassoToolCutOption() throws InterruptedException
	{
		Thread.sleep(2000);
		if(!LassoToolCutOption.isDisplayed())
		{
			//Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolContextMenuMoreOptions));
			LassoToolContextMenuMoreOptions.click();
		}
		//Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolCutOption));
		Thread.sleep(1000);
		LassoToolCutOption.click();
	}
	
	
	public void pressAndHoldForPasteOptionToBeDisplayedInTheRightBottomCorner() throws IOException, InterruptedException{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.getDeviceHeight=Device.Driver.manage().window().getSize().getHeight()-50;
			Helpers.getDeviceWidth=Device.Driver.manage().window().getSize().getWidth()-40;
		}else
		{
			Helpers.getDeviceHeight=Device.Driver.manage().window().getSize().getHeight()-50;
			Helpers.getDeviceWidth=Device.Driver.manage().window().getSize().getWidth()-70;
		}
		Helpers.PressAndHold(Helpers.getDeviceWidth, Helpers.getDeviceHeight);
	}
	
	
	public void pressAndHoldForPasteOptionToBeDisplayedInTheLeftBottomCorner() throws IOException, InterruptedException{
		
	
		if(Device.DriverName.equals("Android"))
		{
			Helpers.getDeviceWidth=40;
			Helpers.getDeviceHeight=Device.Driver.manage().window().getSize().getHeight()-40;
		}
		else
		{
			Helpers.getDeviceWidth=70;
			Helpers.getDeviceHeight=Device.Driver.manage().window().getSize().getHeight()-50;
		}
		
		Helpers.PressAndHold(Helpers.getDeviceWidth, Helpers.getDeviceHeight);
	}
	
	public void pressAndHoldForPasteOptionToBeDisplayedInTheLeftTopCorner() throws IOException, InterruptedException{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.getDeviceWidth=40;
			Helpers.getDeviceHeight=300;
		}else
		{
			Helpers.getDeviceWidth=70;
			Helpers.getDeviceHeight=100;
		}
		Helpers.PressAndHold(Helpers.getDeviceWidth, Helpers.getDeviceHeight);
	}
	
	
	public void pressAndHoldForPasteOptionToBeDisplayedInTheRightTopCorner() throws IOException, InterruptedException{
		
		if(Device.DriverName.equals("Android"))
		{
			 Helpers.getDeviceWidth=Device.Driver.manage().window().getSize().getWidth()-40;
			 Helpers.getDeviceHeight=300;
		}else
		{
			Helpers.getDeviceWidth=Device.Driver.manage().window().getSize().getWidth()-70;
			Helpers.getDeviceHeight=100;
		}
		
		
		Helpers.PressAndHold(Helpers.getDeviceWidth, Helpers.getDeviceHeight);
	}
	
	
	public void pressAndHoldForPasteOptionToBeDisplayed() throws IOException, InterruptedException
	{
		int getDeviceHeight=Device.Driver.manage().window().getSize().getHeight()/2;
		int getDeviceWidth=Device.Driver.manage().window().getSize().getWidth()/2;
		
		Helpers.PressAndHold(getDeviceWidth, getDeviceHeight);
	}
	
	public void clickOnTheLassoToolPasteOption() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(LassoToolPasteOption));
		Thread.sleep(1000);
		LassoToolPasteOption.click();
	}
	
	public void clickOnTheCancelOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CancelOption));
		CancelOption.click();
	}
	
	public void clickOnTheCancelDiscardOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CancelDiscardOption));
		CancelDiscardOption.click();
	}
	
	public boolean drawToolIsSelected()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CancelOption));
		
	if(Device.DriverName.equals("Android"))
	{
		if(DrawButton.getAttribute("selected").equals("true"))
		{
			return true;
		}else
		{
			return false;
		}
	}else
	{
		if(DrawButton.getAttribute("value").equals("1"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	}
	
	public void clickOnTheDrawButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawButton));
		DrawButton.click();
	}
	
	public boolean eraseToolIsSelected()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CancelOption));
		if(Device.DriverName.equals("Android"))
		{
		if(EraseButton.getAttribute("selected").equals("true"))
		{
			return true;
		}else
		{
			return false;
		}
			}	else
			{
				if(EraseButton.getAttribute("value").equals("1"))
			{
				return true;
			}else
			{
				return false;
			}
		}
		
	}
	
	public boolean selectionToolIsSelected()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(CancelOption));
		if(Device.DriverName.equals("Android"))
		{
		if(SelectionButton.getAttribute("selected").equals("true"))
		{
			return true;
		}else
		{
			return false;
		}
		}else
		{
			if(SelectionButton.getAttribute("value").equals("1"))
		{
			return true;
		}else
		{
			return false;
		}
	}	
	}
	
	public  void closeRedoOption()
	{
		if(Device.DriverName.equals("Android"))
		{
			Helpers.TapAction(1, 900);
		}else if(Device.DriverName.equals("iOSPhone"))
		{
			Helpers.TapAction(1, 300);
		}
	}
	
	public void add19Strokes() throws InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		for (int i = 0; i < 19; i++) {
			DrawingAction();
			
		}		
		Assert.assertTrue(undoButton.isEnabled());
	}
	
	public void undo19Strokes()
	{
		for (int i = 0; i < 19; i++) {
			undoButton.click();
		}
	}
	
	public void redo19Strokes() throws InterruptedException
	{
		longPressOnTheUndoOption();
		for (int i = 0; i < 19; i++) {
			redoButton.click();
		}
	}
	
	public void zoomIn() throws IOException, InterruptedException
	{
		if(Device.DriverName.equals("Android"))
		{
			  Runtime.getRuntime().exec("/Users/nenko/Documents/android-sdk-macosx/adb shell sh /sdcard/sendevent_input.sh");
				Thread.sleep(20000);
		}else
		{
		  int middleX = (Device.Driver.manage().window().getSize().getWidth()) / 2;
		  int middleY = (Device.Driver.manage().window().getSize().getHeight()) / 2;
		  TouchAction action0=new TouchAction(Device.Driver).press(middleX,middleY).release();
		  action0.perform();
		  
		  for (int i = 0; i < 50; i++) 
		  {
			  Device.Driver.zoom(middleX,middleY);
		  }
		}
	}
	
	public  void CreateScreenshotBeforeUndoOrRedoZoomIn() throws IOException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		Helpers.CreateScreenshot("BeforeUndoOrRedoZoomIn");
	}
	
	public  void CreateScreenshotAfterUndoOrRedoZoomIn() throws IOException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOrEraseSaveButton));
		Helpers.CreateScreenshot( "AfterUndoOrRedoZoomIn");
	}
	
	public boolean verifyUndoOrRedoInZoomInIsSuccessful()
	{
		boolean undoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeUndoOrRedoZoomIn"), Helpers.getScreenshot("AfterUndoOrRedoZoomIn"));
		if(undoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	
}
