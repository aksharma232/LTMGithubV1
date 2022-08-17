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
import org.testng.annotations.Test;

import ltm_Pages.LTM_LHS_Page;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;
import ltm_Utility.LTM_Screenshot;

public class LTM_Upgradepatch extends LTM_Baseclass

{
	LTMLogin ltmlogin;
	//LTM_LHS_Page ltmlhs;
	LTM_RHS_Page ltmrhs;
	LTM_Patchupgrade Patchupgrade;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		Launchbrowser();
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}

	
	@Test
	public void LTMRHS() throws Exception
	{
	
		ltmrhs = PageFactory.initElements(d, LTM_RHS_Page.class);
		
		Patchupgrade = PageFactory.initElements(d, LTM_Patchupgrade.class);

		LTM_LHSOptions LHS = new LTM_LHSOptions();
	
		LHS.LTM_LHSTC();
		
		log.info("TC Selected");
		
		WebDriverWait w = new WebDriverWait(d,150);
		
		WebElement R = ltmrhs.ClickonRHSMenu();
		
		Thread.sleep(3000);
		
		Actions RHS = new Actions(d);
		
		RHS.moveToElement(R).click().build().perform();
		
		Thread.sleep(3000);
		
		ltmrhs.UpgradeManagement().click();
		
		ltmrhs.Software_Upgrade_Management().click();
		
		ltmrhs.Software_Upgrade().click();
		
		Thread.sleep(2000);
		
		Patchupgrade.Newupdate().click();
		
		log.info("New Upgrade Process");
		
		JavascriptExecutor js = (JavascriptExecutor)d;
		
		js.executeScript("arguments[0].scrollIntoView(true);",Patchupgrade.cancelbuttonm());	
		
		Patchupgrade.Upgradetype();
		
		Patchupgrade.Repositorytype();
		
		Thread.sleep(2000);
		
		Patchupgrade.Sourceclick();
		
		Patchupgrade.Source();
		
		Thread.sleep(2000);
		
		log.info("Select upgrade patch");
		
		d.findElement(By.id("LXSoftwareUpgrade_fileUpload")).sendKeys("G:\\LTM-Automation\\LTM_Test\\LTMTest\\Testdata\\Patch.tar.bz2");
		
		log.info("Patch is selected");
		
		d.findElement(By.id("LXSoftwareUpgrade_btnUpload")).click();
				
		Thread.sleep(2000); 
		
		js.executeScript("arguments[0].scrollIntoView(true);",Patchupgrade.cancelbuttonm());
		
		w.until(ExpectedConditions.visibilityOf(Patchupgrade.uploadedmessage()));
	
		log.info("Patch uploaded Successfully");
		
		//WebElement a = d.findElement(By.xpath("//input[@id='LXSoftwareUpgrade_btnInstallSW']"));
		
		Actions action = new Actions(d);
		
		action.moveToElement(d.findElement(By.xpath("//input[@id='LXSoftwareUpgrade_btnInstallSW']")));
		
		d.findElement(By.xpath("//input[@id='LXSoftwareUpgrade_btnInstallSW']")).click();
	
		Thread.sleep(2000);
		
		LTM_Taskmanagement Ob1 = new LTM_Taskmanagement();
		
		Ob1.TaskManagement();
		
		Thread.sleep(5000);
				
		LTM_Screenshot S1 = new LTM_Screenshot();
		
		S1.LTM_Takescreeshot("Upgradepatch", d);

	}

@AfterMethod

public void closesetup() throws IOException, InterruptedException {
d.close();
}

	}


