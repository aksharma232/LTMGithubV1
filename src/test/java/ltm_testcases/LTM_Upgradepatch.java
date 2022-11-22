package ltm_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ltm_Pages.LTM_LHS_Page;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;
import ltm_Pages.LTM_Taskmanagement_page;
import ltm_Utility.LTM_Screenshot;
import ltm_Utility.SeleniumUtility;
//@Listeners(ltm_Utility.TestngListeners.class)

public class LTM_Upgradepatch extends LTM_Baseclass {
	
	LTM_Taskmanagement_page LTMTask;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Launchbrowser();
		LTMLogin ltmlogin = new LTMLogin();
		ltmlogin.login();
	}
	@Test
	public void LTMRHS() throws Exception {
		SeleniumUtility selUtility = new SeleniumUtility();
		LTM_RHS_Page ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		LTM_Patchupgrade Patchupgrade = PageFactory.initElements(d, LTM_Patchupgrade.class);
		LTMTask = PageFactory.initElements(d, LTM_Taskmanagement_page.class);
		
		LTM_Select_Thinclient LHS = new LTM_Select_Thinclient();
		LHS.LTM_Select_TC();
		System.out.println("Reached Here");
		log.info("TC Selected");
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(d, 150);
		//WebElement R = ltmrhs.ClickonRHSMenu();
		Thread.sleep(3000);
		Actions RHS = new Actions(d);
		System.out.println("Reached Here");
		RHS.moveToElement(ltmrhs.ClickonRHSMenu()).click().build().perform();
		Thread.sleep(3000);
		ltmrhs.UpgradeManagement().click();
		ltmrhs.Software_Upgrade_Management().click();
		ltmrhs.Software_Upgrade().click();
		//Thread.sleep(2000);
		Patchupgrade.Newupdate().click();
		System.out.println("New Upgrade Process");
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView(true);", Patchupgrade.cancelbuttonm());
		Patchupgrade.Upgradetype();
		Patchupgrade.Repositorytype();
		//Thread.sleep(2000);
		Patchupgrade.Sourceclick();
		Patchupgrade.Source();
		//Thread.sleep(2000);
		log.info("Select upgrade patch");
		String Patchpath = System.getProperty("user.dir") + "\\Testdata\\patch.tar.bz2";
		//d.findElement(By.id("LXSoftwareUpgrade_fileUpload")).sendKeys(Patchpath);
		Patchupgrade.Upgrade_Patch_Location().sendKeys(Patchpath);
		System.out.println("Patch is selected");
		d.findElement(By.id("LXSoftwareUpgrade_btnUpload")).click();
		System.out.println("clicked on upload button");
		//Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", Patchupgrade.cancelbuttonm());
		w.until(ExpectedConditions.visibilityOf(Patchupgrade.uploadedmessage()));
		System.out.println("Patch uploaded Successfully");
		Thread.sleep(2000);
		//Actions action = new Actions(d);
		//action.moveToElement(Patchupgrade.applybutton());
		//System.out.println("Patch uploaded1 Successfully");
		Patchupgrade.applybutton().click();
		System.out.println("Patch uploaded2 Successfully");
		Patchupgrade.closebutton().click();
		
		System.out.println("Patch uploaded3 Successfully");
		
		d.navigate().refresh();
		
		//Thread.sleep(2000);
		
		//d.findElement(By.xpath("//a[@id='ImageButtonTask']")).click();
		
		selUtility.isClickable(LTMTask.Taskmamagemnetbutton());
		
		LTMTask.Taskmamagemnetbutton().click();
		
		d.navigate().refresh();
		
		
		System.out.println("Taskmanagement open");
		
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("Upgradepatch", d);
	
	}
	
	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
	d.close();
	}

}
