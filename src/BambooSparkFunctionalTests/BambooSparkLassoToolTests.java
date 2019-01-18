package BambooSparkFunctionalTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Page;
import TestBaseClass.Device;
import TestBaseClass.TestBaseClass;


public class BambooSparkLassoToolTests extends TestBaseClass{
	
	//@Test
	public void verifyLassoToolIsDisplayed() throws InterruptedException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyLassoToolIsVisible());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
	//@Test
	public void lassoToolSelection() throws InterruptedException, IOException
	{		
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().createScreenshotBeforeLassoSelection();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().createScreenshotAfterLassoSelection();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyLassoSelectionWasPerformed());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
	//@Test
	public void verifyLassoToolSelectionOptionsAreDisplayed() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().verifyLassoContextMenuOptionsAreDisplayed();
	}
	
	//@Test
	public void LassoToolDublicateToNewPageOption() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().countAllNotes();
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolDublicateToNewPageOption();
		Page.BambooSparkDrawPage().clickOnTheSaveChangesSaveOption();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		Page.BambooSparkHomePage().countCurrentNotes();
		Assert.assertTrue(Page.BambooSparkHomePage().verifyLassoToolDublicateToNewPageWasSuccessful());
	}
	
	//@Test
	public void LassoToolDeleteStrokesOption() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolDeleteStrokes();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolDeleteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterLassoToolDeleteStrokes();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyStrokesWereDeleted());
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
	//@Test
	public void LasssoToolCopyAndPasteStrokes() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolCopy();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
	//	Page.BambooSparkDrawPage().clickOnTheDrawButton();
		//Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCopyOption();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayed();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterCopy();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyStrokesWereCopied());
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
	@Test
	public void LassoToolCutOption() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolCut();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCutOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterCut();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyStrokesWereCut());
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
	//@Test
	public void LassoToolCutAndPaste() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCutOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeLassoToolCut();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayed();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterCut();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyStrokesWereCut());
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
	
	//@Test
	public void LassoToolSelectAndZoom()
	{
		
	}
	
	
	//@Test
	public void LassoToolSelectAndMove() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotBeforeLassoSelectionMove();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().SelectionMove();	
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotAfterLassoSelectionMove();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyLassoSelectionMoveIsPerformedCorrectly());
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}

	
	
	
	//@Test
	public void LassoToolPasteInDifferentAreas() throws InterruptedException, IOException
	{
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCopyOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotBeforePaste();
		
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayedInTheRightTopCorner();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotAfterPaste();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyPasteIsSuccessful());
		
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayedInTheLeftTopCorner();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotAfterPaste();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyPasteIsSuccessful());
		
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayedInTheLeftBottomCorner();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotAfterPaste();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyPasteIsSuccessful());
		
 		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayedInTheRightBottomCorner();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().createScreenshotAfterPaste();
		Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyPasteIsSuccessful());
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	}
	
}
