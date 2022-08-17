package ltm_testcases;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.kg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import ltm_Utility.CreateDirectory;
import ltm_Utility.Read_Propertiesfile;

public class LTM_Baseclass 
{
	public static WebDriver d;
	
	Read_Propertiesfile P1 = new Read_Propertiesfile();
	
	String Project_path  = System.getProperty("user.dir");
	
	Logger log = Logger.getLogger("log4j==");
	
	@SuppressWarnings("deprecation")
	public void Launchbrowser() throws IOException, InterruptedException
		{
		System.out.println("Project Path is " + Project_path);	
		
		String browser = P1.readproperties().getProperty("Browser");
			
			if(browser.equals("Chrome"))
			{
				DesiredCapabilities cap= new DesiredCapabilities();
				
				cap.setAcceptInsecureCerts(true);
				 
//				System.setProperty("webdriver.chrome.driver", Project_path + "\\resources\\chromedriver.exe");

				WebDriverManager.chromedriver().setup();
				d = new ChromeDriver(cap);
			}	
			
			if(browser.equals("Mozilla"))
			{
				//System.setProperty("webdriver.gecko.driver", Project_path + "\\resources\\geckodriver.exe");
			
				WebDriverManager.firefoxdriver().setup();
				d = new FirefoxDriver();	
			}	
						
			d.manage().window().maximize();
			/*
			for(int i=0;i<2; i++)
			{
				System.out.println("aaaaa");
			d.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
			}
			*/
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			d.get(P1.readproperties().getProperty("LTMURL"));
			
			System.out.println("Test Execution start");
						
	}
	@BeforeSuite
	public void bf()
	{
		CreateDirectory F2 = new CreateDirectory();
		
		F2.CreateADirectory();
	}
	
}

