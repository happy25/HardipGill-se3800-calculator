package operation;

import computation.Computation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gillh on 12/20/2015.
 *
 * This class is equipped to handle product of numbers
 */
public class MultOperation implements Operation {

    /**
     * This method will take a list of numbers and return a computation object of the result
     * @param numbers list of numbers to add
     * @return Computation object
     */
    @Override
    public Computation calc(List<Integer> numbers) throws Exception {
        float product = 1;
        if(numbers.size()>0){                   // if list is not empty
            for(Integer num: numbers){              // for every number in list
                product *= num;                         // multiply by number
            }
            return new Computation("ADD", Arrays.toString(numbers.toArray()),product);
        }
        else{
            throw new IllegalArgumentException("Number list must contain at least one number");
        }
    }
}
