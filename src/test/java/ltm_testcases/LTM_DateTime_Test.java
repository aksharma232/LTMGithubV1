package ltm_testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ltm_Pages.LTM_Connectionpage;
import ltm_Pages.LTM_DateTime_Page;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;

public class LTM_DateTime_Test extends LTM_Baseclass
{
	//
	LTMLogin ltmlogin;
	LTM_RHS_Page ltmrhs;
	LTM_DateTime_Page DateTime;
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
	public void DateTime() throws IOException, InterruptedException 
	{
		ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		
		DateTime = PageFactory.initElements(d, LTM_DateTime_Page.class);
		
		LTM_Select_Thinclient LHS = new LTM_Select_Thinclient();
		
		LHS.LTM_Select_TC();
		
		//Thread.sleep(2000);
		
		Actions RHS = new Actions(d);
		
		RHS.moveToElement(ltmrhs.ClickonRHSMenu()).click().build().perform();
		
		boolean a = ltmrhs.System_Settings().isDisplayed();
		
		if(a)
		{
			System.out.println("Present");
		}
		else
		{
			System.out.println("Not Present");
		}
		
		ltmrhs.System_Settings().click();
		
		
		
		ltmrhs.Date_and_Time().click();
		
		ltmrhs.Date_Time_Setup().click();
	
		Thread.sleep(3000);

		DateTime.ManualDate().click();
	}

}









