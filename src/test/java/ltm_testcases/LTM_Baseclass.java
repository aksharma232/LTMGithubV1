package ltm_testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

//import java.time.Duration;
//import java.util.Arrays;
//import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import ltm_Utility.CreateDirectory;
import ltm_Utility.Read_Propertiesfile;

public class LTM_Baseclass {
	
	public static WebDriver d;
	String Project_path = System.getProperty("user.dir");
	Read_Propertiesfile P1 = new Read_Propertiesfile();
	Logger log = Logger.getLogger("log4j==");
	
	static ExtentTest test;
	static ExtentReports report;	
	ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Spark.html");

//Above code is for selecting the driver --
	
		public void Launchbrowser() throws IOException, InterruptedException {
		System.out.println("Project Path is " + Project_path);
		String browser = P1.readproperties().getProperty("Browser");
		
		spark.config().setDocumentTitle("LTM Automation Report"); //Title of the report
		spark.config().setReportName("LTM Test Report");
		spark.config().setTheme(Theme.DARK);

		
		if (browser.equals("Chrome")) {
			//DesiredCapabilities cap = new DesiredCapabilities();
			ChromeOptions options= new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver(options);
		}

		if (browser.equals("Mozilla")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get(P1.readproperties().getProperty("LTMURL"));
		System.out.println("Test Execution start");
		//test.log(LogStatus.PASS, "Navigated to the specified URL");
		
	}

	@BeforeSuite
	public void bf() {
		CreateDirectory F2 = new CreateDirectory();
		F2.CreateADirectory();
	}

}
