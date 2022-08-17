package ltm_testcases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ltm_Pages.LTM_LHS_Page;
import ltm_Utility.LTM_Screenshot;

public class LTM_Sendmessage extends LTM_Baseclass
{
	LTMLogin ltmlogin;
	LTM_LHS_Page ltmlhs;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		//To Launch Browser
		Launchbrowser();
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}
	
	@Test
	
	public void LTM_Send_Message() throws Exception
	{
		log.info("Send Message testing");
		
		ltmlhs = PageFactory.initElements(d, LTM_LHS_Page.class);
				
		LTM_LHSOptions R1 = new LTM_LHSOptions();
		
		R1.LTM_LHSTC();
		
		Thread.sleep(2000);
		
		R1.TC_Right_Click();
		
		log.info("Right click on TC");
		
		Thread.sleep(1000);
		
		Actions RightClickOperation = new Actions(d);
		
		RightClickOperation.moveToElement(ltmlhs.ClickonRemoteoperation()).perform();
		
		Thread.sleep(5000);
		
		ltmlhs.Sendmessage();
		
		ltmlhs.LTMMessage().sendKeys("Message from LTM");
		
		ltmlhs.Messageapplybutton();
		
		log.info("Message Send on TC");
		
		Thread.sleep(2000);
		
		ltmlhs.Messageclosebtn();
		
		log.info("Clicked on close button");
		
		Thread.sleep(2000);
			
		LTM_Taskmanagement Ob1 = new LTM_Taskmanagement();
		
		Ob1.TaskManagement();
		
		Thread.sleep(5000);
		
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("Sendmessage", d);
	
	}

	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		d.close();

}

}

