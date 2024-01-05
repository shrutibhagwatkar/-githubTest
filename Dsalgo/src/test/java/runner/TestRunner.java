package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber; //import because of error on line no 8 

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"}, //always use folder name don't give path till feature file. 
glue= {"stepDefinitions"},//define hooks here
monochrome=true,
dryRun=false,       //only to get console output and not browser launch




plugin={"pretty","html:target/htmlReports/report.html",
		"json:target/jsonReports/report.json",
		"junit:target/junitReports/report.xml"
}
// tags="smoketest"....will execute the tag test 
 
)
public class TestRunner {

	
}
//please use lacation path of Feature folder while running TestRunner file 
//and use src/test/resources/Features when running feature file