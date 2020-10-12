package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObjects extends TestBase {

	public HomePageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Navigation Motorcycle")
	WebElement link_motorcycle;

	public void clickOnMotorCycleLink() {
		link_motorcycle.click();
	}
}
