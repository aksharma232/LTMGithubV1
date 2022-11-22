package ltm_testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ltm_Pages.LTM_Connectionpage;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;
import ltm_Pages.LTM_Taskmanagement_page;
import ltm_Utility.LTM_Screenshot;
import ltm_Utility.LTM_SelectMethod;
import ltm_Utility.SeleniumUtility;
import ltm_Utility.Xls_Reader;

public class LTM_Browserconnection extends LTM_Baseclass {

	LTMLogin ltmlogin;
	LTM_Taskmanagement_page LTMTask;
	
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Launchbrowser();
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}

	@Test
	public void LTMBrowserconnection() throws Exception 
	{
		System.out.println("Browser conection start");
		//log.info("Browser Connection testing");
		LTM_RHS_Page ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		LTMTask = PageFactory.initElements(d, LTM_Taskmanagement_page.class);
		LTM_Connectionpage Connectionpage = PageFactory.initElements(d, LTM_Connectionpage.class);
		Xls_Reader ob1 = new Xls_Reader(ltmlogin.Project_path + "\\Testdata\\LTMTestdata.xlsx");
		JavascriptExecutor js = (JavascriptExecutor) d;
		LTM_Select_Thinclient LHS = new LTM_Select_Thinclient();
		LHS.LTM_Select_TC();
		//log.info("Selecting TC");
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(d, 150);
		//WebElement R = ltmrhs.ClickonRHSMenu();
		//Thread.sleep(8000);
		//log.info("Looking for Connection Manager");
		
		Actions RHS = new Actions(d);
		 
		RHS.moveToElement(ltmrhs.ClickonRHSMenu()).click().build().perform();
		WebElement C = w.until(ExpectedConditions.elementToBeClickable(ltmrhs.Connection_Management()));
		C.click();
		//log.info("Clicked on Connection Manager");
		System.out.println("Clicked on Connection Manager");
		ltmrhs.Connection().click();
		log.info("Connection creat new button");
		js.executeScript("arguments[0].scrollIntoView(true);", Connectionpage.Newbutton());
		Connectionpage.Newbutton().click();
		System.out.println("Clicked Connection creat new button");
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", Connectionpage.Connectionnextbutton());
		LTM_SelectMethod SM1 = new LTM_SelectMethod();
		SM1.LTMSelectMethod(Connectionpage.ConnectionType(), ob1.getcelldatastring("BC", 0, 0));
		// SM1.LTMSelectMethod(Connectionpage.ConnectionType(), "Browser");
		//log.info("Selecting Browser");
		System.out.println("Selecting Browser");
		Connectionpage.Connectionname().sendKeys(ob1.getcelldatastring("BC", 1, 0));
		Connectionpage.Connectionnextbutton().click();
		js.executeScript("arguments[0].scrollIntoView(true);", Connectionpage.ConnectionApplybtn());
		Connectionpage.WebpageURL().sendKeys(ob1.getcelldatastring("BC", 1, 3));
		Connectionpage.ConnectionApplybtn().click();
		System.out.println("Normal Connection Created");
		Thread.sleep(2000);
		Connectionpage.ConnectionClosebtn().click();
		Thread.sleep(4000);
		// Browser Kiosk Mode
		Connectionpage.Newbutton().click();
		js.executeScript("arguments[0].scrollIntoView(true);", Connectionpage.Connectionnextbutton());
		SM1.LTMSelectMethod(Connectionpage.ConnectionType(), "Browser");
		System.out.println("For kiosk Selecting Browser");
		Connectionpage.Connectionname().sendKeys(ob1.getcelldatastring("BC", 2, 0));
		Connectionpage.Connectionnextbutton().click();
		js.executeScript("arguments[0].scrollIntoView(true);", Connectionpage.ConnectionApplybtn());
		Connectionpage.WebpageURL().sendKeys(ob1.getcelldatastring("BC", 2, 3));
		SM1.LTMSelectMethod(Connectionpage.SelectBrowserMode(), "Kiosk");
		System.out.println("Click on Apply");
		Thread.sleep(4000);
		Connectionpage.ConnectionApplybtn().click();
		System.out.println("Click on Apply1");
		System.out.println("Kisok Browser connection created");
		Thread.sleep(2000);
		Connectionpage.ConnectionClosebtn().click();
		System.out.println("Connection closed");
		Thread.sleep(2000);
		System.out.println("Connection end");
		
		d.navigate().refresh();
		
		SeleniumUtility selUtility = new SeleniumUtility();
		
		LTMTask.Taskmamagemnetbutton().click();
		
		//log.info("TaskManagemnet click");
		d.navigate().refresh();
		LTM_Screenshot S1 = new LTM_Screenshot();
		S1.LTM_Takescreeshot("FirefoxBrowser", d);
		System.out.println("Screenshot taken");
	
	}

	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		d.close();
		log.info("****************************** Browser is closed *****************************************");

	}

}
