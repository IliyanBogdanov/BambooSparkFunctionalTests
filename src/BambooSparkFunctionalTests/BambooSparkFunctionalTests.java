package BambooSparkFunctionalTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import org.testng.Assert;
import org.testng.annotations.Test;

import Helpers.Helpers;
import Pages.Page;
import TestBaseClass.Device;
import TestBaseClass.TestBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

public class BambooSparkFunctionalTests extends TestBaseClass {
	

	
 // @Test
  public void assertThatThereIsANoteOnTheHomePage() {
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyThereIsANoteOnTheHomePage());
  }
  
  //@Test
  public void verifySelectAndSettingsOptionsAreVisibleOnTheHomePage() throws Exception
  {
	  //for Android
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  //--------------------
	  
	  Assert.assertTrue(Page.BambooSparkHomePage().SelectOptionIsVisible());
	  Assert.assertTrue(Page.BambooSparkHomePage().SettingsOptionIsVisible());
	  
	  //for Android
	  Page.BambooSparkHomePage().CloseTheMenuOptions();
	  //--------------------
  }
  
 // @Test
  public void drawingAndErasing() throws InterruptedException, IOException
  {
	
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeDraw();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterDraw();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().drawingWasPerformed());
	  Page.BambooSparkNotePreviewPage().createScreenshotBeforeErase();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().ClickOnTheEraseButton();
	  Page.BambooSparkDrawPage().EraseAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().createScreenshotAfterErase();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyThatDrawingsWereErased());
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void undo() throws IOException, InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().createScreenshotBeforeUndo();
	  Page.BambooSparkDrawPage().clickOnTheUndoButton();
	  Page.BambooSparkDrawPage().createScreenshotAfterUndo();
	  Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoIsPerformedCorrectly());
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  //@Test
  public void verifyRedoOptionIsActive() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().clickOnTheUndoButton();
	  Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	  Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsEnabled());
  }
  
  
  //@Test
  public void verifyRedoOptionIsNotActive() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	  Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsNotEnabled());
  }
  

  //@Test
  public void split() throws IOException, InterruptedException
  {  
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheSplitOption();
	  Page.BambooSparkSplitPage().splitNote();
	  Page.BambooSparkSplitPage().ClickOnTheAcceptSplitButton();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyNoteSplitWasSuccessful());
  }
  
 // @Test
  public void cancelSplit() throws InterruptedException, IOException
  {	
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheSplitOption();
	  Page.BambooSparkSplitPage().splitNote();
	  Page.BambooSparkSplitPage().ClickOnTheCancelSplitButton();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyNoteCancelSplitWasSuccessful());
  }
  
  
  //@Test
  public void deleteNote()
  {
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDeleteButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDeleteOptionInTheDeleteNoteWindow();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyNoteDeletionWasSuccessful());
  }
  
  //@Test
  public void noteRotation() throws IOException, InterruptedException
  {

	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().rotateNote();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  //@Test
  public void verifyExportOptionsAreVisible()
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheExportButton();
	  Assert.assertTrue( Page.BambooSparkNotePreviewPage().exportOptionsAreDisplayed());
	  Page.BambooSparkNotePreviewPage().CloseExportOptions();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  //@Test
  public void mergeTwoNotes() throws InterruptedException
  {
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().mergeTheFirstTwoNotes();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyMergeWasSuccessful());
  }
  
  //@Test
  public void mergeCancelOption() throws InterruptedException
  {
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
	  Page.BambooSparkSelectPage().ClickOnTheBackButton();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyMergeCancelWasSuccessful());
  }

  
  //@Test
  public void mergeFirstAndLastNote() throws InterruptedException
  {
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().mergeTheFirstAndTheLastNote();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertFalse(Page.BambooSparkHomePage().verifyMergeWasSuccessful());
  }
  
  //@Test
  public void verifyCombineOptionIsNotAvailableWhenOnlyOneNoteIsSelected() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().clickOnTheFirstNote();
	  Assert.assertFalse(Page.BambooSparkSelectPage().verifyCombineOptionIsNotEnabled());
  }
  

  //@Test
  public void verifyElementsAreDisplayedOnThePreviewPage() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().backButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().exportButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().rotateButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().deleteButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().threeDotMenuOrEditButtonIsDisplayed());
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().drawButtonIsDisplayed());
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().splitButtonIsDisplayed());
  }
  
  //@Test
  public void verifyElementsAreDisplayedOnTheSelectPage()
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
	  Assert.assertTrue(Page.BambooSparkSelectPage().combineCancelButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkSelectPage().exportButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkSelectPage().rotateButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkSelectPage().deleteButtonIsDisplayed());
	  
	  //only for android
	  Assert.assertTrue(Page.BambooSparkSelectPage().threeDotMenuButtonIsDisplayed());
	  //----------------
	  Page.BambooSparkSelectPage().ClickOnTheThreeDotButton();	  
	  Assert.assertTrue(Page.BambooSparkSelectPage().combineButtonIsDisplayed());
  }
  
  //@Test
  public void deleteTwoNotes()
  {
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
	  Page.BambooSparkSelectPage().ClickOnTheDeleteButton();
	  Page.BambooSparkSelectPage().ClickOnTheDeleteDeleteOption();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyDeletionOfMultipleNotesWasSuccessful());
  }
  
  //@Test
  public void rotateNoteInMergePage() throws IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().getCurrentOrientationOfTheNote();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().clickOnTheFirstNote();
	  Page.BambooSparkSelectPage().clickOnTheRotateButton();
	  Page.BambooSparkSelectPage().clickOnTheMergeCancelButton();
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().verifyTheRotationIsSuccessful());
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
 // @Test
  public void assertErrorMessageIsAppearingAfterMergeOnNotesWithDifferentOrientation() throws IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().getCurrentOrientationOfTheNote();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().ClickOnTheSecondNote(); 
	  Page.BambooSparkNotePreviewPage().checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfIsEqualToTheFirstOne();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
	  Page.BambooSparkSelectPage().ClickOnTheThreeDotButton();
	  Page.BambooSparkSelectPage().ClickOnTheCombineOption();
	  Assert.assertTrue(Page.BambooSparkSelectPage().combineErrorIsAppearingOnTheScreen());
	  Page.BambooSparkSelectPage().ClickOnTheCombineNotAllowedWindowsOkButton();
	  Page.BambooSparkSelectPage().clickOnTheMergeCancelButton();
  }
  
  
  //@Test
  public void verifyExportOptionsAreDisplayedInMergeScreen()
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
	  Page.BambooSparkSelectPage().ClickOnTheExportButton();
	  Assert.assertTrue(Page.BambooSparkSelectPage().exportOptionsAreDisplayed());
	  Page.BambooSparkSelectPage().CloseExportOptions();
	  Page.BambooSparkSelectPage().ClickOnTheBackButton();
  }
  
  
  //@Test
  public void verifySettingsOptionsAreDisplayed() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSettingsOption();
	  Assert.assertTrue(Page.BambooSparkSettingsPage().settingsOptionsAreDisplayed());
	  Page.BambooSparkSettingsPage().clickOnTheBackToHomeScreenButton();
  }
  
  //@Test
  public void verifyInkspaceScreen() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSettingsOption();
	  Page.BambooSparkSettingsPage().ClickOnTheInkspaceOption();
	  Assert.assertTrue(Page.BambooSparkSettingsInkspacePage().signUpButtonIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkSettingsInkspacePage().inkspaceTitleTextIsDisplayed());
	  Page.BambooSparkSettingsInkspacePage().clickOnTheSignUpButton();
	  Assert.assertTrue(Page.BambooSparkSettingsInkspacePage().verifyThatNoErrorIsDisplayed());
	  
	  //OnlyForAndroid
	  Page.BambooSparkSettingsInkspacePage().goBackToBambooSpark();
	  Page.BambooSparkSettingsInkspacePage().ClickOnTheCloseInkspaceWindowButton();
	  Page.BambooSparkSettingsPage().clickOnTheBackToHomeScreenButton();
  }
  
