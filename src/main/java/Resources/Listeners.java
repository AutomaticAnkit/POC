package Resources;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;



public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed");
		//SS Code
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("skipped");
	}
	






}
