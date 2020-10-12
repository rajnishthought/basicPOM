package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import reuseableComponents.CommonMethods;

public class ObjectsRepo {

	public static WebDriver driver;
	public static HomePageObjects homepage;
	public static EnterVehicleDataPageObjects vehData;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static EnterInsuranceDataPageObjects insurDataPO;
	public static EnterProductDataPageObjects prodPO;
	
	public static CommonMethods cm = new CommonMethods();
}
