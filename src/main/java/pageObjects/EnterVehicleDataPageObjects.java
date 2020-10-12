package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {

	public EnterVehicleDataPageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "make")
	WebElement dd_make;

	@FindBy(id = "model")
	WebElement dd_model;

	@FindBy(id = "cylindercapacity")
	WebElement txt_cylindercapacity;

	@FindBy(id = "engineperformance")
	WebElement txt_engineperformance;

	@FindBy(id = "dateofmanufacture")
	WebElement cal_dateofmanufacture;

	@FindBy(id = "numberofseatsmotorcycle")
	WebElement dd_numberofseatsmotorcycle;

	@FindBy(id = "listprice")
	WebElement txt_listprice;

	@FindBy(id = "annualmileage")
	WebElement txt_annualmileage;

	@FindBy(id = "nextenterinsurantdata")
	WebElement btn_next;

	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement err_cylinderCapacity;

	public void enterCylinderCapacity(String cylinderCap) {
		txt_cylindercapacity.sendKeys(cylinderCap);
	}

	public String getCapacityErrorMessage() {
		return err_cylinderCapacity.getText();
	}

	public List<String> getDropDownOptions() {

		Select select = new Select(dd_model);
		List<WebElement> listelements = select.getOptions();
		List<String> actualList = new ArrayList<String>();

		for (WebElement webElement : listelements) {
			String eleText = webElement.getText();
			actualList.add(eleText);
		}
		return actualList;
	}
	
	public void clickOnNext() {
		btn_next.click();
	}
	
	public void enterVehicleDataTest() {
		homepage.clickOnMotorCycleLink();
		cm.selectDropDownOption(dd_make, "Volkswagen");
		cm.selectDropDownOption(dd_model, "Scooter");
		txt_cylindercapacity.sendKeys("2000");
		txt_engineperformance.sendKeys("1500");
		cal_dateofmanufacture.sendKeys("12/12/2012");
		cm.selectDropDownOption(dd_numberofseatsmotorcycle, "3");
		txt_listprice.sendKeys("1000");
		txt_annualmileage.sendKeys("1000");
		clickOnNext();
	}
}
