package testpage;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobejct.Homepage;
import pageobejct.LoginPage;
import pageobejct.MyAccountPage;

public class Tc002_AccountLoginTest extends Basetest {
	@Test(groups={"Sanity" , "Master"})
	public void verify_login() {
		logger.info("*****starting Tc002_AcountLoginPage");
		
		try {
		
		Homepage hp = new Homepage(driver);
		
		hp.clkAccount();
		hp.clkLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.emailAddress(p.getProperty("email"));
		lp.emailPassword(p.getProperty("password"));
		lp.emailLogin();
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean targetPage=ma.isMyAccountPageExits();
		Assert.assertTrue(targetPage);
		}catch(Exception e) {
			
			Assert.fail();
			
		}
		logger.info("********** testing of Tc002 is Completed");
	}
}
