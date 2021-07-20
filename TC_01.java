package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01 {
	
	@Test
	public void login_test() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ahrms.acurussolutions.com:2047/AHRMS/pages/forms/Mainlogin.php");
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("910");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("4022");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(4000);
		String text=driver.findElement(By.xpath("//a[contains(text(),'Manager')]")).getText();
		
		try {
			Assert.assertEquals(text,"Manager");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
		
	}

}
