import java.util.Scanner;
import java.io.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by VVykhor on 24.03.2014.
 */
public class Processor {
    private String sourceFile;
    private StackHolder stack = new StackHolder();

    public void setFile(String fileName) {
        sourceFile = fileName;
    }

    public void execute() throws Exception {
        Scanner in = new Scanner(new File(sourceFile));
        do {
            String operation = in.next();
            System.out.println("Found operation "+operation);
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
                double value = in.nextDouble();
                stack.push(value);
            } else if ("POP".equals(operation)) {
                System.out.println(stack.pop());
            } else {
                System.out.println("Error: unknown operation");
            }
        } while(in.hasNext());
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
            throw new Exception(msg);
        } else {
            return firstArg / secondArg;
        }
    }

    private double sqrt(double firstArg) throws Exception {
        if(firstArg < 0) {
            String msg = "Error: sqrt on negate argument";
            throw new Exception(msg);
        } else {
            return java.lang.Math.sqrt(firstArg);
        }
    }
}
