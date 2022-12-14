package ltm_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LTM_LHS_Page
{
	@FindBy(how=How.XPATH, using="//div[@id='ctl00_ContentPlaceHolder1_RadTreeView1']//*[contains(text(),'DEFAULT')]//preceding::span[1]")
	//Above xpath will also work - //*[@id= 'ctl00_ContentPlaceHolder1_RadTreeView1']//*[contains(text(),'DEFAULT')]
	WebElement GrpDefault;
	
	//@FindBy(how=How.XPATH, using= "//div[@class='rtTemplate'")
	//WebElement Thinclientlist;
		
	@FindBy(how=How.XPATH, using="//div[@id='ctl00_ContentPlaceHolder1_RadTreeView1_CMLinuxClientON_detached']//span[@class='rmText rmExpandRight'][contains(text(),'Remote Operation')]")
  	WebElement Remoteoperation;
	
	@FindBy(how=How.XPATH, using="//div[@id='ctl00_ContentPlaceHolder1_RadTreeView1_CMLinuxClientON_detached']//span[@class='rmText'][contains(text(),'Send Message')]")
	WebElement Sendmessage;
	
	@FindBy(how=How.ID, using="txtMsghtml")
	WebElement Insertmessage;
	
	@FindBy(how=How.ID, using="chkIAgree")
	WebElement Alertcheckbox;
	
	@FindBy(how=How.ID, using="btnOKConfirmationPopup")
	WebElement OKConfirmationPopup;
	
	@FindBy(how=How.ID, using="ContentPlaceHolder1_btnApplySettings")
	WebElement SenmessageAbtn;
	
	@FindBy(how=How.ID, using="ContentPlaceHolder1_btnCloseDown")
	WebElement Messageclosebtn;
	
	
	
	public WebElement ClickonDefaultgrp()
	{
		return GrpDefault;
	}
			
	public WebElement ClickonRemoteoperation()
	{
		return Remoteoperation;
	}
	
	public WebElement Sendmessage()
	{
		return Sendmessage;
	}
	
	
	public WebElement LTMMessage() 
	{
	
		return Insertmessage;
	}
	
	public WebElement Alertcheckbox()
	{
		return Alertcheckbox;
	}
	
	public WebElement OKConfirmationPopup()
	{
		return OKConfirmationPopup;
	}
	
	

	public void Messageapplybutton()
	{
		SenmessageAbtn.click();
	}
	
	public void Messageclosebtn()
	{
		Messageclosebtn.click();
	}
	
	/*public WebElhinclientlist()
	{
		List<WebElement> TCList = Thinclientlist();
		return TCList;
				
	}
	*/
}
