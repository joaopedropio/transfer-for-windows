
package Arithmetic;
import Stack.*;
/** PostfixEvaluator evaluates the result of a postfix expression */
public class PostfixEvaluator
{ private StringReader reader;  // the postfix expression
  private Stack st;             // a stack to help with the computation

  /** Constructor PostfixEvaluator initializes the evaluator
    * @param r - the postfix expression to be evaluated */
  public PostfixEvaluator(StringReader r)
  { reader = r;
    st = new Stack();
  }

  /** evaluate evaluates the postfix expression to an integer
    * @return the value of the expression supplied to the constructor
    *   method. 
    * @throw RuntimeException if there is a syntax error in the
    *   postfix expression. */
  public int evaluate()
  { char c = reader.nextChar();
    while ( c != StringReader.END_CHAR )
          { if ( c >= '0' && c <= '9' )    // a numeral?
               { st.push(new Integer(c - '0')); }
            else if ( c == '+' )           // an operator?
               { int op2 = popOperand();     // see below for private
                 int op1 = popOperand();     //   method,  popOperand
                 st.push(new Integer(op1 + op2));
               }
            else if ( c == '-' )
               { int op2 = popOperand();
                 int op1 = popOperand();
                 st.push(new Integer(op1 - op2));
               }
            else if ( c == '*' )
               { int op2 = popOperand();
                 int op1 = popOperand();
                 st.push(new Integer(op1 * op2));
               }
            else if ( c == '/' )
               { int op2 = popOperand();
                 int op1 = popOperand();
                 st.push(new Integer(op1 / op2));
               }
            else { throw new RuntimeException(
                                "Input expression syntax error"); }
            
            c = reader.nextChar();
          }
     int answer = popOperand();   // get final answer, which is the sole
     if ( ! st.isEmpty() )        //   value left on the stack
        { throw new RuntimeException("Input expression syntax error"); }
     return answer;
  }

  /** popOperand extracts top value of stack and casts it into an int */
  private int popOperand()
  { return ((Integer)(st.pop())).intValue(); }
}
