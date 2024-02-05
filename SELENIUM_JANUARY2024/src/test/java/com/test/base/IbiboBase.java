package com.test.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class IbiboBase {

	protected WebDriver driver;


	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}


	@AfterClass
	public void tearDown() {

		driver.quit();

	}



	}


