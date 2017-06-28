
import BinTree.*;
/** Test2 constructs a tree with sharing and processes it */
public class Test2
{  public static void main(String[] args)
   { BinaryTree empty = new Leaf();

     BinaryTree x = new Node("a",
                              new Node("b", empty, empty),
                              new Node("c", empty, empty)
                            );

     BinaryTree y = new Node("d", x, x);

     TreeCalculator calc = new TreeCalculator();

     System.out.println(calc.countNodes(y));  // prints 7
     System.out.println();

     calc.printContents(y); // prints 2-D representation of previous line
   }
}
