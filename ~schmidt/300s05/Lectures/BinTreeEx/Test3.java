
import BinTree.*;
/** Test3 constructs a trees and inserts one more value into it */
public class Test3
{  public static void main(String[] args)
   { BinaryTree empty = new Leaf();
     BinaryTree x = new Node("a",
                              new Node("b", empty, empty),
                              new Node("c", empty, empty)
                            );

     TreeCalculator calc = new TreeCalculator(); 

     BinaryTree z = calc.insertToRight("d", x); // build  z  to be  x  with "d"
     calc.printContents(z);

     calc.printContents(x);
   }
}
