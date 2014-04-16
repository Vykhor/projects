import org.apache.log4j.*;
import java.util.Stack;

/**
 * Created by VVykhor on 24.03.2014.
 */

public class StackHolder {

    static Logger logger = Logger.getLogger(StackHolder.class);
    private Stack<Double> valuesHolder = new Stack<Double>();

    public void push(double inValue) {
        valuesHolder.push(inValue);
    }

    public double pop() throws Exception {
        if (valuesHolder.empty()) {
            String msg = "Error: no values in stack";
            logger.error(msg);
            throw new Exception(msg);
        } else {
            return valuesHolder.pop();
        }
    }

    public void print() throws Exception {
        if (valuesHolder.empty()) {
            String msg = "Error: no values in stack";
            logger.error(msg);
            throw new Exception(msg);
        } else {
            System.out.println(valuesHolder.peek());
        }
    }
}
