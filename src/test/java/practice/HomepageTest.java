package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTest {

WebDriver driver;
	
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.walgreens.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void homepageTesting() {
		WebElement account = driver.findElement(By.xpath("//strong[text()='Account']"));
		account.click();
	}

	
	
	
	
	
	
	public void tearUp() {
		driver.quit();
	}
}
