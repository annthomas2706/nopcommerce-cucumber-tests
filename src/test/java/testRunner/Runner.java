package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/java/Features/Login.feature",
		glue="stepDefinitions",
		dryRun=false,//true  will crosscheck for every steps in feature, methods are created in stepdefinition
		monochrome=true,//remove unnecessary characters in console window
		plugin= {"pretty","html:target/cucumber-reports/Cucumber.html"})//to make report in console window  more clearer and create an html report inside test-output folder
public class Runner {

}
