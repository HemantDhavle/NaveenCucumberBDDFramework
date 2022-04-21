package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/test/resources/features/accountPage.feature", glue={"stepDefinations","AppHooks"})
public class runner extends AbstractTestNGCucumberTests{

}
