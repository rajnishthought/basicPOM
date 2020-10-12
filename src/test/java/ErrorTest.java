import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ErrorTest extends TestBase {

	@Test
	public void errorMessageTest() {
		homepage.clickOnMotorCycleLink();
		vehData.enterCylinderCapacity("3000");
		String actualErrorMessage = vehData.getCapacityErrorMessage();
		
		Assert.assertEquals(actualErrorMessage, "Must be a number between 1 and 2000");
	}
}
