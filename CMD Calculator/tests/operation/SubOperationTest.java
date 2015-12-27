package operation;

import computation.Computation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by zawadzkip on 12/27/15.
 */
public class SubOperationTest {

    Operation o;
    List<Double> numbers;
    CustomAssert customAssert;
    private final String EXCEPTION_MESSAGE = "Number list must contain at least one number";
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        o = new MultOperation();
        numbers = new ArrayList<>();
        customAssert = new CustomAssert();
    }

    @Test
    public void testPositiveNumbers(){
        numbers.add(12.0);
        numbers.add(5.0);
        numbers.add(1.0);
        try{
            Computation result = o.calc(numbers);
            Computation expected = new Computation("SUB", Arrays.toString(numbers.toArray()),6.0);
            customAssert.assertComputationIsEqual(expected,result);
        }catch(Exception e){
            fail("Test Positive Numbers should not have thrown an exception");
        }
    }

}