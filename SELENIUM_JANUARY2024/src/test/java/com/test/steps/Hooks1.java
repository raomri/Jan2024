package com.test.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks1 {

	static WebDriver driver;


	@BeforeMethod
	@Before("@orangehrm")
	public void setUp() {

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}


	@AfterMethod
	@After ("@orangehrm")
	public void tearDown() {

		driver.quit();
	}

}
