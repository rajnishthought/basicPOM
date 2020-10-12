package testCases;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterVehicleDataPageObjects;
import testBase.TestBase;

public class EndToEndTestCase extends TestBase {

	@Test(enabled = false)
	public void insuranceCalculate_VolvoMotoro() {
	
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://sampleapp.tricentis.com/101/index.php");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test (enabled = false)
	public void getTitle(){
		System.out.println(driver.getTitle());
	}
	
	@Test(enabled = false)
	public void verifyDropDownOptionsList() {
		homepage.clickOnMotorCycleLink();
		
		List<String>actual_DropDownOptionsList = vehData.getDropDownOptions();
		test.log(Status.INFO, "Actual dropdown value is: "+actual_DropDownOptionsList);
		
		List<String>expected_DropDownOptionsList = Arrays.asList("– please select –","Scooters","Three-Wheeler","Moped","Motorcycle");
		test.log(Status.INFO, "Expected Status is:" +expected_DropDownOptionsList);
		
		Assert.assertEquals(actual_DropDownOptionsList, expected_DropDownOptionsList);
	}
	
	@Test(enabled = true)
	public void verifyEnterVehicleDataTest() {
		vehData.enterVehicleDataTest();
		insurDataPO.enterInsuranceData();
		prodPO.enterProductData();
	}
}
