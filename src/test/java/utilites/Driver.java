package utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;


public class Driver {

	/* Driver class is reusable class for webDriver and it checks the webDriver on the system.
	 * If there isn't any driver on the system, it downloads the driver and sets up the path and environment  
	 * For this purpose, I've used WebDriver manager
	 * And if I want to run my script on different browser, 
	 * all I have to do is change the browser name in the properties file.
	 */
	
	private static WebDriver driver;
	public static WebDriver getDriver() {
		
		
//			System.setProperty("webdriver.chrome.driver", 
//					"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
			if (driver == null) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			return driver;
		}
		
		public static void quitDriver() {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		}
	}

