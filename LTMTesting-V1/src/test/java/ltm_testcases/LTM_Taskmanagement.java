package ltm_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import ltm_Pages.LTMDiscovery_Page;

public class LTM_Taskmanagement extends LTM_Baseclass {

	LTMDiscovery_Page LTMDiscovery;

	public void TaskManagement() 
	{
		LTMDiscovery = PageFactory.initElements(d, LTMDiscovery_Page.class);

		//LTMDiscovery.clickonviewbtn();
		
		d.findElement(By.xpath("//a[@id='ImageButtonTask']")).click();
	}
}