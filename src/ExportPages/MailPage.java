package ExportPages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBaseClass.Device;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MailPage {

	@iOSFindBy(xpath="//UIANavigationBar/UIAButton[@name='Cancel']")
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Send']")
	private MobileElement cancelSendMailButton;
	
	@iOSFindBy(xpath="//UIANavigationBar/UIAButton[@name='Send']")
	//@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Send']")
	@AndroidFindBy(id="com.google.android.gm:id/send")
	private MobileElement sendMailButton;
	

	@iOSFindBy(xpath="//UIAScrollView/UIATextField[@name='toField']")
	//@AndroidFindBy(xpath="//android.widget.EditText[@content-desc='To: ']")
	@AndroidFindBy(id="com.google.android.gm:id/to")
	private MobileElement sendMailToField;
	
	
	@iOSFindBy(id="subjectField")
	@AndroidFindBy(id="com.google.android.gm:id/subject")
	private MobileElement sendMailSubjectField;
	
	public void typeCorrectToMailAddress()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(sendMailButton));	
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(cancelSendMailButton));
		}
		sendMailToField.sendKeys("nenko.nenkov@wacom.com");
		sendMailToField.click();
	}
	
	public void typeSubject(String subject)
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(sendMailButton));	
			
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(cancelSendMailButton));
		}
		sendMailSubjectField.clear();
		sendMailSubjectField.click();
		sendMailSubjectField.sendKeys(subject);
	}
	
	public void clickOnTheSendButton()
	{
		Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(sendMailButton));
		sendMailButton.click();
	}
	
}
