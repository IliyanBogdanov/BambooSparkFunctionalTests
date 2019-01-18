package Pages;

import org.openqa.selenium.support.PageFactory;

import ExportPages.*;
import BambooSparkPages.*;

import TestBaseClass.Device;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page {

	public static MailPage MailPage()
	{
		MailPage MailPage=new MailPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), MailPage);
		return MailPage;
	}
	
	public static BambooSparkHomePage BambooSparkHomePage()
	{
		BambooSparkHomePage BambooSparkHomePage=new BambooSparkHomePage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkHomePage);
		return BambooSparkHomePage;
	}
	
	public static BambooSparkNotePreviewPage BambooSparkNotePreviewPage()
	{
		BambooSparkNotePreviewPage BambooSparkNotePreviewPage=new BambooSparkNotePreviewPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkNotePreviewPage);
		return BambooSparkNotePreviewPage;
	}
	
	public static BambooSparkSplitPage BambooSparkSplitPage()
	{
		BambooSparkSplitPage BambooSparkSplitPage=new BambooSparkSplitPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSplitPage);
		return BambooSparkSplitPage;
	}
	
	public static BambooSparkDrawPage BambooSparkDrawPage()
	{
		BambooSparkDrawPage BambooSparkDrawPage=new BambooSparkDrawPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkDrawPage);
		return BambooSparkDrawPage;
	}
	
	public static BambooSparkSelectPage BambooSparkSelectPage()
	{
		BambooSparkSelectPage BambooSparkSelectPage=new BambooSparkSelectPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSelectPage);
		return BambooSparkSelectPage;
	}
	
	public static BambooSparkSettingsPage BambooSparkSettingsPage()
	{
		BambooSparkSettingsPage BambooSparkSettingsPage=new BambooSparkSettingsPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsPage);
		return BambooSparkSettingsPage;
	}
	
	
	public static BambooSparkSettingsBambooSmartPadPage BambooSparkSettingsBambooSmartPadPage()
	{
		BambooSparkSettingsBambooSmartPadPage BambooSparkSettingsBambooSmartPadPage=new BambooSparkSettingsBambooSmartPadPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsBambooSmartPadPage);
		return BambooSparkSettingsBambooSmartPadPage;
	}
	
	
	public static BambooSparkSettingsInkspacePage BambooSparkSettingsInkspacePage()
	{
		BambooSparkSettingsInkspacePage BambooSparkSettingsInkspacePage=new BambooSparkSettingsInkspacePage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsInkspacePage);
		return BambooSparkSettingsInkspacePage;
	}
	
	public static BambooSparkSettingsAboutPage BambooSparkSettingsAboutPage()
	{
		BambooSparkSettingsAboutPage BambooSparkSettingsAboutPage=new BambooSparkSettingsAboutPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsAboutPage);
		return BambooSparkSettingsAboutPage;
	}
	
	public static BambooSparkSettingsAccessories BambooSparkSettingsAccessories()
	{
		BambooSparkSettingsAccessories BambooSparkSettingsAccessories=new BambooSparkSettingsAccessories();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsAccessories);
		return BambooSparkSettingsAccessories;
	}
	
	public static BambooSparkSettingsOtherAppsPage BambooSparkSettingsOtherAppsPage()
	{
		BambooSparkSettingsOtherAppsPage BambooSparkSettingsOtherAppsPage=new BambooSparkSettingsOtherAppsPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsOtherAppsPage);
		return BambooSparkSettingsOtherAppsPage;
	}
	
	public static BambooSparkSettingsHelpPage BambooSparkSettingsHelpPage()
	{
		BambooSparkSettingsHelpPage BambooSparkSettingsHelpPage=new BambooSparkSettingsHelpPage();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), BambooSparkSettingsHelpPage);
		return BambooSparkSettingsHelpPage;
	}
	
	public static ExportOptions ExportOptions()
	{
		ExportOptions ExportOptions=new ExportOptions();
		PageFactory.initElements(new AppiumFieldDecorator(Device.Driver), ExportOptions);
		return ExportOptions;
	}
	
}
