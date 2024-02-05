package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions (

		features = "src/test/java/com/test/cucumber",
		glue = {"com.test.steps"},
		plugin = { "json:target/jsonTarget.json",
				   "html:target/htmlTarget.html" ,
	               "rerun:target/failedtests.txt"}
		)



public class CucumberRunner extends AbstractTestNGCucumberTests {

}

