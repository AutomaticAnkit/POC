package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumLibrary {
	public WebDriver driver;

public WebDriver initializeDriver() throws IOException, InterruptedException {
	
	Properties prop = new Properties();
	FileInputStream fis =new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\WebAppAutomation\\src\\main\\java\\Resources\\utils.properties");
	prop.load(fis);
	String browserName=prop.getProperty("BROWSER");
	
	if(browserName.equals("chrome")) {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\ankit\\eclipse-workspace\\WebAppAutomation\\src\\main\\java\\Resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}
	else
	if(browserName.equals("firefox")) {
		System.setProperty("Webdriver.gecko.driver", "C:\\Users\\ankit\\eclipse-workspace\\WebAppAutomation\\src\\main\\java\\Resources\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get(prop.getProperty("URL"));
	}
	
	else
	{
		System.out.println("Browser not found");
	}
	return driver;
	
}

public void SSLCertification() {
	DesiredCapabilities dc= new DesiredCapabilities();
	dc.acceptInsecureCerts();
	ChromeOptions c = new ChromeOptions();
	c.merge(dc);
}


	

}
