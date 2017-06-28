
import BinTree.*;
/** Test constructs some trees and tests a node-counting function */
public class Test
{  public static void main(String[] args)
   { // We can build a tree from scratch:
     BinaryTree x = new Node("a",
                              new Node("b", new Leaf(), new Leaf()),
                              new Node("c", new Leaf(), new Leaf()));
     // Or, we can reuse existing trees:
     BinaryTree y = new Leaf();
     BinaryTree z = new Node("d", x, y);

     // We can make all leaves be the same shared object:
     BinaryTree empty = new Leaf();
     BinaryTree a = new Node("e", empty, empty);
     BinaryTree b = new Node("f", empty, new Node("g", a, empty));

     // For that matter, we might share significant substructure of the trees:
     BinaryTree c = new Node("h", b, b);

     // Important: c's assignment is sensible only because the BinaryTrees
     //  built here are _immutable_: once constructed, they cannot be altered!

     // When you write an application that manipulates multiple trees and
     //  has sharing, like that above, you must use immutable trees.


     // Let's calculate on some trees:
     TreeCalculator calc = new TreeCalculator();   // holds some basic methods

     System.out.println(calc.countNodes(c));  // prints 7
     System.out.println();

     calc.printInOrder(c);  // prints "f e g h f e g"
     System.out.println();

     calc.printPreOrder(c); // prints "h e f g e f g"
     System.out.println();
     calc.printContents(c); // prints 2-D representation of previous line

     BinaryTree d = calc.insertToRight("i", c); // build  d  to be  c  with "i"
     calc.printContents(d);
   }
}
