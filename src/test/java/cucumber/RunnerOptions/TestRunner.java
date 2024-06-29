package cucumber.RunnerOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
 * 
 * maven commads to run with TAGs
 * Before 5.0.0 mvn test -Dcucumber.options="--tags @AddPlace"'
 * After  5.0.0 mvn test -Dcucumber.filter.tags="@AddPlace"
 * @author AKSHAY
 *
 */

@RunWith(Cucumber.class)
//cucumber option annotation 
//              (path of package in which features file is present, packageName where step definition is present)
@CucumberOptions(features="src/test/java/features",glue="stepDefinition",tags="@DeletePlace")
// Remove TAG to run both scenarios from feature file
//to add multuple tags follow --> tags="@AddPlace or @DeletePlace"
public class TestRunner {

}
//Run Runner file after above code is written , it will generate step definition file
//Before running runner with step definition file code is ready remove eclipse inbuild junit
//multiple junit will throw errors
//we already have junit depedancy in maven