package testpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import bsh.Capabilities;
import screenshot.TakeScreenShot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Basetest {
public static	WebDriver driver;
public Properties p;
public  Logger logger;
	@BeforeClass(groups= {"Sanity","regression" ,"Master","Datadriven"})
	@Parameters({"os" ,"browser"})
	public	void setup(String os ,String br) throws IOException {
		
	
	FileReader file = new FileReader("./src//test//resources//config.properties");
	p= new Properties();
	p.load(file);
	
	
	logger= LogManager.getLogger(this.getClass());
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//remote
	
	if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		if(os.equalsIgnoreCase("windows10")) {
			capabilities.setPlatform(Platform.WIN10);
			
		}
		else if (os.equalsIgnoreCase("mac")) {
			capabilities.setPlatform(Platform.MAC);
			
		}
		else
		{
			System.out.println("no matching platform");
		}
		
		
	
	switch(br.toLowerCase()) {
	case "chrome":capabilities.setBrowserName("chrome");break;
	case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
	default:System.out.println("no matchinh browser");return;
	}
	driver = new RemoteWebDriver(new URL("http://192.168.236.189:4444/wd/hub"),capabilities);
	}
	
	//local
	if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge": driver = new EdgeDriver();break;
		default:System.out.println("no matching browser");return;
		}
	}
	
	
	
	
		
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(p.getProperty("appURL"));//reading url from propertiesfiles confing 
			driver.manage().window().maximize();
		}
	@AfterClass(groups= {"Sanity","regression","Master"})
	public void testdear() {
		driver.quit();
	}
	
	public  String rondom() {
		String random1=RandomStringUtils.randomAlphabetic(10);
		return random1;
	}
	public String rondomnum1() {
		String randomnum=RandomStringUtils.randomNumeric(10);
		return randomnum;
	}
	public String randompwd() {
		String random1=RandomStringUtils.randomAlphabetic(10);
		String randomnum=RandomStringUtils.randomNumeric(10);
		return (random1+randomnum);
	}
	public String captureScreen(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakeScreenShot ts = (TakeScreenShot)driver;
	 File sourceFile = ts.getScreenShot(OutputType.FILE);
	 
	 String targetFilePath=System.getProperty("user.dir")+"\\screenshot"+tname + "_"+ timestamp + "png";
File targetFile=	new File(targetFilePath);
	 sourceFile.renameTo(targetFile);
	 return targetFilePath;
	}
}
