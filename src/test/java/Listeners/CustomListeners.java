package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import Utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext context) {

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {

			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		rep.endTest(test);
		rep.flush();
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ")img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
		Reporter.log("Login Successfully not executed");

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestStart(ITestResult arg0) {

		test = rep.startTest(arg0.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult arg0) {

		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " Pass");
		rep.endTest(test);
		rep.flush();

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ")img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");

		Reporter.log("Login Successfully not executed");

	}

}
