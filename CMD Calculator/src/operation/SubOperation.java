package operation;

import computation.Computation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by gillh on 12/20/2015.
 *
 * This class is equipped to handle subtraction of numbers
 */
public class SubOperation implements Operation {

    /**
     * This method will take a list of numbers and return a computation object of the result
     * @param numbers list of numbers to add
     * @return Computation object
     */
    @Override
    public Computation calc(List<Integer> numbers) throws Exception {
        float dif;
        if(numbers.size()>0){           // if list is not empty
            dif = numbers.remove(0);        // start with diff being first number in list
            for(Integer num: numbers){          // for rest of numbers in list
                dif-=num;                           // subtract number from difference
            }
            return new Computation("ADD", Arrays.toString(numbers.toArray()),Float.toString(dif));
        }
        else{
            throw new IllegalArgumentException("Number list must contain at least one number");
        }

    }
}
