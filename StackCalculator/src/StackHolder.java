/**
 * Created by VVykhor on 24.03.2014.
 */

import java.util.Stack;

public class StackHolder {
    private Stack<Double> valuesHolder = new Stack<Double>();

    public void push(double inValue) {
        valuesHolder.push(inValue);
    }

    public double pop() throws Exception {
        if (valuesHolder.empty()) {
            String msg = "Error: no values in stack";
            throw new Exception(msg);
        } else {
            return valuesHolder.pop();
        }
    }

    public void print() throws Exception {
        if (valuesHolder.empty()) {
            String msg = "Error: no values in stack";
            throw new Exception(msg);
        } else {
            System.out.println(valuesHolder.peek());
        }
    }
}
