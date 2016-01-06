package calculator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

/**
 * Created by zawadzkip on 1/4/16.
 */
public class CalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();  // this object will hold the text that is printed to console
    private final String INSTRUCTIONS_TEXT = "Welcome to Hardip's and Patrick's Calculator\n" +
            "\n" +
            "Use command 'ADD' to add a list of numbers\n" +
            "Use command 'SUB' to subtract a list of numbers\n" +
            "Use command 'MULT' to multiply a list of numbers\n" +
            "Use command 'DIV' to divide a list of numbers\n" +
            "Use command 'SQR' to square a list of numbers\n" +
            "Use command 'HIS' to view history\n" +
            "Use command 'DEL' to delete history\n" +
            "\n" +
            "Use placeholder '!#' to reference a previous result (# being the result number in history\n";
    private Calculator calculator;
    @BeforeMethod
    public void setUp() throws Exception{
        System.setOut(new PrintStream(outContent));
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() throws Exception{
        outContent.reset();
        System.setOut(null);
        calculator = null;
    }

    private static String[] testOperations(){
        return new String[]{
                "ADD 1 2 3",//6
                "SUB 3 2 1",//0
                "MULT 3 2 2",//12
                "DIV 6 2 3",//1
                "SQR 4",//16
                "HIS",
                "DEL",
                "HIS"

        };
    }

    private static String[] testOperationsToString(){
        return new String[]{
                "ADD [1.0, 2.0, 3.0] Answer: 6.0",
                "SUB [3.0, 2.0, 1.0] Answer: 0.0",
                "MULT [3.0, 2.0, 2.0] Answer: 12.0",
                "DIV [6.0, 2.0, 3.0] Answer: 1.0",
                "SQR [4.0] Answer: 16.0",
                "ADD [1.0, 2.0, 3.0] Answer: 6.0\r\n"+
                "SUB [3.0, 2.0, 1.0] Answer: 0.0\r\n"+
                "MULT [3.0, 2.0, 2.0] Answer: 12.0\r\n"+
                "DIV [6.0, 2.0, 3.0] Answer: 1.0\r\n"+
                "SQR [4.0] Answer: 16.0",
                "\n",
                "No Logs to Display"
        };
    }

    @DataProvider(name = "testOperations")
    private static Object[][] testOperationResults(){
        return new Object[][]{
                {testOperations(),testOperationsToString(),0},
                {testOperations(),testOperationsToString(),1},
                {testOperations(),testOperationsToString(),2},
                {testOperations(),testOperationsToString(),3},
                {testOperations(),testOperationsToString(),4},
                {testOperations(),testOperationsToString(),5},
                {testOperations(),testOperationsToString(),6},
                {testOperations(),testOperationsToString(),7},

        };
    }

   @Test(dataProvider = "testOperations")
    public void testStandardOperations(String[] commands, String[] commandResponses, int index)
    {
        calculator.executeCommand(commands[index]);
        String output = outContent.toString().replace(INSTRUCTIONS_TEXT,"").trim();//remove the instructions text.
        assertEquals(commandResponses[index].trim(), output);
    }
    @Test
   public void testSubstitutionOperations(){
       String add = "ADD 1 2 3";
       String sub = "SUB !1 2.0";
       String result = "SUB [6.0, 2.0] Answer: 4.0";
       calculator.executeCommand(add);
       outContent.reset();
       calculator.executeCommand(sub);
       String output = outContent.toString().replace(INSTRUCTIONS_TEXT,"").trim();
       assertEquals(output,result);


   }





}