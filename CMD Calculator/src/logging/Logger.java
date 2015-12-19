package logging;

import computation.Computation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick Zawadzki
 * This Singleton class is used to store Logged calculations, and also return any logged computations that the
 * User requests.
 */
public class Logger {

    private static Logger logger = null;
    private List<Computation> previousComputations;
    public static Logger getInstance(){
            if(logger == null){
                logger = new Logger();
            }
        return logger;

    }

    private Logger(){
        previousComputations = new ArrayList<>();
    }

    /**
     * The log method is how an operation can store a Computation object into the logger.
     * @param c
     */
    public void log(Computation c){
        this.previousComputations.add(c);
    }

    /**
     * The printMostRecentLog method print the most recent log available. It simply calls the printNLogs method.
     */
    public void printMostRecentLog(){
       this.printNLogs(1);//prints a single log.
    }

    /**
     * The printNLogs will print the number of logs requested by the user. If the number of logs exceeds the size of the
     * list, then it will automatically print the entire list.
     *
     * If the logs requested is less than 1, it will print a message asking the user to request at least one log.
     *
     * Otherwise, the method will print the amount of logs requested by the user, sorted descending by Most Recent.
     * @param numberLogs
     */
    public void printNLogs(int numberLogs){
        if(previousComputations.size() == 0){
            System.out.println("No Logs to Display");
            return;
        }
        if(numberLogs < 1){
            System.out.println("Unable to print log: Please request at least one log");
        }else if(numberLogs >= previousComputations.size()-1){
            for(Computation c : previousComputations){
                try{
                    System.out.println(c.computationString());
                }catch(IllegalArgumentException e){
                    System.out.println("Unable to print log, " + e.getMessage());
                }
            }
        }else{
            for(int i = (previousComputations.size() - numberLogs); i >= 0; i--){
                System.out.println(previousComputations.get(i).computationString());
            }
        }
    }


}
