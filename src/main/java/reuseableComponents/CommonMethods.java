package reuseableComponents;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public void selectDropDownOption(WebElement element, String valueToBeSelected) {
		Select select = new Select(element);
		select.selectByVisibleText(valueToBeSelected);
	}

	public void selectRadioOption(List<WebElement> element, String valueToBeSelected) {
		for (WebElement ele : element) {
			if (ele.getText().equalsIgnoreCase(valueToBeSelected)) {
				ele.click();
				break;
			}
		}
	}

	public void selectCheckBoxOption(List<WebElement> element, String checks) {
		
		String[] checksarray = checks.split(",");
		for (String webElement : checksarray) {
			for (WebElement ele : element) {
				if(ele.getText().equalsIgnoreCase(webElement)) {
					ele.click();
					break;
				}
			}
		}
	}
}
