package ltm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LTM_DateTime_Page 
{
	@FindBy(how=How.ID, using= "LX_DateTime_txtDate") 
	WebElement ManualDate;

	public WebElement ManualDate()
	{
		return ManualDate;
		
	}
}
