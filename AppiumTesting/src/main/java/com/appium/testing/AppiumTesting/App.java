package com.appium.testing.AppiumTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Hello world!
 *
 */
public class App 
{
	static AppiumDriver <MobileElement> appiumdriver;
	
    public static void main( String[] args )
    {
    	try {
			OpenApp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }
    
    public static void OpenApp() throws MalformedURLException {
    	DesiredCapabilities cap = new DesiredCapabilities();
    	cap.setCapability("deviceName", "Galaxy M01s");
    	cap.setCapability("udid", "R9BN800DK2J"); // type <adb devices> on cmd
    	cap.setCapability("platformName", "Android");
    	cap.setCapability("platformVersion", "9");
    	cap.setCapability("automationName", "UiAutomator2");
    	
    	cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
    	cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
    	
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	appiumdriver = new AppiumDriver<MobileElement>(url, cap);
    	System.out.print("=====Automation App started=====");

    	MobileElement one = appiumdriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_01"));
    	one.click();
    	
    	MobileElement plus = appiumdriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
    	plus.click();
    	
    	
    	MobileElement two = appiumdriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02"));
    	two.click();
    	
    	MobileElement equals = appiumdriver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
    	equals.click();
    	
    	MobileElement result = appiumdriver.findElement(By.className("android.widget.EditText"));
    	String res = result.getText();
    	System.out.print("Result is "+res);
    	
    	
    	
    }
}
