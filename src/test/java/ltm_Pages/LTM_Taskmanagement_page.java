package ltm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LTM_Taskmanagement_page
{

	@FindBy(how=How.XPATH, using= "//a[@id='ImageButtonTask']") 
	WebElement Taskmamagemnetbutton;
	
	public WebElement Taskmamagemnetbutton()
	{
		return Taskmamagemnetbutton;
	}
}
