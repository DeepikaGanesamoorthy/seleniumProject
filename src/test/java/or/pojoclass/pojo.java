package or.pojoclass;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pojo extends BaseClass {
	  public pojo() {
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath = "(//input[@autocomplete='off'])[2]")
   private WebElement email;
   @FindBy(xpath = "//button[text()='Request OTP']")
   private WebElement login;
public WebElement getEmail() {
	return email;
}
public WebElement getLogin() {
	return login;
}
}
