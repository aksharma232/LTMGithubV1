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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ltm_Pages.LTM_Connectionpage;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;
import ltm_Pages.LTM_Taskmanagement_page;
import ltm_Utility.LTM_Movetoelement;
import ltm_Utility.LTM_Screenshot;
import ltm_Utility.LTM_SelectMethod;
import ltm_Utility.SeleniumUtility;
import ltm_Utility.Xls_Reader;

@Listeners(ltm_Utility.TestngListeners.class)
public class LTM_RDPConnection extends LTM_Baseclass
{
	LTMLogin ltmlogin;
	LTM_RHS_Page ltmrhs;
	LTM_Connectionpage Connectionpage;
	LTM_Taskmanagement_page LTMTask;
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
		SeleniumUtility selUtility = new SeleniumUtility();
				
		LTM_Movetoelement M1 = new LTM_Movetoelement();
		
		log.info("RDP Connection testing");
		
		ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		
		Connectionpage = PageFactory.initElements(d, LTM_Connectionpage.class);

		LTMTask = PageFactory.initElements(d, LTM_Taskmanagement_page.class);
		
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
		
		M1.movetoelement(Connectionpage.ConnectionApplybtn(), d);
		
		Connectionpage.RDPApplybtn().click();
		
		d.navigate().refresh();
		
		selUtility.isClickable(LTMTask.Taskmamagemnetbutton());
		
		LTMTask.Taskmamagemnetbutton().click();
		
		d.navigate().refresh();
				
		LTMTask.Taskmamagemnetbutton().click();
				
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("RDPConnetion", d);
				
		}

	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		d.close();

}
}
