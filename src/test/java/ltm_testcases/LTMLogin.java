package ltm_testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ltm_Pages.LTMLogin_Page;
import ltm_Utility.SeleniumUtility;
import ltm_Utility.Xls_Reader;

@Listeners(ltm_Utility.TestngListeners.class)
public class LTMLogin extends LTM_Baseclass {

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Launchbrowser();
	}

	//@Test(description = "Login Functionality")
	public void login() throws InterruptedException, IOException {

		SeleniumUtility selUtility = new SeleniumUtility();
		Xls_Reader ob1 = new Xls_Reader(Project_path + "\\Testdata\\LTMTestdata.xlsx");
		LTMLogin_Page loginpage = PageFactory.initElements(d, LTMLogin_Page.class);
		int lastrow = ob1.getRowCount("CD");
		System.out.println("Login Process start");
		for (int j = 0; j < lastrow; j++) 
		{
			loginpage.LTMUsername().sendKeys(ob1.getcelldatastring("CD", j, 0));
			loginpage.LTMPassword().sendKeys(ob1.getcelldatastring("CD", j, 1));
			loginpage.clickOnLoginButton();
			
			if(selUtility.isDisplayed(loginpage.lblFailureText()))
					{
						System.out.println("Login Failed");
						loginpage.LTMUsername().clear();
						loginpage.LTMPassword().clear();
						
					}
			else
			{
				if (selUtility.isDisplayed(loginpage.Lenovo_LTM_Logo()))
				{
					System.out.println("Logged in successfully");
					//test.log(LogStatus.PASS, "Test Pass");
					//Assert.assertTrue(true);
				}
				break;
			}
			
		}
		
	}
	@AfterMethod
	public void closesetup() throws IOException, InterruptedException {
		//report.endTest(test);
		//report.flush();
		d.close();

}

}


/*

if (selUtility.isDisplayed(loginpage.lblFailureText()) == true) {
System.out.println("Invalid username or password entered.");
loginpage.lblFailureText_closebutton().click();
loginpage.LTMUsername().clear();
loginpage.LTMPassword().clear();
}
else {
if (selUtility.isDisplayed(loginpage.Lenovo_LTM_Logo()) == true) {
	System.out.println("Logged in successfully");
	Assert.assertTrue(true);
}
break;

*/