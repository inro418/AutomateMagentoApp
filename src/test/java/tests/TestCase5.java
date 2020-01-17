package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase5 {

	WebDriver driver;
	
	@Test
	public void Test_Case5() throws InterruptedException {  

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
		Thread.sleep(3000);   
		
		//3. Go to Customers-> Manage Customers menu
		driver.findElement(By.xpath("//*[@id='nav']/li[3]")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[3]/ul/li/a")).click();
		
		//4. Open any customer's detail by clicking on view link in the grid
		WebElement DropDowngrid = driver.findElement(By.xpath("//*[@id='customerGrid']/table/tbody/tr/td[1]/select"));
		Select select = new Select(DropDowngrid);
		select.selectByVisibleText("50");  
		
		//5. Click on 'Account Information' tab for the customer's detail page
		driver.findElement(By.xpath("")).click();  //Need help table-tbody-tr-td
		
		Thread.sleep(3000);                  
		
		//6. Verify disabled fields       
		driver.findElement(By.xpath("")).click(); 
		
		//7. Verify Blank fields    
    }

}
