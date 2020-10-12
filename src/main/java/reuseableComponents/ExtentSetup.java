package reuseableComponents;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectsRepo;

public class ExtentSetup extends ObjectsRepo {

	public static ExtentReports setupExtentReport() {

		String reportPath = System.getProperty("user.dir");
		File reporterPath = new File(reportPath + "//Reports//extentreport.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reporterPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);

		sparkreporter.config().setDocumentTitle("document Title");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Report Name");

		return extent;
	}

}
