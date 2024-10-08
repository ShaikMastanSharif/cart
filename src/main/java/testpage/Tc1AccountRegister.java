package testpage;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobejct.AccountDetails;

import pageobejct.Homepage;


public class Tc1AccountRegister extends Basetest {

 
	
	
	@Test(groups={"regression" ,"Master"})
public	void testLogin() {
		try {
		
		logger.info("***************** started accountregister");
		Homepage hp = new Homepage(driver);
		hp.clkAccount();
		logger.info("click is checked");
		hp.clkRegister();
		
		AccountDetails ac = new AccountDetails(driver);
		logger.info("accountdetails");
		ac.firstName(rondom().toUpperCase());
		ac.lastName(rondom().toUpperCase());
		ac.email(rondom()+"@gmail.com");
		ac.mobileNumber(rondomnum1());
		
		 String pwd=randompwd();
		
		ac.password(pwd);
		ac.cnfPassword(pwd);
		ac.policy();
		ac.continues();
		}
		catch(Exception e) {
			logger.error("test is failed");
			logger.debug("Debugs logs");
			Assert.fail();
			
		}
		
	}
	
	
}
