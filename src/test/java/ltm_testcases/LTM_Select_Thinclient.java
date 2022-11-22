package ltm_testcases;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import ltm_Pages.LTM_LHS_Page;
import ltm_Utility.SeleniumUtility;

public class LTM_Select_Thinclient extends LTM_Baseclass {
	LTMLogin ltmlogin;
	LTM_LHS_Page ltmlhs;
	WebElement TC1;
	WebElement groupname1;

	
	public WebElement LTM_Select_TC() throws IOException, InterruptedException
	{
		SeleniumUtility selUtility = new SeleniumUtility();
		
		ltmlhs = PageFactory.initElements(d, LTM_LHS_Page.class);

		Thread.sleep(1000);

		ltmlhs.ClickonDefaultgrp().click();
		
		//TC1 = d.findElement(By.xpath("//span[@class= 'icon-274--linux_green-dot' and contains(text(),'192.168.1.235')]"));
		
		String TC = P1.readproperties().getProperty("DeviceIP");
				
		TC1 = d.findElement(By.xpath("//span[@class= 'icon-274--linux_green-dot' and contains(text(),'"+ TC +"')]"));
		
		System.out.println("TC Found");
		
		TC1.click();
	
		//List<WebElement> TCList = d.findElements(By.xpath("//div[@class='rtTemplate']"));
		
		/*
		int List = TCList.size(); 
		
		System.out.println("Total TC on LTM Server"+ List);

		for (WebElement currentlist : TCList)
		{
			
			String TC = P1.readproperties().getProperty("DeviceIP");
			
			if (currentlist.getText().trim().equals(TC)) 
			{
				System.out.println("Inside if");
				
				selUtility.isDisplayed(currentlist);
				
				System.out.println(currentlist.getAttribute("span"));
								
				TC1 = currentlist;
				
				currentlist.click();
				
				break;
				
			}
			
			else 
			{
				System.out.println("No device not found");
			}
				
		}
*/ 
		
		return TC1;
							
	}
	
	public void TC_Right_Click()
		{
			Actions Rightclick = new Actions(d);
			
			Rightclick.contextClick(TC1).perform();
		}


}