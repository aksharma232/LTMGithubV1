package ltm_Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class LTM_Screenshot {

	public void LTM_Takescreeshot(String Screenshotname, WebDriver d) throws Exception {

		SeleniumUtility util = new SeleniumUtility();

		CreateDirectory F2 = new CreateDirectory();

		System.out.println("Inside Screenshot2");

		File latestfolder = F2.getLastModified();

		System.out.println("Inside Screenshot3");

		String Path = latestfolder.getAbsolutePath();

		String Path1 = Path + "\\";

		System.out.println(latestfolder);

		if (util.isDisplayed(d.findElement(By.id("taskActivityM_btnCancelAllTask")))) {
			TakesScreenshot scrShot = ((TakesScreenshot) d);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File dest = new File(Path1 + Screenshotname + timestamp() + ".png");
			FileUtils.copyFile(SrcFile, dest);
			System.out.println("Screenshot done");
		}
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}