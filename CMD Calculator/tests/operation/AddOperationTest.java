package operation;

import computation.Computation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zawadzkip on 12/27/15.
 */
public class AddOperationTest {

    Operation o;
    List<Double> numbers;
    CustomAssert customAssert;
    private final String EMPTY_LIST_EXCEPTION_MESSAGE = "Number list must contain at least one number";
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        o = new AddOperation();
        numbers = new ArrayList<>();
        customAssert  = new CustomAssert();
    }
    @Test
    public void testAddPositives(){
        numbers.add(1.0);
        numbers.add(2.0);
        try{
            Computation c = o.calc(numbers);
            Computation expected = new Computation("ADD",Arrays.toString(numbers.toArray()),3.0);
            customAssert.assertComputationIsEqual(expected,c);
        }catch (Exception e){
            fail("Add Positives should not have thrown an exception. " + e.getMessage());
        }
    }

    @Test
    public void testAddNegatives(){
        numbers.add(-1.0);
        numbers.add(-2.0);
        try{
            Computation c = o.calc(numbers);
            Computation expected = new Computation("ADD", Arrays.toString(numbers.toArray()),-3.0);
            customAssert.assertComputationIsEqual(expected,c);
        }catch (Exception e){
            fail("Add negatives should not have thrown an exception. " + e.getMessage());
        }
    }
    @Test
    public void testAddBoth(){
        numbers.add(-1.0);
        numbers.add(2.0);
        try{
            Computation result = o.calc(numbers);
            Computation expected = new Computation("ADD", Arrays.toString(numbers.toArray()),1.0);
            customAssert.assertComputationIsEqual(expected,result);
        }catch (Exception e){
            fail("Add both should not have thrown an exception. " + e.getMessage());
        }
    }

    @Test
    public void testEmptyNumberList(){
        try{
            o.calc(numbers);
            fail("Test Empty Number List should have failed.");
        }catch (Exception e)
        {
            assertEquals(e.getMessage(),EMPTY_LIST_EXCEPTION_MESSAGE);
        }
    }

    //TODO Complete this test.
    @Test
    public void testNullList(){
        try{
            o.calc(null);
        } catch (Exception e) {

        }
    }


}