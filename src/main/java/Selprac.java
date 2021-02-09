import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selprac {
@Test
public void youTube() {
	System.setProperty("Webdriver.gecko.driver", "C:\\Users\\ankit\\Desktop\\selenium\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com");

//	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Dil");
//	List<WebElement> el=new ArrayList<WebElement>();
//	el=driver.findElements(By.tagName("b"));
//	for(WebElement i : el) {
//		String df=i.getText();
//		if(df.contains("diljit")) {
//			driver.findElement(By.tagName("b")).click();
//		break;
//		}
//	}
}
}
