package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.StdIn;
import algorithm4.stdlib.StdOut;

/******************************************************************************
 *  Compilation:  javac Evaluate.java
 *  Execution:    java Evaluate
 *  Dependencies: Stack.java
 *
 *  Evaluates (fully parenthesized) arithmetic expressions using
 *  Dijkstra's two-stack algorithm.
 *
 *  % java Evaluate
 *  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 *  101.0
 *
 *  % java Evaulate
 *  ( ( 1 + sqrt ( 5 ) ) / 2.0 )
 *  1.618033988749895
 *
 *
 *  Note: the operators, operands, and parentheses must be
 *  separated by whitespace. Also, each operation must
 *  be enclosed in parentheses. For example, you must write
 *  ( 1 + ( 2 + 3 ) ) instead of ( 1 + 2 + 3 ).
 *  See EvaluateDeluxe.java for a fancier version.
 *
 *
 *  Remarkably, Dijkstra's algorithm computes the same
 *  answer if we put each operator *after* its two operands
 *  instead of *between* them.
 *
 *  % java Evaluate
 *  ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + )
 *  101.0
 *
 *  Moreover, in such expressions, all parentheses are redundant!
 *  Removing them yields an expression known as a postfix expression.
 *  1 2 3 + 4 5 * * +
 *
 *
 ******************************************************************************/
public class T_1_3_11_2_Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("(".equals(s))
                ;
            else if ("+".equals(s))
                ops.push(s);
            else if ("-".equals(s))
                ops.push(s);
            else if ("*".equals(s))
                ops.push(s);
            else if ("/".equals(s))
                ops.push(s);
            else if ("sqrt".equals(s))
                ops.push(s);
            else if (")".equals(s)) {
                // diy
//                String op = ops.pop();
//                double v1 = vals.pop();
//                double v2 = vals.pop();
//                if ("+".equals(op))
//                    vals.push(v2 + v1);
//                else if ("-".equals(op))
//                    vals.push(v2 - v1);
//                else if ("*".equals(op))
//                    vals.push(v2 * v1);
//                else if ("/".equals(op))
//                    vals.push(v2 / v1);
//                else if ("sqrt".equals(op))
//                    vals.push(Math.sqrt(v1));

                // reference
                String op = ops.pop();
                double v = vals.pop();
                if ("+".equals(op))
                    v = vals.pop() + v;
                else if ("-".equals(op))
                    v = vals.pop() - v;
                else if ("*".equals(op))
                    v = vals.pop() * v;
                else if ("/".equals(op))
                    v = vals.pop() / v;
                else if ("sqrt".equals(op))
                    v = Math.sqrt(v);
                vals.push(v);
            }
            else
                vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }

}
