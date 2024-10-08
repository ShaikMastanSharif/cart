
package testpage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobejct.Homepage;
import pageobejct.LoginPage;
import pageobejct.MyAccountPage;
import utilites.DataProviders;

   public class Tc003datadrivertest extends Basetest{
	   
	   
	   @Test(dataProvider= "logindata" ,dataProviderClass=DataProviders.class,groups="Datadriven")
		public void verify_Login(String email,String password,String exp)
	   { 
		   try {
		   logger.info("********staring tc003");
		
		   Homepage hp = new Homepage(driver);
		   hp.clkAccount();
		   hp.clkLogin();
		   
		   LoginPage lp = new LoginPage(driver);
		   lp.emailAddress(email);
		   lp.emailPassword(password);
		   lp.emailLogin();
		   
		   
		   MyAccountPage ma = new MyAccountPage(driver);
	        boolean targetpage=ma.isMyAccountPageExits();
	        if(exp.equalsIgnoreCase("valid")) {
	        	if(targetpage==true) {
	        		ma.clkLogout();
	        		Assert.assertTrue(true);
	        	
	        	}else {
	        		Assert.assertTrue(false);
	        		
	        	}
	        }
	        if(exp.equalsIgnoreCase("invalid")) {
	        	if(targetpage==true) {
	        		ma.clkLogout();
	        		Assert.assertTrue(false);
	        	}else {
	        		Assert.assertTrue(true);
	        	}
	        }
	   }catch(Exception e) {
		   Assert.fail();
	   }
		   logger.info("**********ending the tc003");
	
	   }
	
	
}
