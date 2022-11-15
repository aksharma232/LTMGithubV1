package ltm_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ltm_Pages.LTM_LHS_Page;
import ltm_Pages.LTM_Taskmanagement_page;
import ltm_Utility.LTM_Screenshot;
import ltm_Utility.SeleniumUtility;

//@Listeners(ltm_Utility.TestngListeners.class)
public class LTM_Sendmessage extends LTM_Baseclass
{
	LTMLogin ltmlogin;
	LTM_LHS_Page ltmlhs;
	LTM_Taskmanagement_page LTMTask;
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		Launchbrowser();
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}
	
	@Test (description = "Send Message from LTM")
	
	public void LTM_Send_Message() throws Exception
	{
		SeleniumUtility selUtility = new SeleniumUtility();
		
		log.info("Send Message testing");
		
		ltmlhs = PageFactory.initElements(d, LTM_LHS_Page.class);
		
		LTMTask = PageFactory.initElements(d, LTM_Taskmanagement_page.class);
				
		LTM_LHSOptions R1 = new LTM_LHSOptions();
		
		R1.LTM_LHSTC();
		
		R1.TC_Right_Click();
		
		log.info("Right click on TC");
			
		Actions RightClickOperation = new Actions(d);
		
		RightClickOperation.moveToElement(ltmlhs.ClickonRemoteoperation()).perform();
		
		selUtility.isDisplayed(ltmlhs.Sendmessage());		
		
		ltmlhs.Sendmessage().click();
		
		ltmlhs.LTMMessage().sendKeys("Message from LTM");
		
		log.info("Message Send on TC");
		
		ltmlhs.Messageapplybutton();
		
		//ltmlhs.Alertcheckbox().click();
		
		//ltmlhs.OKConfirmationPopup().click();
						
		ltmlhs.Messageclosebtn();
		
		log.info("Clicked on close button");
		
		selUtility.isClickable(LTMTask.Taskmamagemnetbutton());
			
		LTMTask.Taskmamagemnetbutton().click();
		
		d.navigate().refresh();
		
		System.out.println("Taskmanagement open");
		
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("Sendmessage", d);
		
		//test.log(LogStatus.PASS, "Test Pass");
	}

	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		//report.endTest(test);
		//report.flush();
		d.close();

}

}

