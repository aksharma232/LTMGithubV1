package ltm_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LTM_SelectMethod 
{
	
	public void LTMSelectMethod(WebElement S, String ConnectionType)
	{
		
	
		Select S1 = new Select(S);
		S1.selectByVisibleText(ConnectionType);
		
	}
}
