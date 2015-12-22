package yahoo;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
class Home 
{
	Logger l=Logger.getLogger("log");
	{
		System.setProperty("atu.reporter.config", "E:\\nov_15_10\\myproj\\atu.properties");
	}
    WebDriver driver;
    
    public Home(WebDriver driver)
    {
    	this.driver=driver;
    }
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
	}
	public void login() throws Exception
	{
		open();
		l.debug("before login into yahoo");
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
	}
	public void createacc() throws Exception
	{
		open();
		l.debug("before create a new account");
		Thread.sleep(5000);
		driver.findElement(By.id("login-signup")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("first-name")).sendKeys("abcd");
		driver.findElement(By.id("last-name")).sendKeys("xyza");
		
		
		
		driver.findElement(By.xpath("//span[@class='country-code-arrow']")).click();
		driver.findElement(By.xpath("//a[@data-code='91']")).click();
		driver.findElement(By.id("mobile")).sendKeys("8989898989");
			
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("June");
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1984");
		
		new Actions(driver).moveToElement(driver.findElement(By.id("male"))).click().perform();	
	}
	public void validatelinks() throws Exception
	{
	  open();
	  l.debug("before validating links in home page");
	  Thread.sleep(5000);
	  String arr[]={"About Mail","Features","Get App","Help"};	
	  WebElement w=driver.findElement(By.xpath("//ul[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
	  List<WebElement> lst=w.findElements(By.tagName("a"));
	  for(int i=0;i<arr.length;i++)
	  {
		  if(arr[i]==lst.get(i).getText())
		  {
			  ATUReports.add("Link is matching",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
		  }
		  else
		  {
			  ATUReports.add("Link is not matching",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
		  }
	  }	  
	}
	
	
	
	
}
