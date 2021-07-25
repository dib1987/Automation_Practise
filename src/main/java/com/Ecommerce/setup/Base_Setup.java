package com.Ecommerce.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Setup {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static String path = System.getProperty("user.dir");
	
	

	

	
	
	
   public Base_Setup() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\property\\config.properties");
			prop.load(ip);
			
			
			
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
   
   public static void initialization() {
	   
	   WebDriverManager.chromedriver().setup();
		
		
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(WaitingTimeSetup.getTimeToImplicitlyWait(), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	
		driver.manage().timeouts().implicitlyWait(WaitingTimeSetup.getTimeToImplicitlyWait(), TimeUnit.SECONDS);
	}







}
