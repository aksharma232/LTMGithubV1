package ltm_testcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ltm_Pages.LTM_Connectionpage;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;
import ltm_Utility.LTM_Screenshot;
import ltm_Utility.LTM_SelectMethod;
import ltm_Utility.Xls_Reader;

public class LTM_RDPConnection extends LTM_Baseclass
{
	LTMLogin ltmlogin;
	LTM_RHS_Page ltmrhs;
	//LTM_Patchupgrade Patchupgrade;
	LTM_Connectionpage Connectionpage;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		Launchbrowser();
		log.info("launching chrome broswer");
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}

	@Test
	public void LTMRDPConnection() throws Exception
	{
	
		log.info("RDP Connection testing");
		
		ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		
		Connectionpage = PageFactory.initElements(d, LTM_Connectionpage.class);

		Xls_Reader ob1 = new Xls_Reader(ltmlogin.Project_path + "\\Testdata\\LTMTestdata.xlsx");
		
		JavascriptExecutor js = (JavascriptExecutor)d;
		
		LTM_LHSOptions LHS = new LTM_LHSOptions();
		
		LHS.LTM_LHSTC();
		
		log.info("Selecting TC");
		
		WebDriverWait w = new WebDriverWait(d,150);
		
		WebElement R = ltmrhs.ClickonRHSMenu();
		
		Thread.sleep(8000);
		
		log.info("Looking for Connection Manager");
		
		Actions RHS = new Actions(d);
		
		RHS.moveToElement(R).click().build().perform();
		
		Thread.sleep(8000);
		
		boolean CM = ltmrhs.Connection_Management().isDisplayed();
		
		if(CM);
		{
			System.out.println("Pass");
		}
	
		
		WebElement C = w.until(ExpectedConditions.elementToBeClickable(ltmrhs.Connection_Management()));
		
		C.click();
		
		log.info("Clicked on Connection Manager");
		
		ltmrhs.Connection().click();
		
		log.info("Connection creat new button");
		
		Thread.sleep(4000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.Newbutton());

		Connectionpage.Newbutton().click();

		log.info("Clicked Connection creat new button");
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.Connectionnextbutton());
			
		LTM_SelectMethod SM1 = new LTM_SelectMethod();
		
		SM1.LTMSelectMethod(Connectionpage.ConnectionType(), "RDesktop");
		
		log.info("Selecting RDesktop");

		Connectionpage.Connectionname().sendKeys(ob1.getcelldatastring("RDPConnection", 1, 0));
		
		Connectionpage.Connectionnextbutton().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.RDPCOnnection_ServerURL());
		
		Connectionpage.RDPCOnnection_ServerURL().click();
		
		Connectionpage.RDPCOnnection_ServerURL().sendKeys(ob1.getcelldatastring("RDPConnection", 1, 1));
		
		//Connectionpage.RDPCOnnection_Port().click();
		
		Connectionpage.RDPCOnnection_Port().sendKeys(ob1.getcelldatastring("RDPConnection", 1, 2));
		
		Connectionpage.RDPConnectionusername().sendKeys(ob1.getcelldatastring("RDPConnection", 1, 3));		
		
		Connectionpage.RDPCOnnection_Password().sendKeys(ob1.getcelldatastring("RDPConnection", 1, 4));
		
		Connectionpage.RDPConnection_Domain().clear();
		
		Connectionpage.RDPConnection_Domain().sendKeys(ob1.getcelldatastring("RDPConnection", 1, 5));
		
		Connectionpage.RDPApplybtn().click();
		
		LTM_Taskmanagement Ob1 = new LTM_Taskmanagement();
		
		Ob1.TaskManagement();
		
		Thread.sleep(5000);
				
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("RDPConnetion", d);
		
		
		
		
		}

}
