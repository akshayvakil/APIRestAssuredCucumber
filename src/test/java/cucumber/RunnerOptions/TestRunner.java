package cucumber.RunnerOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//cucumber option annotation (path of package in which features file is present, package where step definition is present)

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"stepDefinition"})
public class TestRunner {

}
//Run Runner file after above code is written , it will generate step definition file
//Before running runner with step definition file code is ready remove eclipse inbuild junit
//multiple junit will throw errors
//we already have junit depedancy in maven