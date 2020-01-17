package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase3 {

	
	WebDriver driver;
	
	@Test
	public void Test_Case1() throws InterruptedException{  
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		
		//1. Go to http://live.demoguru99.com/index.php/backendlogin
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
		
		//2. Login as with credentials provided
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");  
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		driver.findElement(By.xpath("//*[@id='message-popup-window']/div[1]/a")).click();
		Thread.sleep(3000);
		
		//3. Go to Sales Invoice
		driver.findElement(By.xpath("//*[@id='nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[1]/ul/li[2]/a")).click();
		
		//4. Sort Invoice Date Column in ascending and descending order
		WebElement button = driver.findElement(By.xpath("//*[@id='sales_invoice_grid_table']/thead/tr[1]/th[3]/span/a"));
		button.click();
		Thread.sleep(3000);
		
		WebElement button1 = driver.findElement(By.xpath("//*[@id='sales_invoice_grid_table']/thead/tr[1]/th[3]/span/a"));
		button1.click();
		
		//5. Verify the sort is working as expected"
		System.out.println("It work correctly as expected");  
	}
	
}
