package pages;

import org.openqa.selenium.WebDriver;

import Resources.SeleniumLibrary;

public class pageObj extends SeleniumLibrary{
	protected WebDriver driver;

	public homePage homePage =new homePage(driver);
}
