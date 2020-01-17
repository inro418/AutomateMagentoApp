package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase1 {

	WebDriver driver;

	@Test
	public void Test_Case1() throws InterruptedException {  

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// 1. Go to http://live.demoguru99.com/index.php/backendlogin/
		driver.get("http://live.demoguru99.com/index.php/backendlogin/");

		// 2. Login the credentials provided  
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@id='message-popup-window']/div[1]/a")).click();

		// 3. Go to Sales > Order menu
		driver.findElement(By.xpath("//*[@id='nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[1]/ul/li[1]/a")).click();
		Thread.sleep(5000);

		// 4.In the status field select "Cancel". Click Search
		WebElement DropDown = driver.findElement(By.xpath("//select[@ id = 'sales_order_grid_massaction-select']"));      
		Select select = new Select(DropDown);
		select.selectByVisibleText("Cancel"); 
		driver.findElement(By.xpath("//button[@title='Search']")).click(); 
		Thread.sleep(5000);
		
		// 5.Select the checkbox next to first order 
		driver.findElement(By.xpath("//*[@id='sales_order_grid_table']/tbody/tr[1]/td[1]/input")).click(); 
	
		
		// 6.In Actions, select ""Print Invoices"". Click Submit    
		driver.findElement(By.xpath("//select[@id='sales_order_grid_massaction-select']"));  
		Select select1 = new Select(DropDown);
		select1.selectByVisibleText("Print Invoices");  
		driver.findElement(By.xpath("//*[@id='id_eba3918cc43d11df3b6e701fb4d2d9c0']")).click();   
		Thread.sleep(5000);
		
		
		// 7.Verify the error message
		// stale element reference: element is not attached to the page document
		
		// 8.In the status field select ""Complete"". Click Search
		driver.findElement(By.xpath("//*[@id='sales_order_grid_filter_status']")); 
		Select select2 = new Select(DropDown);
		select2.selectByVisibleText("complete");  
		driver.findElement(By.xpath("//*[@id='id_d5f1d751353605a624d6224fd806e0b4']")).click();   
		Thread.sleep(5000);
		
		// 9.Select the checkbox next to first order
		driver.findElement(By.xpath("//*[@id='sales_order_grid_table']/tbody/tr[1]/td[1]/input")).click();
		Thread.sleep(5000);
		
		// 10.In Actions, select ""Print Invoices"". Click Submit
		driver.findElement(By.xpath("//*[@id='sales_order_grid_massaction-select']")); 
		Select select3 = new Select(DropDown);
		select3.selectByVisibleText("Print Invoices");   
		driver.findElement(By.xpath("//*[@id='id_54b9dca5a9e2b6417935c842f048b83e']")).click(); 
	
		// 11. Verify invoice is download
	}
}
