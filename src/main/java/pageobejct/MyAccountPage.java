package pageobejct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Basepage{
	 public MyAccountPage(WebDriver driver){
		super(driver);
	}
	 
	 @FindBy(xpath="//h2[normalize-space()='My Account']") WebElement mgsHeading;
	 @FindBy(xpath="//div[@class='list-group']//a[contains(.,'Logout')]") WebElement logout;
	 
	 public boolean isMyAccountPageExits() {
		 try {
		 return(mgsHeading.isDisplayed());
		 }
		 catch(Exception e) {
			 return false;
		 }
	 }
	 
	 public void clkLogout() {
		 logout.click();
	 }
}
