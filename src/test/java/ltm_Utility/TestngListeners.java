package ltm_Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners implements ITestListener 
{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Is started"+ result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase Passed is :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	/*
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}
*/
}
