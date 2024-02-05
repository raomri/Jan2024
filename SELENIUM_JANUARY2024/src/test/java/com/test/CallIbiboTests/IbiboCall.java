package com.test.CallIbiboTests;

import org.testng.annotations.Test;

import com.test.base.IbiboBase;
import com.test.goibibo.BookGoiBiboFlight;

public class IbiboCall extends IbiboBase {


	@Test
	public void callIbiboTests() throws InterruptedException {

	//BookGoiBiboFlight ibiboTest = PageFactory.initElements(driver, BookGoiBiboFlight.class);
	BookGoiBiboFlight ibiboTest = new BookGoiBiboFlight(driver);
	ibiboTest.closeAlert();
	ibiboTest.selFromCity();
	ibiboTest.destCity();
	ibiboTest.selLowestPriceTicket();
	ibiboTest.selPassengers();
	ibiboTest.clickSearchFlights1();
	ibiboTest.selDirectFlightsOnly();
	ibiboTest.viewAndSelSharjahFares();
    ibiboTest.confirmBookingPage();
	ibiboTest.validateFinalPrice();

	}

}