
import BinTree.*;
/** Test constructs some trees and tests a node-counting function */
public class Test1
{  public static void main(String[] args)
   { BinaryTree x = new Node("a",
                              new Node("b", new Leaf(), new Leaf()),
                              new Node("c", new Leaf(), new Leaf()));

     // Let's calculate on x:
     TreeCalculator calc = new TreeCalculator();   // holds some basic methods

     System.out.println(calc.countNodes(x));  // prints 3
     System.out.println();

     calc.printPreOrder(x); // prints "a b c"
     System.out.println();

     calc.printInOrder(x);  // prints "b a c"
     System.out.println();

     calc.printContents(x); // prints 2-D representation of previous line
   }
}
