package roughwork;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.annotations.Test;
 
import org.testng.annotations.AfterMethod;
 
public class Rough_Testng {
 
	public WebDriver driver;
 
  @Test
 
  public void main() throws InterruptedException {

      System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		driver = new FirefoxDriver(); 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	      //Launch the Online Store Website
	 
	      driver.get("https://www.freecrm.com/");
 
	   driver.findElement(By.name("username")).sendKeys("naveenk");			
		driver.findElement(By.name("password")).sendKeys("test@123");		
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(500);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();	
	    System.out.println("hello");
	    Thread.sleep(300);
	    try {
	    boolean value = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")).isDisplayed();
	    System.out.println(value);
	    driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")).click();
	    }
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	e.printStackTrace();
	    }
  }
 
  
  @AfterMethod
 
  public void afterMethod() {
 
	  // Close the driver
 
   //   driver.quit();
 
  }
 
}