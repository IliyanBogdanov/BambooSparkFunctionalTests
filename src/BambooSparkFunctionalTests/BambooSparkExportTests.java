package BambooSparkFunctionalTests;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.Page;
import TestBaseClass.Device;
import TestBaseClass.TestBaseClass;

public class BambooSparkExportTests extends TestBaseClass{
	
	@Test
	public void exportMultipleFilesAsJPGInSelectModeInSameOrientation() throws IOException
	{
		  Page.BambooSparkHomePage().ClickOnTheFirstNote();
		  Page.BambooSparkNotePreviewPage().getCurrentOrientationOfTheNote();
		  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		  Page.BambooSparkHomePage().ClickOnTheSecondNote(); 
		  Page.BambooSparkNotePreviewPage().checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfItsNotEqualToTheFirstOne();
		  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		  Page.BambooSparkHomePage().ClickOnTheMenu();
		  Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsJPG();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithSameOrientationAsJPG");
		  Page.MailPage().clickOnTheSendButton();
	}
	
	@Test
	public void exportMultipleFilesAsJPGInSelectModeInDifferentOrientation() throws IOException
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
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsJPG();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithDifferentOrientationAsJPG");
		  Page.MailPage().clickOnTheSendButton();
	}
	
	
	//Only for iPad's and Android
	@Test
	public void exportMultipleFilesAsPNGSelectModeInDifferentOrientation() throws IOException
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
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsPNG();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithDifferentOrientationAsPNG");
		  Page.MailPage().clickOnTheSendButton();
	}
	
	//Only for iPad's and Android
	@Test
	public void exportMultipleFilesAsPNGSelectModeInSameOrientation() throws IOException
	{
		  Page.BambooSparkHomePage().ClickOnTheFirstNote();
		  Page.BambooSparkNotePreviewPage().getCurrentOrientationOfTheNote();
		  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		  Page.BambooSparkHomePage().ClickOnTheSecondNote(); 
		  Page.BambooSparkNotePreviewPage().checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfItsNotEqualToTheFirstOne();
		  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		  Page.BambooSparkHomePage().ClickOnTheMenu();
		  Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsPNG();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithSameOrientationAsPNG");
		  Page.MailPage().clickOnTheSendButton();
	}
	
	
		@Test
		public void exportMultipleFilesAsPDFSelectModeInDifferentOrientation() throws IOException
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
			  Page.BambooSparkSelectPage().ClickOnTheExportButton();
			  Page.BambooSparkSelectPage().clickOnTheExportAsPDF();
			  Page.ExportOptions().clickOnTheExportAsMailOption();
			  Page.MailPage().typeCorrectToMailAddress();
			  Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithDifferentOrientationAsPNG");
			  Page.MailPage().clickOnTheSendButton();
		}
		
		//Only for iPad's and Android
		@Test
		public void exportMultipleFilesAsPDFSelectModeInSameOrientation() throws IOException
		{
			  Page.BambooSparkHomePage().ClickOnTheFirstNote();
			  Page.BambooSparkNotePreviewPage().getCurrentOrientationOfTheNote();
			  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
			  Page.BambooSparkHomePage().ClickOnTheSecondNote(); 
			  Page.BambooSparkNotePreviewPage().checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfItsNotEqualToTheFirstOne();
			  Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
			  Page.BambooSparkHomePage().ClickOnTheMenu();
			  Page.BambooSparkHomePage().ClickOnTheSelectOption();
			  Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
			  Page.BambooSparkSelectPage().ClickOnTheExportButton();
			  Page.BambooSparkSelectPage().clickOnTheExportAsPDF();
			  Page.ExportOptions().clickOnTheExportAsMailOption();
			  Page.MailPage().typeCorrectToMailAddress();
			  Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithSameOrientationAsPNG");
			  Page.MailPage().clickOnTheSendButton();
		}
		
		
		@Test
		public void exportMultipleFilesAsWillSelectModeInDifferentOrientation() throws IOException
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
			 Page.BambooSparkSelectPage().ClickOnTheExportButton();
			 Page.BambooSparkSelectPage().clickOnTheExportAsWill();
			 Page.ExportOptions().clickOnTheExportAsMailOption();
			 Page.MailPage().typeCorrectToMailAddress();
			 Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithDifferentOrientationAsPNG");
			 Page.MailPage().clickOnTheSendButton();
		}
				
		//Only for iPad's and Android
		@Test
		public void exportMultipleFilesAsWillSelectModeInSameOrientation() throws IOException
		{
			Page.BambooSparkHomePage().ClickOnTheFirstNote();
		  	Page.BambooSparkNotePreviewPage().getCurrentOrientationOfTheNote();
		  	Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		  	Page.BambooSparkHomePage().ClickOnTheSecondNote(); 
		  	Page.BambooSparkNotePreviewPage().checkOrientationOfTheSecondNoteAndClickOnTheRotateButtonIfItsNotEqualToTheFirstOne();
		  	Page.BambooSparkNotePreviewPage().clickOnTheBackToHomePageButton();
		  	Page.BambooSparkHomePage().ClickOnTheMenu();
		  	Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  	Page.BambooSparkSelectPage().selectTheFirstTwoNotes();
		  	Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  	Page.BambooSparkSelectPage().clickOnTheExportAsWill();
		  	Page.ExportOptions().clickOnTheExportAsMailOption();
		  	Page.MailPage().typeCorrectToMailAddress();
		  	Page.MailPage().typeSubject(Device.DriverName+"_ExportMultipleNotesWithSameOrientationAsPNG");
			Page.MailPage().clickOnTheSendButton();
		}

		@Test
		public void exportFileAsPNGSelectMode()
		{
	 	  Page.BambooSparkHomePage().ClickOnTheMenu();
		  Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  Page.BambooSparkSelectPage().clickOnTheFirstNote();
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsPNG();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsPNGInSelectMode");
		  Page.MailPage().clickOnTheSendButton();
		}
	
		@Test
		public void exportFileAsJPGSelectMode()
		{
	      Page.BambooSparkHomePage().ClickOnTheMenu();
		  Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  Page.BambooSparkSelectPage().clickOnTheFirstNote();
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsJPG();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsJPGInSelectMode");
		  Page.MailPage().clickOnTheSendButton();
		}
	
	
	
	
	
		@Test
		public void exportFileAsPDFSelectMode()
		{
	 	  Page.BambooSparkHomePage().ClickOnTheMenu();
		  Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  Page.BambooSparkSelectPage().clickOnTheFirstNote();
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsPDF();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsPDFInSelectMode");
		  Page.MailPage().clickOnTheSendButton();
		}
	
		@Test
		public void exportFileAsWILLSelectMode()
		{
	      Page.BambooSparkHomePage().ClickOnTheMenu();
		  Page.BambooSparkHomePage().ClickOnTheSelectOption();
		  Page.BambooSparkSelectPage().clickOnTheFirstNote();
		  Page.BambooSparkSelectPage().ClickOnTheExportButton();
		  Page.BambooSparkSelectPage().clickOnTheExportAsWill();
		  Page.ExportOptions().clickOnTheExportAsMailOption();
		  Page.MailPage().typeCorrectToMailAddress();
		  Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsWILLInSelectMode");
		  Page.MailPage().clickOnTheSendButton();
		}
	
	
	
	
		@Test
		public void exportFileAsJPGInPreviewMode()
		{
			Page.BambooSparkHomePage().ClickOnTheFirstNote();
			Page.BambooSparkNotePreviewPage().ClickOnTheExportButton();
			Page.BambooSparkNotePreviewPage().clickOnTheExportAsJPGOption();
			Page.ExportOptions().clickOnTheExportAsMailOption();
			Page.MailPage().typeCorrectToMailAddress();
			Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsJPEGInPreviewMode");
			Page.MailPage().clickOnTheSendButton();
		}
	

		@Test
		public void exportFileAsPNGInPreviewMode()
		{
			Page.BambooSparkHomePage().ClickOnTheFirstNote();
			Page.BambooSparkNotePreviewPage().ClickOnTheExportButton();
			Page.BambooSparkNotePreviewPage().clickOnTheExportAsPNGOption();
			Page.ExportOptions().clickOnTheExportAsMailOption();
			Page.MailPage().typeCorrectToMailAddress();
			Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsPNGInPreviewMode");
			Page.MailPage().clickOnTheSendButton();
		}
	
	
		@Test
		public void exportFileAsPDFInPreviewMode()
		{
			Page.BambooSparkHomePage().ClickOnTheFirstNote();
			Page.BambooSparkNotePreviewPage().ClickOnTheExportButton();
			Page.BambooSparkNotePreviewPage().clickOnTheExportAsPDFOption();
			Page.ExportOptions().clickOnTheExportAsMailOption();
			Page.MailPage().typeCorrectToMailAddress();
			Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsPDFInPreviewMode");
			Page.MailPage().clickOnTheSendButton();
		}
	
		@Test
		public void exportFileAsWILLInPreviewMode()
		{
			Page.BambooSparkHomePage().ClickOnTheFirstNote();
			Page.BambooSparkNotePreviewPage().ClickOnTheExportButton();
			Page.BambooSparkNotePreviewPage().clickOnTheExportAsWILLOption();
			Page.ExportOptions().clickOnTheExportAsMailOption();
			Page.MailPage().typeCorrectToMailAddress();
			Page.MailPage().typeSubject(Device.DriverName+"_ExportNoteAsWILLInPreviewMode");
			Page.MailPage().clickOnTheSendButton();
		}
	
	
	

}
