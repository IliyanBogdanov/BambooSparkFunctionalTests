package ExportPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestBaseClass.Device;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ExportOptions {

	@iOSFindBy(xpath="//UIACollectionView/UIACollectionCell[@name='Mail']")
	@AndroidFindBy(id="com.wacom.mate:id/intent_chooser_label")
	private WebElement exportAsMail;
	
	@iOSFindBy(xpath="//UIACollectionView/UIACollectionCell[@name='Mail']")
	@AndroidFindBy(id="com.wacom.mate:id/intent_chooser_label")
	private List<WebElement> exportOptionsLabels;
	
	
	@iOSFindBy(xpath="//UIACollectionView/UIACollectionCell[@name='Mail']")
	@AndroidFindBy(id="com.wacom.mate:id/intent_chooser_icon")
	private List<WebElement> exportOptionsIcons;
	
	public void clickOnTheExportAsMailOption()
	{
		if(Device.DriverName.equals("Android"))
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(exportAsMail));
			for (int i = 0; i < exportOptionsLabels.size(); i++) {
				if(exportOptionsLabels.get(i).getText().equals("Gmail"))
				{
					exportOptionsIcons.get(i).click();
					break;
				}
			}
		}else
		{
			Device.WaitForElement.until(ExpectedConditions.elementToBeClickable(exportAsMail));
			exportAsMail.click();
		}
	}
	
}
