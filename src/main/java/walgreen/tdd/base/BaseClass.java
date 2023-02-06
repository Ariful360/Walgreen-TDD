package walgreen.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import static walgreen.tdd.utils.IConstant.*;
import walgreen.tdd.utils.ReadProperties;

public class BaseClass {
	WebDriver driver;
	ReadProperties envVar;

	@BeforeSuite
	public void setUpSuite() {
		envVar = new ReadProperties();

	}

	@BeforeMethod
	public void setUpDriver() {
		String browser = envVar.getProperty(BROWSER);
		String url = envVar.getProperty(URL);
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		
		initDriver(browser);
		driver.get(url);
				
	}
	
	private void initDriver(String driverName) {
		switch (driverName) {
		
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;

		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		
	}

}
