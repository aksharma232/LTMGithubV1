package ltm_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LTM_Patchupgrade 
{

	@FindBy(how=How.ID, using= "LXSoftwareUpgrade_btnNew_Install") 
	WebElement Newupdate;
	
	public WebElement Newupdate()
	{
		return Newupdate;
	}
//===================================================================================	
	@FindBy(how=How.ID, using= "LXSoftwareUpgrade_ddlUpgradeType") 
	WebElement Upgradetype;
	
	public void Upgradetype()
	{
		Select update = new Select(Upgradetype);
		
		update.selectByVisibleText("Firmware Upgrade");
		
	}
//====================================================================================
	@FindBy(how=How.ID, using= "LXSoftwareUpgrade_ddlSourceType") 
	WebElement Repositorytype;
	
	public void Repositorytype() throws InterruptedException
	{
		Select Repotype = new Select(Repositorytype);
		Repotype.selectByIndex(1);
		
	}
//======================================================================================	
	@FindBy(how=How.ID, using= "LXSoftwareUpgrade_ddlSource") 
	WebElement Sourcetype;
	
	public void Sourceclick()
	{
		Sourcetype.click();
	}
	
	public void Source()
	{
		Select Sourcetypelist = new Select(Sourcetype);
		Sourcetypelist.selectByIndex(1);
	}

//=======================================================================================
	@FindBy(how=How.ID, using= "LXSoftwareUpgrade_tdForFileSelect") 
	WebElement updatefilename;
	
	public WebElement updatefilename()
	{
		return updatefilename;
	}
//==========================================================================================	
// UPloaded successfully Message - //label[contains(text (), 'has been Uploaded')]
	
	@FindBy(how=How.XPATH, using= "//label[contains(text (), 'has been Uploaded')]") 
	WebElement uploadedmessage;
	
	public WebElement uploadedmessage()
	{
		return uploadedmessage;
	}
	
	
	// Cancel Button ==========================	
	@FindBy(how=How.ID, using= "LXSoftwareUpgrade_btnCancel_er") 
	WebElement cancelbutton;
	
	public WebElement cancelbuttonm()
	{
		return cancelbutton;
	}	
	
}
