package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

//import utils.ScreenshotUtil;
import testHerokuapp.testmainpage;

public class ScreenshotListener implements ITestListener {

	   @Override
	    public void onTestFailure(ITestResult result) {
	        testmainpage test = (testmainpage) result.getInstance();
	        ScreenshotUtil.takeScreenshot(test.driver, result.getName() + "_FAILED");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        testmainpage test = (testmainpage) result.getInstance();
	        ScreenshotUtil.takeScreenshot(test.driver, result.getName() + "_PASSED");
	    }
	}