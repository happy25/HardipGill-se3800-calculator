package step_definitions;

import computation.Computation;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import operation.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by gillh on 1/12/2016.
 *
 * This class holds all of the step definitions for all of the Cucumber feature tests
 */
public class StepDefinitions {

    private static double ACCEPTED_DIF = 0.0001;
    Operation operation;
    List<Double> numbers;
    Computation comp;
    String errorMessage;

    @Before
    public void beforeScenario(){
        numbers = new ArrayList<>();
        errorMessage = "";
    }

    @After
    public void afterScenario(){
        comp = null;
    }

    @Given("^I enter the integer (-?\\d+)$")
    public void i_enter_the_integer(double num) throws Throwable {
        numbers.add(num);
    }

    @Given("^I enter no numbers$")
    public void I_enter_no_numbers() throws Throwable {
        // do nothing
    }

    @When("^I preform the \"([^\"]*)\" operation$")
    public void I_preform_the_operation(String op) throws Throwable {
        switch (op) {
            case "add":
                operation = new AddOperation();
                break;
            case "subtract":
                operation = new SubOperation();
                break;
            case "multiply":
                operation = new MultOperation();
                break;
            case "divide":
                operation = new DivOperation();
                break;
            case "square":
                operation = new SqrOperation();
                break;
            default:
                throw new Exception("Not a valid operation");
        }
    }

    @Then("^the result should be (.+)$")
    public void the_result_should_be(float expectedResult) throws Throwable {
        comp = operation.calc(numbers);
        assertEquals(comp.getResult(), expectedResult, ACCEPTED_DIF);
    }

    @Then("^I should get an error message saying \"([^\"]*)\";$")
    public void I_should_get_an_error_message_saying_(String expectedErrorMessage) throws Throwable {
        try{
            operation.calc(numbers);
            fail("Calculation should throw the Exception: "+expectedErrorMessage);
        }
        catch(Exception e ){
            assertEquals(e.getMessage(),expectedErrorMessage);
        }
    }
}
