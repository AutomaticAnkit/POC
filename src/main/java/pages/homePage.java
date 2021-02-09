package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.SeleniumLibrary;

public class homePage extends SeleniumLibrary{
	
	WebDriver driver;
	
	By LogInBtn=By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[5]");
	By username=By.id("username");
	
	
	
	public homePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void clickLoginBtn() {
		driver.findElement(LogInBtn).click();
	}
	
	public void enterUsername(String usernme) {
		driver.findElement(username).sendKeys(usernme);
	}

	
}
