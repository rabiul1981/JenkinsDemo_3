package Utilities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
 
  
String ud=System.getProperty("user.dir");
	
	public WebDriver driver;
	
	@Parameters({"browserName","WebsiteUrl"})
	
	
	@BeforeMethod
  public void beforeMethod(String browser, String url) throws InterruptedException {
	  
		Ibrowsers(browser,url);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
  
  public void Ibrowsers(String nameOfBrowser, String url) throws InterruptedException {
		
	   
	  if (nameOfBrowser.equalsIgnoreCase("chrome")) {
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(url);
		  Thread.sleep(3000);
		  }
	  
	  else if (nameOfBrowser.equalsIgnoreCase("edge")) { 
					
			
			System.setProperty("webdriver.edge.driver", ud+"\\msedgedriver.exe");
			driver = new EdgeDriver();
			Thread.sleep(3000);
			driver.manage().window().maximize();
			driver.get(url);
			
		}
		
		else if (nameOfBrowser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", ud+"\\geckodriver.exe");
			driver = new FirefoxDriver();
			Thread.sleep(3000);
			driver.manage().window().maximize();
			driver.get(url);
			
		}
	  
	  
	  else {
		  System.out.println("No Browser Driver Found");
	  }
	  
  }
  

}
