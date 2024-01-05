package newalgoutilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	//@BeforeTest
	public BaseClass () {
		try {
			prop = new Properties(); 
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Configuration_files/config.properties");
			
			
			prop.load(ip);
			System.out.println("driver:" + driver);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void launchApp() {
		
		//WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		System.out.println("browserName: " + browserName);
		
		if (browserName == "" || browserName == null || browserName.isEmpty())
		{
			System.out.println("browserName: Empty");			
		}
		else 
		{
			if(browserName.contains("chrome")) {
				
			       driver = new ChromeDriver();
			       
				}else if (browserName.contains("FireFox")) {
					WebDriverManager.firefoxdriver().setup();
					 //driver.set(new FirefoxDriver());
					driver = new FirefoxDriver();
				}

				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
				long time = 30;
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));		
		        driver.get(prop.getProperty("URL"));
			
		}
		
		
       
		
		
}
		
}
