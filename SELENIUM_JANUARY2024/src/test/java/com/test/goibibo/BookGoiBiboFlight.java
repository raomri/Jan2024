package com.test.goibibo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.test.base.IbiboBase;


public class BookGoiBiboFlight extends IbiboBase{

	WebDriver driver;
	String minPrice ;
	String finalFareSel;
	String finalFareSel1;
	JavascriptExecutor JS;


	@FindBy(xpath="//span[@role='presentation']")
	WebElement popClose;

	@FindBy(xpath="//span[contains(text(),'From')]")
	WebElement fromLabel;


	@FindBy(xpath="//input[@type='text']")
	WebElement fromCity;

	@FindBy(xpath="//ul[@id='autoSuggest-list']/li[1]")
	WebElement selFromCity;

	@FindBy(xpath="//input[@type='text']")
	WebElement toCity;

	@FindBy(xpath="//ul[@id='autoSuggest-list']/li[1]")
	WebElement selToCity;


	//@FindBy(xpath="//div[@class='DayPicker-Day' ]/p[@class='fsw__price ']")
	 @FindBy(xpath="//div[@class='DayPicker-Month']//div[@class='DayPicker-Day']/p[@class='fsw__price ']")
	List<WebElement> priceList;

	@FindBy(xpath="//span[contains(text(),'Done')]")
	WebElement doneButton;

	@FindBy(xpath="//a[contains(text(),'Done')]")
	WebElement donePassButton;



	@FindBy(xpath = "//span[contains(text(),'SEARCH FLIGHTS')]")
	WebElement srchFlights;

	@FindBy(xpath= "//span[contains(text(),'Direct')]")
	WebElement directFlights;

	//@FindBy(xpath= "//div[@class='DayPicker-Day' ]/p[text()='\"+minPrice+\"'])")
	//WebElement lowestPrice;

	@FindBy(xpath="//span[text()='Sharjah']/following::button[text()='VIEW FARES'][1]")
	WebElement viewFareSharjah1;


	@FindBy(xpath="//span[text()='Sharjah']/following::span[@class=\"dF flexCol\"][1]/preceding::span[@class='font18 f600']")
	WebElement finalFarePrice;

	@FindBy(xpath="//span[text()='Sharjah']/following::span[@class='dF flexCol'][1]")
	WebElement selFinalFare;

	@FindBy(xpath="//div[contains(text(),'Grand Total')]/following-sibling::div/span")
	 WebElement grandFare;

	public BookGoiBiboFlight(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver,this);

	}



		@Test
		public void closeAlert() {
		// close popup
		popClose.click();  }

		@Test
		public void selFromCity() {
		// selecting fromCity input box

		fromLabel.click();

		fromCity.sendKeys("Delhi");

		selFromCity.click(); }


		@Test
		public void destCity() {


		toCity.sendKeys("Sharjah");

		//WebElement selToCity = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]"));
		selToCity.click();

		}

		@Test
		public void selLowestPriceTicket() {

		//List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='DayPicker-Day' ]/p[@class='fsw__price ']"));



		System.out.println("PRICE LIST SIZE:::: " +priceList.size());

		ArrayList<String> sortedList = new ArrayList<>();

		for (WebElement a : priceList) {

		sortedList.add(a.getText());

		}

		Collections.sort(sortedList);

		minPrice = sortedList.get(0);

		System.out.println("Lowest Ticket Price: " +minPrice);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(doneButton));

		//WebElement lowestPrice = driver.findElement(By.xpath("//div[@class='DayPicker-Day' ]/p[text()='"+minPrice+"']"));
		WebElement lowestPrice = driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Day']/p[text()='"+minPrice+"']"));
		lowestPrice.click();

		doneButton.click();

		}


		@Test
		public void selPassengers() {

		donePassButton.click();
		}


		@Test
		public void clickSearchFlights1() {

		srchFlights.click(); }

		@Test
		public void selDirectFlightsOnly() {

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(directFlights));


		directFlights.click();	}



		@Test
		public void viewAndSelSharjahFares() throws InterruptedException {

		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait1.until(ExpectedConditions.elementToBeClickable(viewFareSharjah1));

		//JS.executeScript("arguments[0].scrollIntoView(true);", viewFareSharjah1);

		Thread.sleep(3000);


		viewFareSharjah1.click();


		//popClose.click();

		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait2.until(ExpectedConditions.elementToBeClickable(selFinalFare));

		finalFareSel = finalFarePrice.getText();

		finalFareSel = finalFareSel.replace("₹","");

		System.out.println("Fare Selected>>" +finalFareSel);

		selFinalFare.click();

		//popClose.click();

		Thread.sleep(5000);

		}

		@Test
		public void confirmBookingPage() throws InterruptedException {


		Set<String> allWinHandles = driver.getWindowHandles();

		for(String childWindow : allWinHandles) {
			driver.switchTo().window(childWindow);

		}

		WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(90), Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(grandFare));

		Thread.sleep(6000);

		finalFareSel1 = grandFare.getText();

		finalFareSel1 = finalFareSel1.replace("₹","");

		System.out.println("Grand Final fare>>" +finalFareSel1);



		}

		@Test
		public void validateFinalPrice() {

		AssertJUnit.assertEquals(finalFareSel1,finalFareSel );

		}



}


