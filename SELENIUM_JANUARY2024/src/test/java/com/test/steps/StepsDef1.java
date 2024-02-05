package com.test.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDef1 {

	int a;
	int b;
	int actual;

	@Given("I login into the application")
	public void i_login_into_the_application() {
	    System.out.println("Logged into the application"); }




	@Given("User has two integer numbers {int} and {int}")
	public void user_has_two_integer_numbers_and(Integer int1, Integer int2) {

		a = int1;
		b = int2;

	}



	@When("User adds the two numbers")
	public void user_adds_the_two_numbers() {

		actual = a+ b;

	}

	@Then("User verifies the number is {int}")
	public void user_verifies_the_number_is(Integer int1) {


		Assert.assertEquals(actual, int1);

	}


}
