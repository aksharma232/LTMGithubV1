package ltm_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LTMDiscovery_Page 
{
		@FindBy(how=How.ID, using= "imgBtnDiscoverClient")
		WebElement view_btn;
			
		@FindBy(how=How.ID, using= "imgBtnDiscoverClient")
		WebElement Dropdown_Discovery;

		@FindBy(how=How.ID, using= "ContentPlaceHolder1_lblMenuDiscovery")
		WebElement Discover_Page_Discovery_btn;
			
		@FindBy(how=How.ID, using= "ddlDiscoveySelect")
		WebElement Discover_Page_Scantype;
		
		@FindBy(how=How.ID, using= "btnRefresh")
		WebElement Discover_Refresh;
				
		@FindBy(how=How.ID, using= "buttonDiscoveryOK")
		WebElement Discover_Page_OK_btn;
		
		@FindBy(how=How.ID, using="lblRescanActive")
		WebElement UDP_scan_message;

		@FindBy(how=How.ID, using="ContentPlaceHolder1_lblMenuRegister")
		WebElement Discovery_Register_btn;
		
		@FindBy(how=How.XPATH, using="//div[@id='tblDiscover_filter']//input[@placeholder='Search...']")
		WebElement SearchTC;
		
		
		public void clickonviewbtn(){
			view_btn.click();
		}
		
		public void dropdown_discovery(){
			Dropdown_Discovery.click();
		}
		
		public void discovery_page_discovery_btn()
		{
			Discover_Page_Discovery_btn.click();
		}
		public void discovery_page_scantype()
		{
			Discover_Page_Scantype.click();
		}
		
		public String UDPscanmessage()
		{
			return UDP_scan_message.getText();
		}
		public void scanby ()
		{
			Select scantype = new Select(Discover_Page_Scantype);
			scantype.selectByValue("UDP Broadcast");
		}
		
		public void Refreshbtn()
		{
			Discover_Refresh.click();
			
		}
		public void discovery_okbtn ()
		{
			Discover_Page_OK_btn.click();
		}
		
			public void Registerbtn()
		{
			Discovery_Register_btn.click();
		}
		
		public void discovery_searchTC(String TCIP)
		{
			SearchTC.sendKeys(TCIP);
		}

}
