package ltm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LTM_Connectionpage 
{

	@FindBy(how=How.XPATH, using= "//input[@id='LinuxConnectionbtnNewConnection']") 
	WebElement Newbutton;

	@FindBy(how=How.XPATH, using= "//select[@id='LinuxConnectionddlConnectionTypeInitial']")
	WebElement SelectConnection;


	@FindBy(how=How.XPATH, using="//input[@id='LinuxConnectiontxtConnectionName']")
	WebElement Connectionname;

	@FindBy(how=How.XPATH, using="//input[@id='LinuxConnectionbtnNext0']")
	WebElement Connectionnext;
	
	@FindBy(how=How.XPATH, using="//input[@id='LinuxBrowserConntxtHomeURL']")
	WebElement WebpageURL;

	@FindBy(how=How.XPATH, using="//input[@id='LinuxBrowserConnbtnSave']")
	WebElement ConnectionApplybtn;

	@FindBy(how=How.XPATH, using="//input[@id='LinuxBrowserConnbtnWCancel']")
	WebElement ConnectionClosebtn;

	@FindBy(how=How.XPATH, using="//select[@id='LinuxBrowserConnddlBrowserType']")
	WebElement BrowserType;
	

	@FindBy(how=How.ID, using="LinuxBrowserConnddlMode")
	WebElement SelectBrowserMode;
	
	//
	public WebElement Newbutton()
	{
		return Newbutton;
	}

	public WebElement ConnectionType()
	{
		return SelectConnection;
	}

	public WebElement Connectionname()
	{
		return Connectionname;
	}

	public WebElement Connectionnextbutton()
	{
		return Connectionnext;
	}


	public WebElement WebpageURL()
	{
		return WebpageURL;
	}

	public WebElement ConnectionApplybtn()
	{
		return ConnectionApplybtn;
	}
	
	public WebElement SelectBrowserMode()
	{
		return SelectBrowserMode;
	}
	
	public WebElement BrowserType()
	{
		return BrowserType;
	}
	
	public WebElement ConnectionClosebtn()
	{
		return ConnectionClosebtn;
	}

//==Following are the RDP connection elements ==============
	
	@FindBy(how=How.ID, using="Linux_Rdesktop_txtServer")
	WebElement RDPCOnnection_ServerURL;

	
	@FindBy(how=How.ID, using="Linux_Rdesktop_txtPort")
	WebElement RDPCOnnection_Port;
		
	@FindBy(how=How.ID, using="Linux_Rdesktop_txtUserName")
	WebElement RDPConnection_username;
		
	@FindBy(how=How.ID, using="Linux_Rdesktop_txtPassword")
	WebElement RDPCOnnection_Password;
		
	@FindBy(how=How.ID, using="Linux_Rdesktop_lxRDPDomain_txtCombobox")
	WebElement RDPConnection_Domain;
	
	@FindBy(how=How.ID, using="Linux_Rdesktop_btnSave")
	WebElement RDPApplybtn;
	
	public WebElement RDPCOnnection_ServerURL()
	{
		return RDPCOnnection_ServerURL;
	}
	
	public WebElement RDPCOnnection_Port()
	{
		return RDPCOnnection_Port;
	}

	public WebElement RDPConnectionusername()
	{
		return RDPConnection_username;
	}
	
	public WebElement RDPCOnnection_Password()
	{
		return RDPCOnnection_Password;
	}
	
	public WebElement RDPConnection_Domain()
	{
		return RDPConnection_Domain;
	}
	
	public WebElement RDPApplybtn()
	{
		return RDPApplybtn;
		
	}
//=================================================================
//FreeRDP Connection 
	@FindBy(how=How.ID, using="Linux_Freerdp_txtServer")
	WebElement FreeRDPServer;
	
	@FindBy(how=How.ID, using="Linux_Freerdp_dvFreeRDP_Port")
	WebElement FreeRDPServerPort;
	
	@FindBy(how=How.ID, using="Linux_Freerdp_txtUserName")
	WebElement FreeRDPUsername;
	
	@FindBy(how=How.ID, using="Linux_Freerdp_txtPassword")
	WebElement FreeRDPPassword;
	

	@FindBy(how=How.ID, using="Linux_Freerdp_txtDomain")
	WebElement FreeRDPDomain;
	
	@FindBy(how=How.ID, using="Linux_Freerdp_btnSave")
	WebElement FreeRDPApplybutton;
	
	@FindBy(how=How.ID, using="Linux_Freerdp_btnFreeRDPClose")
	WebElement FreeRDPClosebutton;
	
	public WebElement FreeRDPServer()
	{
		return FreeRDPServer;
	}

	public WebElement FreeRDPServerort()
	{
		return FreeRDPServerPort;
	}
	
	public WebElement FreeRDPServerpassowrd()
	{
		return FreeRDPPassword;
	}
	
	public WebElement FreeRDPDomain()
	{
		return FreeRDPDomain;
	}
	
	public WebElement FreeRDPApplybutton()
	{
		return FreeRDPApplybutton;
	}
}
