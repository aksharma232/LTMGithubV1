package ltm_Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import ltm_testcases.LTM_Baseclass;

public class CreateDirectory {

	String Screenshotlocation = System.getProperty("user.dir")+ "\\Screenshots\\";
	
	//File dir1 = new File(Screenshotlocation + "LTMTest"+"-"+timestamp());
	
	File dir1 = new File((Screenshotlocation)+timestamp());
	
	//File dir1 = new File(Screenshotlocation);

  @Test
	public void CreateADirectory()
    {
	
	  System.out.println(Screenshotlocation);
	  dir1.mkdir();
    }

   public String timestamp()
	{
	        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

   public  File getLastModified()
   {
	   File dir = new File(Screenshotlocation);
	    File max = null;
	    for (File file : dir.listFiles()) {
	        if (file.isDirectory() && (max == null || max.lastModified() < file.lastModified())) 
	        {
	            max = file;
	           
	        }
	   	        
	    }
		return max;  
	    
   }

}