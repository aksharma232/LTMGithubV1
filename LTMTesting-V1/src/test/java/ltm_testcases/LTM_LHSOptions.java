package ltm_testcases;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import ltm_Pages.LTM_LHS_Page;

public class LTM_LHSOptions extends LTM_Baseclass {
	LTMLogin ltmlogin;
	LTM_LHS_Page ltmlhs;
	WebElement TC1;
	WebElement groupname1;
	
	public void LTM_LHSTC() throws IOException, InterruptedException
	{
		ltmlhs = PageFactory.initElements(d, LTM_LHS_Page.class);

		Thread.sleep(5000);

		ltmlhs.ClickonDefaultgrp().click();
	
		System.out.println("cccccc");

	
		List<WebElement> TCList = d.findElements(By.xpath("//div[@class='rtTemplate']"));
		
		@SuppressWarnings("unchecked")
		
		int List = TCList.size(); 
		
		System.out.println(List);

		int a = 1;
		
		for (WebElement currentlist : TCList)
		{
			
			String TC = P1.readproperties().getProperty("DeviceIP");
			
			if (currentlist.getText().trim().equals(TC)) 
			{
				
				TC1 = currentlist;
				
				System.out.println(currentlist.getText());
				
				Thread.sleep(2000);
				
				currentlist.click();
				
				Thread.sleep(2000);
				
				a++;
				
				break;
			} 
		}
		if(a==2)
		{
			System.out.println("Click done");
		}
			else 
			{
				System.out.println("No device not find");
			}

		TC1.click();
			
	}
	
		public void TC_Right_Click()
		{
			Actions Rightclick = new Actions(d);
			
			Rightclick.contextClick(TC1).perform();
		}


}