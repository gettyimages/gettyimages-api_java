package com.gettyimages;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/gettyimages/bdd-scenarios/authentication.feature",
        format = { "pretty" })
public class RunBddScenariosTest {
}