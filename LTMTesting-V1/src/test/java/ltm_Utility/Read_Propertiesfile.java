package ltm_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_Propertiesfile 
	{
		public Properties readproperties() throws IOException 
		{
			Properties prop = null;
			FileInputStream IP = null;
			try {
					IP = new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\datafile.properties");
					
					prop = new Properties();
					prop.load(IP);
				
				} 
			catch (FileNotFoundException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			return prop;
			
		}
			
		
	}


