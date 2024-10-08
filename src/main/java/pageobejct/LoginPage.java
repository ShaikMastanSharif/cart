package pageobejct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {
	public LoginPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_emailAddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_loginPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	 public void emailAddress(String email) {
		 txt_emailAddress.sendKeys(email);
	}
	 public void emailPassword(String pwd) {
		 txt_loginPassword.sendKeys(pwd);
	 }
	 public void emailLogin() {
		 btn_login.click();
	 }
}
