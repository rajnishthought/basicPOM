package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import reuseableComponents.ExtentSetup;

public class LintenerImplementation extends ObjectsRepo implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case -" + result.getMethod().getMethodName() + " is passed.");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case -" + result.getMethod().getMethodName() + " is failed.");
		test.log(Status.FAIL, result.getThrowable());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + actualDate + ".jpeg";
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(screenshotPath,"Test case failuew screenshot!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		// setup here!
		extent = ExtentSetup.setupExtentReport();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