//  @Test
  public void verifyHelpScreen() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSettingsOption();
	  Page.BambooSparkSettingsPage().ClickOnTheHelpOption();
	  Assert.assertTrue(Page.BambooSparkSettingsHelpPage().verifyThatNoErrorIsDisplayed());
	  
	  //Only For Android
	  Page.BambooSparkSettingsHelpPage().goBackToBambooSpark();
	  Page.BambooSparkSettingsPage().clickOnTheBackToHomeScreenButton();
  }
  
  //@Test
  public void verifyOtherAppsScreen() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSettingsOption();
	  Page.BambooSparkSettingsPage().ClickOnTheOtherAppsOption();
	  Assert.assertTrue(Page.BambooSparkSettingsOtherAppsPage().verifyBambooPaperTitleIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkSettingsOtherAppsPage().verifyDownloadButtonIsDisplayed());
	  Page.BambooSparkSettingsOtherAppsPage().ClickOnTheDownloadButton();
	  Assert.assertTrue(Page.BambooSparkSettingsOtherAppsPage().verifyThatNoErrorIsDisplayed());
	  
	  //Only for Andoroid
	  Page.BambooSparkSettingsOtherAppsPage().goBackToBambooSpark();
	  Page.BambooSparkSettingsOtherAppsPage().ClickOnTheBackToSettingsButton();
	  Page.BambooSparkSettingsPage().clickOnTheBackToHomeScreenButton();
  }
  
  
  //@Test
  public void verifyAccessoriesPage() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSettingsOption();
	  Page.BambooSparkSettingsPage().ClickOnTheAccessoriesOption();
	  Assert.assertTrue(Page.BambooSparkSettingsAccessories().verifyBambooSmartpadAccessoriesTitleIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkSettingsAccessories().verifyLearnMoreButtonIsDisplayed());
	  Page.BambooSparkSettingsAccessories().ClickOnTheLearnMoreButton();
	  Assert.assertTrue(Page.BambooSparkSettingsAccessories().verifyThatNoErrorIsDisplayed());
	  
	  //Only for Android
	  Page.BambooSparkSettingsAccessories().goBackToBambooSpark();
	  Page.BambooSparkSettingsAccessories().ClickOnTheBackToSettingsButton();
	  Page.BambooSparkSettingsPage().clickOnTheBackToHomeScreenButton();
  }
  
  
  //@Test
  public void verifyAboutPage() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSettingsOption();
	  Page.BambooSparkSettingsPage().ClickOnTheAboutOption();
	  Page.BambooSparkSettingsAboutPage().verifyWacomInkspaceTitleIsDisplayed();
	  Page.BambooSparkSettingsAboutPage().verifyTermOfUseThirdPartyLibrariesAndGoogleAnalyticsLinksAreDisplayed();
	  Page.BambooSparkSettingsAboutPage().ClickOnTheTermsOfUseAndPrivacyPolicy();
	  Page.BambooSparkSettingsAboutPage().verifyTermOfUsePageIsDisplayed();
	  Page.BambooSparkSettingsAboutPage().ClickOnTheTermOfUseBackButton();
	  Page.BambooSparkSettingsAboutPage().ClickOnTheGoogleAnalytics();
	  Page.BambooSparkSettingsAboutPage().verifyGoogleAnalyticsPageIsDisplayed();
	  Page.BambooSparkSettingsAboutPage().ClickOnTheGoogleAnalyticsBackButton();
	  Page.BambooSparkSettingsAboutPage().ClickOnTheThirdPartyLibrariesLink();
	  Page.BambooSparkSettingsAboutPage().verifyThatNoErrorIsDisplayedOnTheThirdPartyLibrariesPage();
	  
	  //Only For Android
	  Page.BambooSparkSettingsAboutPage().goBackToBambooSpark();
	  Page.BambooSparkSettingsAboutPage().ClickOnTheAboutBackButton();
  }
  
  
  //@Test
  public void applicationDefaultView()
  {
	  Assert.assertTrue(Page.BambooSparkHomePage().notesAreDisplayed());
	  Assert.assertTrue(Page.BambooSparkHomePage().threeDotMenuIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkHomePage().cloudOptionIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkHomePage().deviceStateOptionIsDisplayed());
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Assert.assertTrue(Page.BambooSparkHomePage().settingsOptionIsDisplayed());
	  Assert.assertTrue(Page.BambooSparkHomePage().selectOptionIsDisplayed());
  }

  
  //@Test
  public void editModeDesignVerificationDrawDoneAndCancel() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().checkNoteRotationAndRotateIfItsLandscape();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeDraw();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().clickOnTheCancelOption();
	  Page.BambooSparkDrawPage().clickOnTheCancelDiscardOption();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterDraw();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().DrawCancelIsSuccessful());
	  
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterDraw();
	  Assert.assertTrue(Page.BambooSparkNotePreviewPage().drawingWasPerformed());
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void editModeDesignVerificationSplitDoneAndCancel() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheSplitOption();
	  Page.BambooSparkSplitPage().splitNote();
	  Page.BambooSparkSplitPage().ClickOnTheCancelSplitButton();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyNoteCancelSplitWasSuccessful());
	  
	  Page.BambooSparkHomePage().countAllNotes();
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheSplitOption();
	  Page.BambooSparkSplitPage().splitNote();
	  Page.BambooSparkSplitPage().ClickOnTheAcceptSplitButton();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
	  Page.BambooSparkHomePage().countCurrentNotes();
	  Assert.assertTrue(Page.BambooSparkHomePage().verifyNoteSplitWasSuccessful());
  }
  
  //@Test
  public void editModeDesignVerificationDrawToolsSelectedState() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Assert.assertTrue(Page.BambooSparkDrawPage().drawToolIsSelected());
	  Page.BambooSparkDrawPage().ClickOnTheEraseButton();
	  Assert.assertTrue(Page.BambooSparkDrawPage().eraseToolIsSelected());
	  Page.BambooSparkDrawPage().ClickOnTheSelectionButton();
	  Assert.assertTrue(Page.BambooSparkDrawPage().selectionToolIsSelected());
	  Page.BambooSparkDrawPage().clickOnTheCancelOption();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  
  //@Test
  public void previewModeTransitions() throws InterruptedException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().clickOnTheCancelOption();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheSplitOption();
	  Page.BambooSparkSplitPage().ClickOnTheCancelSplitButton();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  //@Test
  public void selectModeTransitions()
  {
	  Page.BambooSparkHomePage().ClickOnTheMenu();
	  Page.BambooSparkHomePage().ClickOnTheSelectOption();
	  Page.BambooSparkSelectPage().ClickOnTheBackButton();
  }
  
  
  
  //@Test
  public void undoRedoButtonBehaviour() throws InterruptedException
  {
	 Page.BambooSparkHomePage().ClickOnTheFirstNote();
	 Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	 Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsNotEnabled());
	 Page.BambooSparkDrawPage().closeRedoOption();
	 
	 Page.BambooSparkDrawPage().DrawingAction();
	 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsNotEnabled());
	 Page.BambooSparkDrawPage().closeRedoOption();
	 
	 Page.BambooSparkDrawPage().clickOnTheUndoButton();
	 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsEnabled());
	 Page.BambooSparkDrawPage().clickOnTheRedoButton();
	 
	 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsNotEnabled());
	 Page.BambooSparkDrawPage().closeRedoOption();
	 
	 Page.BambooSparkDrawPage().clickOnTheUndoButton();
	 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsEnabled());
  }
  
  //@Test
  public void undoRedoInEditMode() throws InterruptedException
  {
	  	 Page.BambooSparkHomePage().ClickOnTheFirstNote();
		 Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		 Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		 Page.BambooSparkDrawPage().DrawingAction();
		 Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoOptionIsEnabled());
		 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
		 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsNotEnabled());
		 Page.BambooSparkDrawPage().closeRedoOption();
		 Page.BambooSparkDrawPage().clickOnTheUndoButton();
		 Page.BambooSparkDrawPage().longPressOnTheUndoOption();
		 Assert.assertTrue(Page.BambooSparkDrawPage().verifyRedoOptionIsEnabled());
		 Page.BambooSparkDrawPage().clickOnTheRedoButton();
		 Page.BambooSparkDrawPage().add19Strokes();
		 Page.BambooSparkDrawPage().undo19Strokes();
		 Page.BambooSparkDrawPage().redo19Strokes();
		 Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		 Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void undoRedoLassoToolMove() throws InterruptedException, IOException
  {
		Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().createScreenshotBeforeUndo();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().SelectionMove();
		Page.BambooSparkDrawPage().clickOnTheUndoButton();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().createScreenshotAfterUndo();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoLassoToolMove());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  //@Test
  public void undoRedoLassoToolCopy() throws IOException, InterruptedException
  {
	  	Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().createScreenshotBeforeUndo();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCopyOption();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayed();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().clickOnTheUndoButton();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().createScreenshotAfterUndo();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoLassoToolCopy());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  //@Test
  public void undoRedoLassoToolCut() throws InterruptedException, IOException
  {
	  	Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().createScreenshotBeforeUndo();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCutOption();
		Page.BambooSparkDrawPage().clickOnTheUndoButton();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().createScreenshotAfterUndo();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoLassoToolCut());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void undoRedoLassoToolCutAndPaste() throws InterruptedException, IOException
  {
	  	Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolCutOption();
		Page.BambooSparkDrawPage().createScreenshotBeforeUndo();
		Page.BambooSparkDrawPage().pressAndHoldForPasteOptionToBeDisplayed();
		Page.BambooSparkDrawPage().clickOnTheLassoToolPasteOption();
		Page.BambooSparkDrawPage().clickOnTheUndoButton();
		Page.BambooSparkDrawPage().createScreenshotAfterUndo();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoLassoToolCutAndPaste());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void undoRedoLassoToolDelete() throws InterruptedException, IOException
  {
	  	Page.BambooSparkHomePage().ClickOnTheFirstNote();
		Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
		Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
		Page.BambooSparkDrawPage().DrawingActionForLassoTool();
		Page.BambooSparkDrawPage().clickOnTheLassoTool();
		Page.BambooSparkDrawPage().LassoToolSelection();
		Page.BambooSparkDrawPage().openContextMenu();
		Page.BambooSparkDrawPage().clickOnTheLassoToolDeleteOption();
		Page.BambooSparkDrawPage().clickOnTheUndoButton();
		Page.BambooSparkDrawPage().clickOnTheDrawButton();
		Page.BambooSparkDrawPage().createScreenshotAfterUndo();
		Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoLassoToolDelete());
		Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
		Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void zoomPageInPreview() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenBeforeZoomIn();
	  Page.BambooSparkNotePreviewPage().zoomIn();
	  Page.BambooSparkNotePreviewPage().CreateScreenshotOnTheNotePreviewScreenAfterZoomIn();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  
  //@Test
  public void undoInZoom() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().CreateScreenshotBeforeUndoOrRedoZoomIn();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().zoomIn();
	  Page.BambooSparkDrawPage().clickOnTheUndoButton();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().CreateScreenshotAfterUndoOrRedoZoomIn();
	  Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoOrRedoInZoomInIsSuccessful());	
	  Page.BambooSparkDrawPage().clickOnTheCancelOption();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
  @Test
  public void redoInZoom() throws InterruptedException, IOException
  {
	  Page.BambooSparkHomePage().ClickOnTheFirstNote();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().DrawingAction();
	  Page.BambooSparkDrawPage().CreateScreenshotBeforeUndoOrRedoZoomIn();
	  Page.BambooSparkDrawPage().clickOnTheUndoButton();
	//  Page.BambooSparkDrawPage().zoomIn();
	  Page.BambooSparkDrawPage().longPressOnTheUndoOption();
	  Page.BambooSparkDrawPage().clickOnTheRedoButton();
	  Page.BambooSparkDrawPage().ClickOnTheDrawOrEraseSaveButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheOptionsMenuButton();
	  Page.BambooSparkNotePreviewPage().ClickOnTheDrawOption();
	  Page.BambooSparkDrawPage().CreateScreenshotAfterUndoOrRedoZoomIn();
	  Assert.assertTrue(Page.BambooSparkDrawPage().verifyUndoOrRedoInZoomInIsSuccessful());	
	  Page.BambooSparkDrawPage().clickOnTheCancelOption();
	  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
  }
  
 // @Test
  public void quickPreviewForLibraryZoomOutMode() throws InterruptedException
  {
	  Page.BambooSparkHomePage().quickPreviewZoomOut();
	  //System.out.println(Device.Driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")).isDisplayed());
	  
	  Thread.sleep(2000);
  }
  
  
}
