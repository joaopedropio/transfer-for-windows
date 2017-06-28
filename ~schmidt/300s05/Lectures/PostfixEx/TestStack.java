
import Stack.*;
/** TestStack does simple tests of stacks.  */
public class TestStack
{ public static void main(String[] args)
  { // push and pop some integers:
    Stack s1 = new Stack();
    // wrap the integers:
    Integer i1 = new Integer(1);
    Integer i2 = new Integer(2);
    // push them:
    s1.push(i1);
    s1.push(i2);
    // pop one:
    Object ob = s1.pop();
    int v = ((Integer)ob).intValue();
    System.out.println(v);  // prints 2
    System.out.println(s1.isEmpty());  // prints false
    s1.push(new Integer(3));

    // push some strings:
    Stack s2 = new Stack();
    s2.push("A");   // in Java, strings are already objects
                   //  and don't require wrappers
    s2.push("B");
    s2.push("C");
    String w = (String)(s2.pop());

    // push some other objects:
    Stack s3 = new Stack();
    s3.push(s1);  // any object can be pushed onto a stack
    s3.push(s2);
    Stack x = (Stack)(s3.pop());
    Object y = x.pop();
    // perhaps we forgot what form of objects are in stack  x:
    if ( y instanceof Integer )
         { System.out.println( ((Integer)y).intValue() ); }
    else if ( y instanceof String )
         { System.out.println( (String)y ); }
    else { System.out.println( y.toString() ); }  // if you are desperate,
                                                  //   try this trick!
  }
}

