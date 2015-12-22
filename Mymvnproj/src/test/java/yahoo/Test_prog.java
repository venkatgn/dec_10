package yahoo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Test_prog 
{
	Logger l=Logger.getLogger("log");
	
	{
		System.setProperty("atu.reporter.config", "E:\\nov_15_10\\myproj\\atu.properties");
	}
    WebDriver driver;
	@Test
	@Parameters({"browser"})
	public void testing(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			l.debug("=======Creating obj for Firefox=========");
			driver=new FirefoxDriver();
		}
		if(br.matches("chrome"))
		{
			l.debug("============create obj for chrome==========");
			System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		Home h=new Home(driver);
		h.validatelinks();
		h.createacc();
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();
		
		
	}
}
