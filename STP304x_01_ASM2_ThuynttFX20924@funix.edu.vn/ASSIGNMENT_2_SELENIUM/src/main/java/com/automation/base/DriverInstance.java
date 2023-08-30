package com.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverInstance {
	protected ChromeDriver driver;
	
	@BeforeClass
	
	public void initDriverInstance() {
		
		//Khoi tao Chrome
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
				
				
		// maximise the window
		driver.manage().window().maximize();
		        
		        
		//Cac page load khong qua 30s
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	
	public void closeDriverInstance() {
			System.out.println("finish: close browser");
			driver.close();
		}
	

}
