package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions (

		features = ("@target/failedtests.txt"),
		glue = {"com.test.steps"},
		plugin = { "json:target/jsonTarget.json",
				   "html:target/htmlTarget.html"
	               }
		)

public class FailedExRunner extends AbstractTestNGCucumberTests {
}
