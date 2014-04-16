import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import org.apache.log4j.*;

/**
 * Created by VVykhor on 24.03.2014.
 */

public class Processor {
    static Logger logger = Logger.getLogger(Processor.class);
    private String sourceFile;
    private StackHolder stack = new StackHolder();
    private Map<String, Double> variables = new HashMap<String, Double>();

    public void setFile(String fileName) {
        sourceFile = fileName;
    }

    public void execute() throws Exception {
        Scanner in = new Scanner(new File(sourceFile));
        do {
            String operation = in.next();
            if(operation.startsWith("#")) {
                System.out.println(operation + in.nextLine());
            } else {
                logger.debug("Found operation " + operation);
                if ("+".equals(operation)) {
                    double firstArg = stack.pop();
                    double secondArg = stack.pop();
                    stack.push(addition(firstArg, secondArg));
                } else if ("-".equals(operation)) {
                    double firstArg = stack.pop();
                    double secondArg = stack.pop();
                    stack.push(subjection(firstArg, secondArg));
                } else if ("*".equals(operation)) {
                    double firstArg = stack.pop();
                    double secondArg = stack.pop();
                    stack.push(multiplication(firstArg, secondArg));
                } else if ("/".equals(operation)) {
                    double firstArg = stack.pop();
                    double secondArg = stack.pop();
                    stack.push(diviation(firstArg, secondArg));
                } else if ("SQRT".equals(operation)) {
                    double firstArg = stack.pop();
                    stack.push(sqrt(firstArg));
                } else if ("PUSH".equals(operation)) {
                    double value;
                    if(in.hasNextDouble()) {
                        value = in.nextDouble();
                    } else {
                        String key = in.next();
                        if(variables.containsKey(key)) {
                            value = variables.get(key);
                        } else {
                            String msg = "Error: can not push value";
                            logger.error(msg);
                            throw new Exception(msg);
                        }
                    }
                    stack.push(value);
                } else if ("POP".equals(operation)) {
                    stack.pop();
                } else if ("PRINT".equals(operation)) {
                    stack.print();
                } else if ("DEFINE".equals(operation)) {
                    String key = in.next();
                    if(!in.hasNextDouble()) {
                        String msg = "Error: can not define variable";
                        logger.error(msg);
                        throw new Exception(msg);
                    } else {
                        Double value = in.nextDouble();
                        variables.put(key, value);
                    }
                } else {
                    String msg = "Error: unknown operation";
                    logger.error(msg);
                    throw new Exception(msg);
                }
            }
        } while(in.hasNextLine());
    }

    private double addition(double firstArg, double secondArg) {
        return firstArg + secondArg;
    }

    private double subjection(double firstArg, double secondArg) {
        return firstArg - secondArg;
    }

    private double multiplication(double firstArg, double secondArg) {
        return firstArg * secondArg;
    }

    private double diviation(double firstArg, double secondArg) throws Exception {
        if(secondArg == 0) {
            String msg = "Error: division by 0";
            logger.error(msg);
            throw new Exception(msg);
        } else {
            return firstArg / secondArg;
        }
    }

    private double sqrt(double firstArg) throws Exception {
        if(firstArg < 0) {
            String msg = "Error: sqrt on negate argument";
            logger.error(msg);
            throw new Exception(msg);
        } else {
            return java.lang.Math.sqrt(firstArg);
        }
    }
}
