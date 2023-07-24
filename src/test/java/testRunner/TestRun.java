package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//feature is used to specify the location of our feature file
//(Project directory)
//(.//)represents the current project directory


//To run all the feature files in this folder
//features=".//Features/" 

//To run only few feature files 
//features={".//Features/Customers.feature",".//Features/login.feature"}

//To run the specific feature file
//features=".//Features/Customers.feature"

//same thing is applicable for glue command also

//glue is used to specify the location of the package where steps have been
//implemented

//dryRun=true without real execution, will cross check every step is having
//corresponding methods implemented or not
//dryRun=false is for real execution

//plugin for adding reports

//pretty is the parameter used to print the output clearly

//html:test-output It generates the html report in the test-output folder 

//monochrome=true  It will remove unnecessary character from the console 
//window.

//tags is used for grouping the scenarios or running the specific scenarios
//separately. 
//While specifying the tags we have to mention only the features folder path.
//no need to mention the feature files name in the features.

//tags= {"@sanity"}-->runs only sanity tagged scenarios
//tags={"@sanity","@regression"}--->comma represents and, 
//it runs the scenarios tagged as both sanity and regression
//tags={"@sanity,@regression"}--->comma represents or, 
//it runs scenarios tagged either sanity or regression

@RunWith(Cucumber.class)
@CucumberOptions
             (features=".//Features/Customers.feature",
              glue="stepDefinitions",
              dryRun=false,
              plugin={"pretty","html:test-output"},
              monochrome=true
              //tags={"@sanity"}
             )


public class TestRun 
{

}
