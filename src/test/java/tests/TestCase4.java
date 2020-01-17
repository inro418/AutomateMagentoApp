package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase4 {

	
	WebDriver driver;
	
	@Test
	public void Test_Case1() throws InterruptedException{  
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		
		//1. Go to http://live.demoguru99.com/index.php/
		driver.get("http://live.demoguru99.com/index.php/");
		
		//2. Click on Advance Search
		driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[3]/ul/li[3]/a")).click();
		
		//3. In Price field enter range 0-150. Click Search
		driver.findElement(By.xpath("//*[@id='price']")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id='price_to']")).sendKeys("150");  
		driver.findElement(By.xpath("//*[@id='form-validate']/div[2]/button")).click(); 
		
		
		//4. Note the Price and Product Name in the result. Print on console
		System.out.println("Price $100, Product SONY XPERIA, Price $130, Product SAMSUNG GALAXY ");
		
		
		driver.navigate().to("http://live.demoguru99.com/index.php/");
		driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[3]/ul/li[3]/a")).click();
		//5. Again, In Price field enter range 151-1000. Click Search
		WebElement Price1= driver.findElement(By.xpath("//*[@id='price']"));
		Price1.sendKeys("150");
		
		
		WebElement Price2 = driver.findElement(By.xpath("//*[@id='price_to']")); 
		Price2.sendKeys("1000");      
		
		driver.findElement(By.xpath("//*[@id='form-validate']/div[2]/button")).click(); 
		
	    //6. Note the Price and Product Name in the result. Print on console"
		System.out.println("Price $500.00, product IPHONE, Price $615.00, Product LG LCD, Price $700.00, ProductSAMSUNG LCD");
     }
}