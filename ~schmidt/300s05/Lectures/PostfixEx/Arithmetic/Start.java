
package Arithmetic;
import Stack.*;
import javax.swing.*;
/** Start translates an infix expression into postfix and evaluates it.
  * Input: a fully parenthesized infix arithmetic expression,
  *   with only single-digit numbers and no blanks.
  *   E.g.,  ((3+4)*5)   but not  33+4+5
  * Output: the postfix translation and the computed result of the 
  *   expression */
public class Start
{ public static void main(String[] args)
  { // Step 1: read the infix expression and translate to postfix:
    String input = JOptionPane.showInputDialog(
                    "Type a fully parenthesized expression (no blanks):");
    PostfixTranslator t = new PostfixTranslator(new StringReader(input));
    String postfix = t.translate();
    JOptionPane.showMessageDialog(null, 
                   "The postfix translation is: " + postfix);

    // Step 2: evaluate the postfix expression:
    PostfixEvaluator e = new PostfixEvaluator(new StringReader(postfix));
    int answer = e.evaluate();
    JOptionPane.showMessageDialog(null, "The answer is: " + answer);
  }
}


