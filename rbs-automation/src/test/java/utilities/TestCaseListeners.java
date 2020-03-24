package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.annotations.Test;


//Listener is an interface
public class TestCaseListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("The name of the test case is passed " + result.getName());
	}

	//This method is called when test is failed
	
	
	public void onTestFailure(ITestResult result) {

		System.out.println("The name of test case is failed" + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {

    System.out.println("The name of the test case skipped " + result.getName());
		
	}


	public void onStart(ITestContext context) {


		System.out.println("The name of the test case started" + context.getName());
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}