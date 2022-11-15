package ltm_Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ltm_testcases.LTM_Baseclass;

public class SeleniumUtility extends LTM_Baseclass {

	public boolean isDisplayed(WebElement web) throws InterruptedException {
		
		boolean display = false;
		
		try {
				@SuppressWarnings("deprecation")
				WebDriverWait wait = new WebDriverWait(d, 30);
				System.out.println("Inside try");
				wait.until(ExpectedConditions.visibilityOfAllElements(web));
				display = true;
			} 
		
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		
		System.out.println("WebElement displayed"+ display);
		
		return display;
	}
	

	public boolean isClickable(WebElement web) {
		boolean isClickable = false;

		try {
			WebDriverWait wait = new WebDriverWait(d, 30);
			wait.until(ExpectedConditions.elementToBeClickable(web));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return isClickable;

	}

}
