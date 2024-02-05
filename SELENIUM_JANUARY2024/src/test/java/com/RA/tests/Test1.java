package com.RA.tests;

import static org.hamcrest.Matchers.hasItems;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test1 {


	@Test
	public void simpleGetTest() {

		int x = 2;
		String s = ("users?page=2");

			Response response = RestAssured.given()
								.header("accept","application/json")
								//.log().ifValidationFails()
								.when()
								.get("https://reqres.in/api/"+s)
								;


			response.then().log().ifValidationFails().body("data.first_name", hasItems("Michael","Lindsay"))

		.assertThat().statusCode(200);

			String re = response.prettyPrint();
			System.out.println(re);

//			String re = response.then().extract().asPrettyString();
//
//			System.out.println(response.getBody());
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getHeaders());
//			System.out.println(response.getStatusLine());



		}

	@Test
	public void getIdRangeByJsonPath() throws IOException {



	Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");

	FileWriter file = new FileWriter("./output.json");
	file.write(response.prettyPrint());
	file.flush();  // removes any data in the FileWriter
	file.close();  // closes the filewriter.
	//Closing a writer deallocates any value in it or any resources associated with it.


		}


	@Test
	public void browserTest() {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());

	}





	}










