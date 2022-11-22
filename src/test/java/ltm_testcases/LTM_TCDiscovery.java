package ltm_testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ltm_Pages.LTMDiscovery_Page;
;

//@Listeners(ltm_Utility.TestngListeners.class)
public class LTM_TCDiscovery extends LTM_Baseclass {

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Launchbrowser();
		LTMLogin ltmlogin = new LTMLogin();
		ltmlogin.login();
	}

	@Test
	public void TCdiscovery() throws InterruptedException, IOException {
		LTMDiscovery_Page LTMDiscovery = PageFactory.initElements(d, LTMDiscovery_Page.class);
		LTM_Select_Thinclient LHS = new LTM_Select_Thinclient();
		LTMDiscovery.clickonviewbtn();
		SoftAssert softAssert = new SoftAssert();
// Following click is deprecate from the GUI. It's available in old GUI.
// LTMDiscovery.dropdown_discovery();
		LTMDiscovery.discovery_page_discovery_btn();
		/*WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		boolean invisiablel1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='AjaxLoaderOuter']")));
		if (invisiablel1) {
			LTMDiscovery.discovery_page_scantype();
		}
		*/
		LTMDiscovery.discovery_page_scantype();
		//Thread.sleep(4000);
		LTMDiscovery.scanby();
		//Thread.sleep(4000);
		LTMDiscovery.discovery_okbtn();
		Thread.sleep(10000);
		String messages = LTMDiscovery.UDPscanmessage();
		System.out.println(messages);
		softAssert.assertEquals(messages, "UDP Broadcast scan is in Process");
		
		// Assertmessages, "");

		/*
		 * if (messages.equals("UDP Broadcast scan is in Process1")) {
		 * System.out.println("Scaning process Start"); Thread.sleep(5000);
		 * 
		 * 
		 * }
		 * 
		 * else { System.out.println("Scaning process doesn't Start");
		 * 
		 * }
		 */
		LTMDiscovery.Registerbtn();
		Thread.sleep(1000);
		LTMDiscovery.discovery_searchTC(P1.readproperties().getProperty("DeviceIP"));
		Thread.sleep(2000);
		List<WebElement> Discoverystatus = d.findElements(By.xpath("//td[contains(text(),'Registered')]"));
		System.out.println("Registerd=" + Discoverystatus.size());
		
		if (Discoverystatus.size() > 0) {
			System.out.println("TC alredy Registerd");
		} else {
			List<WebElement> Discoverystatus1 = d.findElements(By.xpath("//td[contains(text(),'Unregistered')]"));
			System.out.println("UnRegisterd=" + Discoverystatus1.size());
			if (Discoverystatus1.size() > 0) {
				System.out.println("Device is Not Rgiestered");
				d.findElement(By.xpath("//input[@class='chkItem']")).click();
				System.out.println("Click on Checkbox");
				d.findElement(By.id("btnRegister")).click();
				System.out.println("Click on Registerbtn");
				Thread.sleep(5000);
				d.findElement(By.id("ibtntHome")).click();
				d.navigate().refresh();
				System.out.println("Click on homebtn");
			} else {
				System.out.println("Thin Client IP is invaild or Not Available");
			}
		}
		d.findElement(By.id("ibtntHome")).click();
		LHS.LTM_Select_TC();
		log.info("TC Selected");
		softAssert.assertAll();
	}
	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		d.close();
	}
}