package pageobejct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
	
public	Homepage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement txt_myAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement txt_register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement linklogin;

	
public	void clkAccount() {
		txt_myAccount.click();
	}
public void clkRegister() {
	txt_register.click();
}
public void clkLogin() {
	linklogin.click();
}


}
