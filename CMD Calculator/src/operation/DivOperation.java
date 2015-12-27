package operation;

import computation.Computation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gillh on 12/21/2015.
 *
 * This class is equipped to handle division of numbers
 */
public class DivOperation implements Operation{

    /**
     * This method will take a list of numbers and return a computation object of the result
     * @param numbers list of numbers to add
     * @return Computation object
     */
    @Override
    public Computation calc(List<Double> numbers) throws Exception {
        if(numbers != null) {
            double quotient;
            if (numbers.size() > 0) {                   // if list is not empty
                quotient = numbers.remove(0);           // start with quotient being the first number in list
                for (Double num : numbers) {                  // for rest of numbers in list
                    quotient /= num;                              // divide quotient by number
                }
                return new Computation("ADD", Arrays.toString(numbers.toArray()), quotient);
            } else {
                throw new IllegalArgumentException("Number list must contain at least one number");
            }
        }
        else{
            throw new IllegalArgumentException("Number list cannot be NULL");
        }
    }
}
