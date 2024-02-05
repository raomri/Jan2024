package com.test.goibibo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestIbibo {

	class WebElementComparator implements Comparator<WebElement> {

	    // override the compare() method
	    @Override
		public int compare(WebElement s1, WebElement s2)
	    {
	    	return s1.getText().compareTo(s2.getText());
	    }
	}

	WebDriver driver;
	String minPrice;
	String finalFareSel;
	String finalFareSel1;

	@Test
	public void bookTicker() throws InterruptedException {

	driver = new ChromeDriver();
	driver.get("https://www.goibibo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



	WebElement popClose = driver.findElement(By.xpath("//span[@role='presentation']"));
		// close popup
		popClose.click();



	WebElement fromLabel = driver.findElement(By.xpath("//span[contains(text(),'From')]"));

	fromLabel.click();


	WebElement fromCity = driver.findElement(By.xpath("//input[@type='text']"));

	fromCity.sendKeys("Delhi");


	WebElement selFromCity = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]"));

	selFromCity.click();



	WebElement toCity = driver.findElement(By.xpath("//input[@type='text']"));
	toCity.sendKeys("Sharjah");


	WebElement selToCity = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]"));
	selToCity.click();

	List<WebElement> priceList1 = driver.findElements(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Day']/p[@class='fsw__price ']"));



   System.out.println("PRICE LIST SIZE:::: " +priceList1.size());

   ArrayList<String> sortedList = new ArrayList<>();
 //Collections.sort(priceList1, new WebElementComparator());

		for (WebElement a : priceList1) {
			sortedList.add(a.getText());
		}

		Collections.sort(sortedList);

		minPrice = sortedList.get(0);

		//minPrice = minPrice.replace(",","");
		//Integer minintValue = Integer.parseInt(minPrice);

		System.out.println("Lowest Ticket Price: " +minPrice);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(300));

		WebElement lwstPrice = driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Day']/p[text() = '"+minPrice+"']"));


		wait.until(ExpectedConditions.elementToBeClickable(lwstPrice));
		lwstPrice.click();

		WebElement doneButton = driver.findElement(By.xpath("//span[contains(text(),'Done')]"));
		doneButton.click();

		WebElement donePassButton = driver.findElement(By.xpath("//a[contains(text(),'Done')]"));
		donePassButton.click();

		WebElement srchFlights  = driver.findElement(By.xpath("//span[contains(text(),'SEARCH FLIGHTS')]"));
		srchFlights.click();

		WebElement directFlights = driver.findElement(By.xpath("//span[contains(text(),'Direct')]"));
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(directFlights));
		directFlights.click();

		WebElement viewFareSharjah1 = driver.findElement(By.xpath("//span[text()='Sharjah']/following::button[text()='VIEW FARES'][1]"));
		WebDriverWait wait11=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait11.until(ExpectedConditions.elementToBeClickable(viewFareSharjah1));
		viewFareSharjah1.click();

//		finalFareSel = driver.findElement(By.xpath("//span[text()='Sharjah']/following::span[16]")).getText();
//		finalFareSel = finalFareSel.replace("₹","");
//		System.out.println("Fare Selected>>" +finalFareSel);
//
//		WebElement selFinalFare = driver.findElement(By.xpath("//span[text()='Sharjah']/following::span[18]"));
//		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(40));
//		wait2.until(ExpectedConditions.elementToBeClickable(viewFareSharjah1));
//		selFinalFare.click();
//
//		Thread.sleep(5000);
//
//		Set<String> allWinHandles = driver.getWindowHandles();
//
//		for(String childWindow : allWinHandles) {
//			driver.switchTo().window(childWindow);
//
//		}
//
//		WebElement grandFare = driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]/following-sibling::div/span"));
//		WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(40));
//		wait3.until(ExpectedConditions.elementToBeClickable(grandFare));
//
//		finalFareSel1 = grandFare.getText();
//		finalFareSel1 = finalFareSel1.replace("₹","");
//		System.out.println("Grand Final fare>>" +finalFareSel1);
//
//		Assert.assertEquals(finalFareSel, finalFareSel1);
	}
}



