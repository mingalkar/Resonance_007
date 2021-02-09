package com.Resonantia.Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {
	public WebDriver driver = null;
	/**
	 * use this method to open different Browser
	 * @param browserName
	 */
	public WebDriver openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			openChrome();
			break;
		case "IE":
			openIE();
			break;
		case "firefox":
			openFirefox();
			break;
		case "safari":
			openSafari();
			break;
		default:
			System.out.println("Invalid browser name:" + browserName);
		}
		return driver;

	}

	/**
	 * use this method to open Chrome Browser
	 */
	public void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	/**
	 * use this method to open IE Browser
	 */
	public void openIE() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}

	/**
	 * use this method to open firefox Browser
	 */
	public void openFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	/**
	 * use this method to open safari Browser
	 */
	public void openSafari() {

		driver = new SafariDriver();

	}



	/**
	 * this method is used to insert Url
	 * 
	 * @param URL
	 */
	public void openURL(String URL) {
		driver.get(URL);

	}
	public void ElementLocatorStrategy(String locaterType, String locaterValue, String textToEnter) {
		switch (locaterType) {
		case "XPATH":
			driver.findElement(By.xpath(locaterValue)).sendKeys(locaterValue);
			break;
		case "CSS":
			driver.findElement(By.cssSelector(locaterValue)).sendKeys(textToEnter);
			break;
		case "ID":
			driver.findElement(By.id(locaterValue)).sendKeys(textToEnter);
			break;
		case "LINKTEXT":
			driver.findElement(By.linkText(locaterValue)).sendKeys(textToEnter);
			break;
		case "PARTIAL_LINK_TEXT":
			driver.findElement(By.partialLinkText(locaterValue)).sendKeys(textToEnter);	
			break;
		case "CLASS_NAME":
			driver.findElement(By.className(locaterValue)).sendKeys(textToEnter);	
			break;	
		default:
			System.out.println("invalid Locater Type");
			break;
		}

	}
}
