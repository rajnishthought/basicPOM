import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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
	
	@Test (enabled = true)
	public void getTitle(){
		System.out.println(driver.getTitle());
	}
}
