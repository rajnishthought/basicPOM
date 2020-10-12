package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsuranceDataPageObjects extends TestBase {
	
	public EnterInsuranceDataPageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement txt_firstName;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(id="birthdate")
	WebElement cal_birthdate;
	
	//Gender Selection
	@FindBy(xpath="//input[@name='Gender']")
	List<WebElement> rdo_gender;
	
	@FindBy(id="streetaddress")
	WebElement txt_streetaddress;
	
	@FindBy(id="country")
	WebElement dd_country;
	
	@FindBy(id="zipcode")
	WebElement txt_zipElement;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="occupation")
	WebElement txt_occupation;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_next;
	
	//Hobbies Selection
	@FindBy(xpath="//input[@name='Hobbies']")
	List<WebElement> chk_hobbies;
	
	public void clickOnNext() {
		btn_next.click();
	}
	
	public void enterInsuranceData() {
		txt_firstName.sendKeys("Rajnish");
		txt_lastname.sendKeys("kumar");
		cal_birthdate.sendKeys("12/12/2012");
		txt_streetaddress.sendKeys("K1507,Arihant Arden");
		cm.selectDropDownOption(dd_country, "India");
		txt_zipElement.sendKeys("123456");
		txt_city.sendKeys("Noida");
		txt_occupation.sendKeys("SDET");
		cm.selectCheckBoxOption(chk_hobbies, "Speeding,Other");
		btn_next.click();
	}
}
