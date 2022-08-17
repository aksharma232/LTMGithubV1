package ltm_testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ltm_Pages.LTMDiscovery_Page;

import ltm_Pages.LTM_LHS_Page;

public class LTM_TCDiscovery extends LTM_Baseclass {
	LTMLogin ltmlogin;
	LTM_LHS_Page ltmlhs;
	LTMDiscovery_Page LTMDiscovery;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Launchbrowser();
		ltmlogin = new LTMLogin();
		ltmlogin.login();
	}

	@Test
	public void TCdiscovery() throws InterruptedException, IOException {
		
		LTMDiscovery = PageFactory.initElements(d, LTMDiscovery_Page.class);
		LTMDiscovery.clickonviewbtn();
		LTMDiscovery.dropdown_discovery();
		LTMDiscovery.discovery_page_discovery_btn();
		Thread.sleep(1000);

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(d, 3);

		boolean invisiablel1 = wait
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='AjaxLoaderOuter']")));
		if (invisiablel1) {
			LTMDiscovery.discovery_page_scantype();
		}

		Thread.sleep(4000);
		
		LTMDiscovery.scanby();
		
		Thread.sleep(4000);
		
		LTMDiscovery.discovery_okbtn();
		
		Thread.sleep(10000);
		
		String messages = LTMDiscovery.UDPscanmessage();
		
		System.out.println(messages);
		
		if (messages.equals("UDP Broadcast Scan has been activated"))
		{
			System.out.println("Pass");
			Thread.sleep(5000);
			LTMDiscovery.Refreshbtn();
			
			
			//td[contains(text(),'Unregistered')]
		} 
		
		else 
		{
			System.out.println("fail");
		}
		
		LTMDiscovery.Registerbtn();
				
		LTMDiscovery.discovery_searchTC(P1.readproperties().getProperty("DeviceIP"));
	
		//List<WebElement> Discoverystatus = d.findElements(By.id("ContentPlaceHolder1_lblDataTblIPAddress"));
		
		//System.out.println("Registerd="+Discoverystatus.size());
		
		List<WebElement> Discoverystatus = d.findElements(By.xpath("//td[contains(text(),'Registered')]"));

		System.out.println("Registerd="+Discoverystatus.size());

		if (Discoverystatus.size() > 0)
		{
			System.out.println("TC alredy Registerd");
			d.findElement(By.id("ibtntHome")).click();
		} 
		else 
		{
			List<WebElement> Discoverystatus1 = d.findElements(By.xpath("//td[contains(text(),'Unregistered')]"));
			System.out.println("UnRegisterd="+Discoverystatus1.size());
		
			if (Discoverystatus1.size() > 0) 
			{
				System.out.println("Not Rgiestered");
				d.findElement(By.xpath("//input[@class='chkItem']")).click();
				System.out.println("Click on Checkbox"); 
				d.findElement(By.id("btnRegister")).click();
				System.out.println("Click on Registerbtn");
				d.findElement(By.id("ibtntHome")).click();
				System.out.println("Click on homebtn");
			} 
			else 
			{
				System.out.println("Thin Client IP is invaild or Not Available");
				
			}

		}

	}

	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		d.close();

}

}