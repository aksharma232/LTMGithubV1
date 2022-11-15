package ltm_Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LTM_Movetoelement 
{

	public void movetoelement(WebElement e, WebDriver d)
	{
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(true);", e);
		
	}
}
