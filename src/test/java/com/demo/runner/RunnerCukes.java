/**
 * @author Sumit
 * 
 * Runner class to run feature files
 */
package com.demo.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(strict = true, features = "src/test/resources/feature", glue = {
		"com.demo.steps" }, tags = { "@UI" }, monochrome = true, plugin = {
				"json:target/cucumber-json-report.json", "html:target/cucumber-html-report",
				"junit:target/cucumber.xml" })
public class RunnerCukes {

}
