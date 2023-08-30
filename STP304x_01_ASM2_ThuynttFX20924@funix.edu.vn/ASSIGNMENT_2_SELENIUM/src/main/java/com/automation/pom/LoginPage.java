package com.automation.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.PropertiesFileUtils;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public void enterEmail(String email, String emailPath) throws InterruptedException {
		WebElement emailTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailPath)));
	    //WebElement emailTextbox = driver.findElement(By.xpath(emailPath)) ;
		emailTextbox.sendKeys(email);
		Thread.sleep(2000);
	}
	
	public void enterPassword(String password, String passPath) throws InterruptedException {
		
		WebElement passTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passPath)));
		//WebElement passTextBox = driver.findElement(By.xpath(passPath)); 
		passTextBox.sendKeys(password);
		Thread.sleep(2000);
		
	}
	
	public void clickSignIn(String signInPath) throws InterruptedException {
		WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signInPath)));
		//WebElement signIn = driver.findElement(By.xpath(signInPath));
		signIn.click();
		Thread.sleep(2000);
	}

}
