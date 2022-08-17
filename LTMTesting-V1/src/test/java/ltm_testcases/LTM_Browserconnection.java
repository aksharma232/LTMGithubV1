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
import ltm_Utility.LTM_Screenshot;
import ltm_Utility.LTM_SelectMethod;
import ltm_Utility.Xls_Reader;

public class LTM_Browserconnection extends LTM_Baseclass

{

	LTMLogin ltmlogin;
	LTM_RHS_Page ltmrhs;
	LTM_Patchupgrade Patchupgrade;
	LTM_Connectionpage Connectionpage;
	LTM_LHSOptions LHS;
		
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		Launchbrowser();
		log.info("launching chrome broswer");
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}

	@Test
	public void LTMBrowserconnection() throws Exception
	{
	
		log.info("Browser Connection testing");
		
		ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		
		Patchupgrade = PageFactory.initElements(d, LTM_Patchupgrade.class);
		
		Connectionpage = PageFactory.initElements(d, LTM_Connectionpage.class);
		
		Xls_Reader ob1 = new Xls_Reader(ltmlogin.Project_path + "\\Testdata\\LTMTestdata.xlsx");

		JavascriptExecutor js = (JavascriptExecutor)d;
		
		LHS = new LTM_LHSOptions();
		
		LHS.LTM_LHSTC();		
		
		log.info("Selecting TC");
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(d,150);
		
		WebElement R = ltmrhs.ClickonRHSMenu();
		
		Thread.sleep(8000);
		
		log.info("Looking for Connection Manager");
		
		Actions RHS = new Actions(d);
		
		RHS.moveToElement(R).click().build().perform();
		
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

		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.Newbutton());
		
		Connectionpage.Newbutton().click();

		log.info("Clicked Connection creat new button");
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.Connectionnextbutton());
			
		LTM_SelectMethod SM1 = new LTM_SelectMethod();
		
		SM1.LTMSelectMethod(Connectionpage.ConnectionType(),ob1.getcelldatastring("BC", 0, 0));
		
		//SM1.LTMSelectMethod(Connectionpage.ConnectionType(), "Browser");
		
		log.info("Selecting Browser");
		
		Connectionpage.Connectionname().sendKeys(ob1.getcelldatastring("BC", 1, 0));
		
		Connectionpage.Connectionnextbutton().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.ConnectionApplybtn());
		
		//Thread.sleep(4000);
		
		Connectionpage.WebpageURL().sendKeys(ob1.getcelldatastring("BC", 1, 3));
		
		Connectionpage.ConnectionApplybtn().click();
		
		log.info("Normal Connection Created");
		
		Thread.sleep(2000);
		
		Connectionpage.ConnectionClosebtn().click();
		
		Thread.sleep(4000);
		
		// Browser Kiosk Mode
		
		Connectionpage.Newbutton().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.Connectionnextbutton());
		
		SM1.LTMSelectMethod(Connectionpage.ConnectionType(), "Browser");
		
		log.info("Selecting Browser");
		
		Connectionpage.Connectionname().sendKeys(ob1.getcelldatastring("BC", 2, 0));
		
		Connectionpage.Connectionnextbutton().click();
		
		js.executeScript("arguments[0].scrollIntoView(true);",Connectionpage.ConnectionApplybtn());
		
		Connectionpage.WebpageURL().sendKeys(ob1.getcelldatastring("BC", 2, 3));
		
		SM1.LTMSelectMethod(Connectionpage.SelectBrowserMode(), "Kiosk");		
		
		System.out.println("Click on Apply");
		
		Thread.sleep(4000);
		
		Connectionpage.ConnectionApplybtn().click();
	
		System.out.println("Click on Apply1");
		
		log.info("Kisok Browser connection created");
		
		Thread.sleep(2000);
		
		Connectionpage.ConnectionClosebtn().click();
		
		Thread.sleep(2000);
		
		LTM_Taskmanagement Ob1 = new LTM_Taskmanagement();
		
		log.info("TaskManagemnet click");
		
		Ob1.TaskManagement();
		
		Thread.sleep(2000);
			
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("FirefoxBrowser", d);

		log.info("Screenshot taken");
	}
	@AfterMethod
		public void closesetup() throws IOException, InterruptedException {
			d.close();
			log.info("****************************** Browser is closed *****************************************");
			
	}

	}




