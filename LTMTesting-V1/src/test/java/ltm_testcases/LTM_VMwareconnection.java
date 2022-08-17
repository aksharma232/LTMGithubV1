package ltm_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ltm_Pages.LTM_Connectionpage;
import ltm_Pages.LTM_Patchupgrade;
import ltm_Pages.LTM_RHS_Page;

public class LTM_VMwareconnection extends LTM_Baseclass 
{

	LTMLogin ltmlogin;
	LTM_RHS_Page ltmrhs;
	LTM_Patchupgrade Patchupgrade;
	LTM_Connectionpage Connectionpage;
	LTM_LHSOptions LHS; 
		
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		Launchbrowser();
		log.info("launching chrome broswer");
		ltmlogin = new LTMLogin();
		ltmlogin.login();
		
	}

	@Test
	public void VMwareconnection()
	{
		
	}
}
