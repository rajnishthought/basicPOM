package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPageObjects extends TestBase {
	
	public EnterProductDataPageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="startdate")
	WebElement cal_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']")
	List<WebElement> chk_OptionProducts;
	
	@FindBy(id="nextselectpriceoption")
	WebElement btn_next;
	
	public void enterProductData() {
		cal_startdate.sendKeys("12/12/2021");
		cm.selectDropDownOption(dd_insurancesum, " 3.000.000,00");
		cm.selectDropDownOption(dd_damageinsurance, "No Coverage");
		cm.selectCheckBoxOption(chk_OptionProducts, "Euro Protection");
		btn_next.click();
	}
}
