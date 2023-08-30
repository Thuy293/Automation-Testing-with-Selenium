package com.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

//Chup anh su dung lop Robot
public class CaptureScreenshot {
	
	public static void takeScreenshot (WebDriver driver, String imageName) {
		
		try {
			
			File theDir = new File("./screenshots/");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}
			
			//Thuc hien chup anh mh, lay ra doi tuong file anh
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			//Tao doi tuong file voi ten da dat tai /screenshots
			File destiny = new File("./screenshots/" + imageName + ".jpg");
			ImageIO.write(image,"jpg", destiny);
		}
		catch (Exception ex) {
			System.out.println("Da xay ra loi khi chup man hinh");
			ex.printStackTrace();
		}
			
		attachScreenShot("./screenshots/" +imageName+ ".jpg");	
	}
	//attach screenshot in testNG report
	public static void attachScreenShot (String filePath) {
		
		try {
			
			System.setProperty("org.uncommons.reportng.escape-output","false");
			
			//Lay ra file theo duong dan
			File file = new File(filePath);
			
			Reporter.log("<br><a title = \"screenshots\" href=\" " + file.getAbsoluteFile() + "\">" + 
			"<img alt= ' "+ file.getName() + " ' src=" + file + "' height='243' width='418'/> </a><br>");
			
//			Reporter.log("<br> <img src=.\\screenshots\\" + file.getName() + "/> br>");		
		}
		
		catch (Exception e) {
			System.out.println("Da xay ra loi khi dinh kem anh");
		    		
		}
	}
	}

