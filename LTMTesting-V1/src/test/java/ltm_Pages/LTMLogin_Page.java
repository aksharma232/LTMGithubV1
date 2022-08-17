package ltm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LTMLogin_Page
{
	
	@FindBy(how=How.ID, using= "UserName") 
	WebElement LTMUsername;
	
	@FindBy(how=How.ID, using= "Password") 
	WebElement LTMPassword;
	
	@FindBy(how=How.ID, using= "btnLogin") 
	WebElement LTMLoginButton;
		
	@FindBy(how=How.ID, using= "lblFailureText") 
	WebElement lblFailureText;
	
	@FindBy(how=How.ID, using= "btnalert") 
	WebElement lblFailureText_closebutton;
	
	public void clickOnLoginButton()
		
	{
		LTMLoginButton.click();
	}
	
	public WebElement LTMUsername()
		{
		return LTMUsername;
		}
	
	public WebElement LTMPassword()
	{
			return LTMPassword;
	}

	public WebElement lblFailureText()
	{
			return lblFailureText;
	}

	public WebElement lblFailureText_closebutton()
	{
			return lblFailureText_closebutton;
	}


}

