package yahoo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Compose 
{
	Logger l=Logger.getLogger("log");
	{
		System.setProperty("atu.reporter.config", "E:\\nov_15_10\\myproj\\atu.properties");
	}
	
    WebDriver driver;
    
    public Compose(WebDriver driver)
    {
    	this.driver=driver;
    }
	public void sendmail() throws Exception
	{
		System.out.println("testing");
		System.out.println("hello");
		l.debug("before sending a new mail");
		driver.findElement(By.xpath("//input[@class='composeicon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("to")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("Subj")).sendKeys("hello");
		driver.findElement(By.name("Content")).sendKeys("this is sample data");
		driver.findElement(By.id("send_top")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("inbox_back")).click();
		Thread.sleep(2000);
	}
	public void signout()
	{
		l.debug("before signout");
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
