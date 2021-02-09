package AVSeleniumPractice.WebAppAutomation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.pageObj;

public class testSuite {
//	ExtentReports erport;
//@BeforeTest
//public void launchBrowser() throws IOException, InterruptedException {
//	driver =initializeDriver();
//	String path=System.getProperty(("key.dir")+"//reports/index.html");
//	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//	
//	erport = new ExtentReports();
//	erport.attachReporter(reporter);
//	
//}
@Test
public void Navigate() throws IOException {
	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\ankit\\eclipse-workspace\\WebAppAutomation\\src\\main\\java\\Resources\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
//	driver.manage().window().maximize();
	driver.get("https://www.youtube.com");
 driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Dil");
// int count=driver.findElements(By.tagName("b")).size();
 List<WebElement> re= driver.findElements(By.tagName("b"));
 WebElement we=driver.findElement(By.tagName("b"));
 for(WebElement i : re) {
	String bh=i.getText();
	if(bh.contains("Diljit")) {
		we.click();
		break;
	}
 }
 
 
// 
//}
//
//@AfterTest
//public void closeBroser() {
//	driver.close();
//}

}
}
