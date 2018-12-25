package roughwork;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewContact {
	
	WebDriver driver;

	@Given("^user is already on home page$")
	public void user_is_already_on_home_page()  {
		
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		driver = new ChromeDriver();
    	driver.get("https://www.freecrm.com");	
    	driver.findElement(By.name("username")).sendKeys("naveenk"); 
		driver.findElement(By.name("password")).sendKeys("test@123");
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		((RemoteWebDriver) js).executeScript("arguments[0].click();",loginbtn);
	  
	}

	@When("^user mouse over on contacts link$")
	public void user_mouse_over_on_contacts_link()  {
		
		
		int ifrsz = driver.findElements(By.tagName("iframe")).size();
		 System.out.println("THE TOTAL NUMBER OF IFRAMES ARE ::" + ifrsz);
		 
		 driver.findElement(By.linkText("Contacts")).click();
	
		 System.out.println("SUCCESSFULLY" );
		    driver.findElement(By.linkText("Contacts")).click();
		    driver.findElement(By.linkText("New Contact")).click();
		    driver.findElement(By.linkText("Logout")).click();
		
	 driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/a")).click();
		 
	}

	@Then("^user clicks on New Contact Link$")
	public void user_clicks_on_New_Contact_Link() {
		
	driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/ul/li[1]")).click();
	  
	}

	@Then("^user enters firstname and lastname$")
	public void user_enters_firstname_and_lastname()  {
		
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("raj"); 
		driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys("varma"); 
		
	    
	}

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button()  {
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[2]")).click();
	    
	}

	@Then("^verify new contact created$")
	public void verify_new_contact_created() {
		
		String title = driver.getTitle();
		System.out.println("Contact Created ::"+ title);
		Assert.assertEquals("raj varma", title);
		
		System.out.println("Contact Created 1::"+ title);
		System.out.println("Contact Created 2::"+ title);
		System.out.println("Contact Created 3::"+ title);
		System.out.println("Contact Created 4::"+ title);
		System.out.println("Contact Created 5::"+ title);
		System.out.println("Contact Created 6::"+ title);
		System.out.println("Contact Created 7::"+ title);
		System.out.println("Contact Created 8::"+ title);
		System.out.println("Contact Created 9::"+ title);
		
	}	
	
	
}
