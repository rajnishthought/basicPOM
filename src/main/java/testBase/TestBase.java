package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsuranceDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import reuseableComponents.PropertiesOperations;

public class TestBase extends ObjectsRepo {

	public static void launchBrowserAndNavigate() throws Exception {

		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		launchBrowserAndNavigate();
		homepage = new HomePageObjects();
		vehData = new EnterVehicleDataPageObjects();
		insurDataPO = new EnterInsuranceDataPageObjects();
		prodPO = new EnterProductDataPageObjects();
	}

	@AfterMethod()
	public void tearDown() {
		// driver.close();
	}
}
