package com.test.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefOrangeHRMLogin {

	private static final boolean True = false;

	@Given("user is at the login page")
	public void user_is_at_the_login_page() {

		Hooks1.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@When("User enters in UserName")
	public void user_enters_in_user_name() {

		Hooks1.driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

	}

	@When("User enters in the Password")
	public void user_enters_in_the_password() {
		Hooks1.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");


	}

	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {

		Hooks1.driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("User is logged in successfully")
	public void user_is_logged_in_successfully() {

		String actual = Hooks1.driver.findElement(By.tagName("h6")).getText();

		Assert.assertEquals(actual, "Dashboard");


	}

	@Then("Verify all Menu options")
	public void verify_all_menu_options(DataTable table) throws InterruptedException {

		List<Map<String,String>> datas = table.asMaps();


			for (int i= 0, a = 1; i<datas.size(); i++, a++) {
				System.out.println(datas.get(i));

				Assert.assertTrue(Hooks1.driver.findElement(By.xpath("//ul/li["+a+"]/a/span")).isDisplayed());
			    //Assert.assertTrue(Hooks1.driver.findElement(By.xpath("//ul/li/a/span[text()='\"+datas.get(a)+\"']")).isDisplayed());
			}




	}

	}


