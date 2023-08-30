package com.automation.testcase;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.DataGenerator;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.CaptureScreenshot;

public class TC_LoginTest extends DriverInstance {
	
	
	@Test(dataProvider = "excel", dataProviderClass = DataGenerator.class)
	public void TC01_LoginFirstAccount(String email, String password) throws IOException, InterruptedException {
		
		//1. Lay URL tu properties file va tai trang
		String URL = PropertiesFileUtils.getPropertyValue("URL");
		driver.get(URL);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//2. Lay vi tri iconSignUp tu properties file va click
		
		String SignUpPath = PropertiesFileUtils.getPropertyValue("iconSignUp");
		
		WebElement iconSignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SignUpPath)));
		
		iconSignUp.click();
		
		//3. Dang nhap bang LoginPage
		
		
		String emailPath = PropertiesFileUtils.getPropertyValue("emailTextBox");
		String passPath = PropertiesFileUtils.getPropertyValue("passTextBox");
		String signInPath = PropertiesFileUtils.getPropertyValue("btnSignIn");
		String logOutPath = PropertiesFileUtils.getPropertyValue("linkLogOut");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmail(email, emailPath);
		loginPage.enterPassword(password, passPath);
		loginPage.clickSignIn(signInPath);
		
		//4. Dang xuat
		WebElement iconLogOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logOutPath)));
		iconLogOut.click();
		
			}
	
	@AfterMethod
	
	public void Screenshot(ITestResult result) throws InterruptedException {
		
		Thread.sleep(1000);
		
		
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				
				
				String email = (String) result.getParameters()[0];
				int index = email.indexOf("@");
				String accountName = email.substring(0, index);
				
				//Chup anh man hinh
				CaptureScreenshot.takeScreenshot(driver, accountName);
				System.out.println("Da chup man hinh " + accountName);
				Thread.sleep(2000);
				
				//Dinh kem anh man hinh vao report
				CaptureScreenshot.attachScreenShot("./screenshots" + accountName +".jpg");
				System.out.println("Da dinh kem screenshot vao report " + accountName);
				
			}
		    catch(Exception e) {
		    	System.out.println("Exception while taking screenshot" + e.getMessage());
		    }		
			
		}	
		
	}	

}
