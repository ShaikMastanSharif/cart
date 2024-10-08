package pageobejct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountDetails extends Basepage {
	public AccountDetails(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastName;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_cnfpwd;
	
	@FindBy(xpath="//input[@name='agree']") WebElement chk_policy;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement bnt_continue;
	
	
	 public void firstName(String name){
		txt_firstName.sendKeys(name);
	}
	 public void lastName(String lname) {
		 txt_lastName.sendKeys(lname);
	 }
	 public void email(String mail) {
		 txt_email.sendKeys(mail);
	 }
	 public void mobileNumber(String num) {
		 telephone.sendKeys(num);
	 }
	 public void password(String pwd) {
		 txt_pwd.sendKeys(pwd);
	 }
	 public void cnfPassword(String cpwd) {
		 txt_cnfpwd.sendKeys(cpwd);
	 }
	 public void policy() {
		chk_policy.click();
	 }
	 public void continues() {
		// bnt_continue.click();
		 
		Actions act = new Actions(driver);
		act.moveToElement(bnt_continue).click().perform();
		 
	 }
}
