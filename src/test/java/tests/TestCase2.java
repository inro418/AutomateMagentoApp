package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;    

public class TestCase2 {

	WebDriver driver;
	
	@Test
	public void Test_Case1() throws InterruptedException{  
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
		
		//1. Go to http://live.demoguru99.com/.
		driver.get("http://live.demoguru99.com/");
		
		//2. Go To Link - http://live.demoguru99.com/index.php/review/product/list/id/1/
		driver.navigate().to("http://live.demoguru99.com/index.php/review/product/list/id/1/");
		
		//3. Fill the required review and submit it
		driver.findElement(By.xpath("//*[@id='review_field']")).sendKeys("I enjoy the lecture");  
		driver.findElement(By.xpath("//*[@id='summary_field']")).sendKeys("Guru99.com is good teacher");
		driver.findElement(By.xpath("//*[@id='nickname_field']")).sendKeys("Charly Boy");
		driver.findElement(By.xpath("//*[@id='review-form']/div[2]/button")).click(); 
		
		Thread.sleep(3000);    
		
		//4.Go to http://live.demoguru99.com/index.php/backendlogin
		driver.navigate().to("http://live.demoguru99.com/index.php/backendlogin"); 
		
		//5.Login as with credentials provided
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");  
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		driver.findElement(By.xpath("//*[@id='message-popup-window']/div[1]/a")).click();
		
		 //6. Go to Catalogue -> Reviews and Ratings -> Customer Reviews ->Pending Reviews Menu
		driver.findElement(By.xpath("//*[@id='nav']/li[2]")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li/a/span")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li/ul/li[1]/ul/li[1]/a/span")).click();
		Thread.sleep(3000); 
		
		 //7.Sort table by Id and select comment then click on Edit link
		driver.findElement(By.xpath("//*[@id='reviwGrid_table']/tbody/tr[1]/td[1]/input")).click(); 
		driver.findElement(By.xpath("//*[@id='reviwGrid_table']/tbody/tr[1]/td[10]/a")).click();
		
		//8.Change status to 'Approved' and click ""Save Review""
		WebElement DropDown = driver.findElement(By.xpath("//*[@id='status_id']"));      
		Select select = new Select(DropDown);
		select.selectByVisibleText("Approved"); 
		driver.findElement(By.xpath("//*[@id='save_button']")).click(); 
		Thread.sleep(5000);
		
		//9.Go to http://live.demoguru99.com/. Click Mobile Menu
		driver.navigate().to("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]")).click();
		
		
		//10. Click on Sony Xperia image.
		driver.findElement(By.xpath("//*[@id='product-collection-image-1']")).click();
		
		
		//11. In detail page click on Review tab at bottom of page
		driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]")).click(); 
		
		//12. Verify the review comment is shown"
		//Verify and confirmed - I enjoy the lecture
	}
}
