package BambooSparkPages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Helpers.Helpers;
import Helpers.IOSElementsInDifferentLanguages;
import Helpers.Reader;
import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BambooSparkNotePreviewPage {

	@iOSFindBy(xpath="//*[@name='Edit']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_overflow")
	private static MobileElement ThreeDotMenuButtonOrEditButton;
	
	

	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='libraryEditViewDelete']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_delete")
	private static MobileElement DeleteButton; 
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")
	@AndroidFindBy(id="com.wacom.mate:id/btn_no")
	private static MobileElement DeleteNoteConfirmationWindowCancellOption;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIAButton[1]")
	@AndroidFindBy(id="notForUse")
	private static MobileElement DeleteNoteConfirmationWindowCancellOptionIOSPHONE;
	
	@iOSFindBy(xpath="//UIACollectionView/UIACollectionCell/UIAButton[@name='Draw']")
	@AndroidFindBy(id="com.wacom.mate:id/preview_overflow_menu_draw")
	private static MobileElement DrawOption; 
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Draw']")
	@AndroidFindBy(id="com.wacom.mate:id/preview_overflow_menu_draw")
	private static MobileElement DrawOptionIOSTablet; 
	
	@iOSFindBy(xpath="//UIACollectionView/UIACollectionCell/UIAButton[@name='Split']")
	@AndroidFindBy(id="com.wacom.mate:id/preview_overflow_menu_split")
	private static MobileElement SplitOption; 
	
	@iOSFindBy(xpath="//UIAWindow/UIAButton[@name='Split']")
	@AndroidFindBy(id="com.wacom.mate:id/preview_overflow_menu_split")
	private static MobileElement SplitOptionIOSTablet; 
	
	@iOSFindBy(id="libraryEditViewShare")
	@AndroidFindBy(id="com.wacom.mate:id/btn_share")
	private static MobileElement ExportButton; 
	
	@iOSFindBy(id="Export as JPG")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_image")
	private static MobileElement ExportAsJPGOption; 
	
	@iOSFindBy(id="Export as PNG")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_png")
	private static MobileElement ExportAsPNGOption; 
	
	@iOSFindBy(id="Export as PDF")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_pdf")
	private static MobileElement ExportAsPDFOption; 
	
	@iOSFindBy(id="Export as WILL")
	@AndroidFindBy(id="com.wacom.mate:id/library_overflow_menu_export_as_ink_file")
	private static MobileElement ExportAsWILLOption; 
	
	
	
	@iOSFindBy(id="Library")
	@AndroidFindBy(id="com.wacom.mate:id/btn_back")
	private static MobileElement BackToHomePageButton; 
	
	

	@iOSFindBy(xpath="//UIACollectionView/UIACollectionCell[@name='Delete']/UIAButton[@name='Delete']")
	@AndroidFindBy(id="com.wacom.mate:id/btn_yes")
	private static MobileElement DeleteNoteConfirmationWindowDeleteOption;
	
	
	@iOSFindBy(id="libraryEditViewRotate")
	@AndroidFindBy(id="com.wacom.mate:id/btn_rotate")
	private static MobileElement rotateButton;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	@AndroidFindBy(id="com.wacom.mate:id/intent_chooser_label")
	private static List<MobileElement> getAllExportOptionsText;
	
	@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	@AndroidFindBy(id="com.wacom.mate:id/intent_chooser_icon")
	private static List<MobileElement> getAllExportOptionsIcons;

	@iOSFindBy(id="Cancel")
	@AndroidFindBy(id="missing")
	private static MobileElement exportOptionsCancelButton;
	
	public  void CreateScreenshotOnTheNotePreviewScreenBeforeDraw() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
		
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("BeforeDraw");
	}
	
	public  void CreateScreenshotOnTheNotePreviewScreenAfterDraw() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot( "AfterDraw");
	}
	
	public boolean DrawCancelIsSuccessful()
	{
		if(Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeDraw"), Helpers.getScreenshot("AfterDraw")))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
	public  void ClickOnTheOptionsMenuButton() throws InterruptedException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
			ThreeDotMenuButtonOrEditButton.click();
		}
	}
	
	
	public  void CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolDeleteStrokes() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
		
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("BeforeDeleteStrokesWithLassoTool");
	}
	
	public  void CreateScreenshotOnTheNotePreviewScreenAfterLassoToolDeleteStrokes() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("AfterDeleteStrokesWithLassoTool");
	}
	
	
	
	public  void CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolCopy() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
		
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("BeforeCopyStrokesWithLassoTool");
	}
	
	public  void CreateScreenshotOnTheNotePreviewScreenAfterCopy() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("AfterCopyStrokesWithLassoTool");
	}
	
	
	
	
	public  void CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolCut() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
		
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("BeforeCutStrokesWithLassoTool");
	}
	
	public  void CreateScreenshotOnTheNotePreviewScreenAfterCut() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("AfterCutStrokesWithLassoTool");
	}
	
	
	public boolean verifyStrokesWereCut()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToHomePageButton));
		if(!Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeCutStrokesWithLassoTool"), Helpers.getScreenshot("AfterCutStrokesWithLassoTool")))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean verifyStrokesWereCopied()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToHomePageButton));
		if(!Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeCopyStrokesWithLassoTool"), Helpers.getScreenshot("AfterCopyStrokesWithLassoTool")))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean verifyStrokesWereDeleted()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToHomePageButton));
		if(!Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeDeleteStrokesWithLassoTool"), Helpers.getScreenshot("AfterDeleteStrokesWithLassoTool")))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public  void ClickOnTheDeleteButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteButton));
		DeleteButton.click();
	}
	
	public  void ClickOnTheCancelOptionInTheDeleteNoteWindow()
	{
		if(Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteNoteConfirmationWindowCancellOptionIOSPHONE));
			DeleteNoteConfirmationWindowCancellOptionIOSPHONE.click();
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteNoteConfirmationWindowCancellOption));
			DeleteNoteConfirmationWindowCancellOption.click();
		}
	}
	
	public  void ClickOnTheDeleteOptionInTheDeleteNoteWindow()
	{

			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DeleteNoteConfirmationWindowDeleteOption));
			DeleteNoteConfirmationWindowDeleteOption.click();
	}
	
	
	
	
	public  void ClickOnTheSplitOption()
	{
		if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SplitOptionIOSTablet));
			SplitOptionIOSTablet.click();
			
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(SplitOption));
			SplitOption.click();
		}
		
	}
		
	
	public  void ClickOnTheDrawOption()
	{
		if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
			DrawOptionIOSTablet.click();
		}
		else
		{
				Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOption));
				DrawOption.click();
		}
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
			exportOptionsCancelButton.click();
		}else
		{
			Helpers.TapAction(1, 300);
		}
	}
	
	public  void clickOnTheBackToHomePageButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(BackToHomePageButton));
		BackToHomePageButton.click();
	}
	
	public boolean drawingWasPerformed()
	{
		boolean drawingWasPerformed=true;

		drawingWasPerformed=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeDraw"), Helpers.getScreenshot("AfterDraw"));
		
		
		if(!drawingWasPerformed)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public void createScreenshotBeforeErase() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("BeforeErase");
	}
	
	
	public void createScreenshotAfterErase() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("AfterErase");
	}
	
	public boolean verifyThatDrawingsWereErased()
	{
		boolean erasingWasPerformed=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeErase"), Helpers.getScreenshot("AfterErase"));
		if(!erasingWasPerformed)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public void rotateNote() throws IOException, InterruptedException
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(rotateButton));
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		Thread.sleep(1000);
		String noteOrientationBeforeRotation=Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation"));
		System.out.println(noteOrientationBeforeRotation);
		clickOnTheRotateButton();
		Thread.sleep(2000);
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		Assert.assertNotEquals(noteOrientationBeforeRotation, Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation")));
		if(!Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation")).equals("Portrait"))
		{
			clickOnTheRotateButton();
		}
 	}

	public void clickOnTheRotateButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(rotateButton));
		rotateButton.click();
	}
	
	public  void clickOnTheExportAsJPGOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsJPGOption));
		ExportAsJPGOption.click();
	}
	
	public  void clickOnTheExportAsPNGOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsPNGOption));
		ExportAsPNGOption.click();
	}
	
	public  void clickOnTheExportAsPDFOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsPDFOption));
		ExportAsPDFOption.click();
	}

	public  void clickOnTheExportAsWILLOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsWILLOption));
		ExportAsWILLOption.click();
	}

	public void NotePreviewZoomIn() throws IOException, InterruptedException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
		int scrHeight = Device.Driver.manage().window().getSize().getHeight(); //To get the mobile screen height
		int scrWidth = Device.Driver.manage().window().getSize().getWidth();//To get the mobile screen width
		MultiTouchAction multiTouch = new MultiTouchAction(Device.Driver);
		io.appium.java_client.TouchAction tAction0 = new io.appium.java_client.TouchAction(Device.Driver);
		io.appium.java_client.TouchAction tAction1 = new io.appium.java_client.TouchAction(Device.Driver);
		System.out.println("scrWidth/2,scrHeight/2 ::::::  " + scrWidth/2 +","+ scrHeight/2);
		tAction0.press(scrWidth/4,scrHeight/4).waitAction(1000).moveTo(scrWidth/4,260).release();//press finger center of the screen and then move y axis
		tAction1.press(scrWidth/4,(scrHeight/4)+40).waitAction(1000).moveTo(scrWidth/4,280).release();// press thumb slightly down on the center of the screen and then move y axis
		multiTouch.add(tAction0).add(tAction1);
		multiTouch.perform();
		
		
		Helpers.PressAndHold(Device.Driver.manage().window().getSize().getWidth()/2, Device.Driver.manage().window().getSize().getHeight()/2);
		Device.Driver.zoom(Device.Driver.manage().window().getSize().getWidth()/2, Device.Driver.manage().window().getSize().getHeight()/2);
		
	}
	
	
	
	public void clickOnTheEmailOption()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(getAllExportOptionsIcons.get(0)));
		for (int i = 0; i < getAllExportOptionsText.size(); i++) {
			System.out.println(getAllExportOptionsText.get(i).getText());
			if(getAllExportOptionsText.get(i).getText().equals("Email"))
			{
				getAllExportOptionsIcons.get(i).click();
				break;
			}
		}
	}
	
	public boolean exportOptionsAreDisplayed()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ExportAsJPGOption));
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSTablet"))
		{
			if(ExportAsJPGOption.isDisplayed() && ExportAsPDFOption.isDisplayed() && ExportAsPNGOption.isDisplayed() && ExportAsWILLOption.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}else
		{
			if(ExportAsJPGOption.isDisplayed() && ExportAsPDFOption.isDisplayed()  && ExportAsWILLOption.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
		
	}
	
	public void getCurrentOrientationOfTheNote() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));


		}
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		Helpers.currentNoteOrientation=Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation"));
	}
	
	public boolean verifyTheRotationIsSuccessful() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		if(Helpers.currentNoteOrientation!=Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfIsEqualToTheFirstOne() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));

		}
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		if(Helpers.currentNoteOrientation.equals(Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation"))))
		{
			rotateButton.click();
		}
	}
	
	
	public void checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfItsNotEqualToTheFirstOne() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		if(!Helpers.currentNoteOrientation.equals(Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation"))))
		{
			rotateButton.click();
		}
	}
	
	
	public void checkNoteRotationAndRotateIfItsLandscape() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
		Helpers.CreateScreenshot("CurrentNoteOrientation");
		if(Helpers.CheckOrientation(Helpers.getScreenshot("CurrentNoteOrientation")).equals("Landscape"))
		{
			rotateButton.click();
		}
	}
	
	
	public void createScreenshotBeforeLassoSelectionMove() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
			Helpers.CreateScreenshot("BeforeLassoSelectionMove");
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
			Helpers.CreateScreenshot("BeforeLassoSelectionMove");
		}
	}
	
	public void createScreenshotAfterLassoSelectionMove() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
			Helpers.CreateScreenshot("AfterLassoSelectionMove");
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		Helpers.CreateScreenshot("AfterLassoSelectionMove");
		}
	}
	
	
	public boolean verifyLassoSelectionMoveIsPerformedCorrectly()
	{
		boolean redoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeLassoSelectionMove"), Helpers.getScreenshot("AfterLassoSelectionMove"));
		if(!redoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	public void createScreenshotBeforePaste() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
			Helpers.CreateScreenshot("BeforePaste");
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		Helpers.CreateScreenshot("BeforePaste");
		}
	}
	
	public void createScreenshotAfterPaste() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
			Helpers.CreateScreenshot("AfterPaste");
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		Helpers.CreateScreenshot("AfterPaste");
		}
	}
	
	public boolean verifyPasteIsSuccessful()
	{
		boolean redoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforePaste"), Helpers.getScreenshot("AfterPaste"));
		if(!redoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
	
	public boolean backButtonIsDisplayed()
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
		if(BackToHomePageButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean exportButtonIsDisplayed()
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
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
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
		if(rotateButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean deleteButtonIsDisplayed()
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else
		{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		
		if(DeleteButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean threeDotMenuOrEditButtonIsDisplayed()
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		
		
		if(ThreeDotMenuButtonOrEditButton.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		}
		return true;
	}
	
	public boolean drawButtonIsDisplayed()
	{

		
			
		if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
			if(DrawOptionIOSTablet.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
		else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOption));
			if(DrawOption.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
	}
	
	public boolean splitButtonIsDisplayed()
	{
		if(Device.DriverName.equals("iOSTablet"))
		{
			if(SplitOptionIOSTablet.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
		else
		{
			if(SplitOption.isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
		}
	}
	
	public void zoomIn()
	{
		  int middleX = (Device.Driver.manage().window().getSize().getWidth()) / 2;
		  int middleY = (Device.Driver.manage().window().getSize().getHeight()) / 2;
		  TouchAction action0=new TouchAction(Device.Driver).press(middleX,middleY).release();
		  action0.perform();
		  
		  for (int i = 0; i < 3; i++) 
		  {
			  Device.Driver.zoom(middleX,middleY);
		  }
	}
	
	public  void CreateScreenshotOnTheNotePreviewScreenBeforeZoomIn() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
		
					Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot("BeforeZoomIn");
	}
	
	public  void CreateScreenshotOnTheNotePreviewScreenAfterZoomIn() throws IOException
	{
		if(Device.DriverName.equals("Android") || Device.DriverName.equals("iOSPhone"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(ThreeDotMenuButtonOrEditButton));
		}else if(Device.DriverName.equals("iOSTablet"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(DrawOptionIOSTablet));
		}
		Helpers.CreateScreenshot( "AfterZoomIn");
	}
	
	public boolean verifyZoomInIsSuccessful()
	{
		boolean redoIsPerformedCorrectly=Helpers.CompareTwoImages(Helpers.getScreenshot("BeforeZoomIn"), Helpers.getScreenshot("AfterZoomIn"));
		if(!redoIsPerformedCorrectly)
		{
			return true; 
		}else 
		{
			return false;
		}
	}
	
}
