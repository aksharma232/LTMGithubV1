package ltm_testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ltm_Pages.LTMLogin_Page;
import ltm_Utility.Xls_Reader;

public class LTMLogin extends LTM_Baseclass 
{

	LTMLogin_Page loginpage;

	public void login() throws InterruptedException, IOException 
	{

		Xls_Reader ob1 = new Xls_Reader(Project_path + "\\Testdata\\LTMTestdata.xlsx");
		
		loginpage = PageFactory.initElements(d, LTMLogin_Page.class);

		int lastrow = ob1.getRowCount("CD");

		System.out.println("Login Process start");
	
		for (int j = 0; j < lastrow; j++)
		{
			
			loginpage.LTMUsername().sendKeys(ob1.getcelldatastring("CD", j, 0));
			
			loginpage.LTMPassword().sendKeys(ob1.getcelldatastring("CD", j, 1));
			
			loginpage.clickOnLoginButton();
			
			try 
			{	
				if(loginpage.lblFailureText().isDisplayed())
					{
					System.out.println("Invalid username or password entered.");				       
					loginpage.lblFailureText_closebutton().click();
					loginpage.LTMUsername().clear();
					loginpage.LTMPassword().clear();
					}	
			else
				{
				if(d.findElement(By.xpath("//img[@id='siteHeaderLogo']")).isDisplayed())
					{
						System.out.println("Logged in successfully");
					}
				break;
				}
			}
		finally
		{
			System.out.println("Logged in successfully");
		}
		}
	}	
}
