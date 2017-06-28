
package BinTree;
/** Node models a nonempty tree node, holding a value and two subtrees  */
public class Node extends BinaryTree
{ private Object val;
  private BinaryTree left;
  private BinaryTree right;

  /** Constructor Node constructs the tree node
    * @param v - the value held in the node
    * @param l - the left subtree
    * @param r - the right subtree  */
  public Node(Object v, BinaryTree l, BinaryTree r)
  { val = v;
    left = l;
    right = r;
  }

  public Object value()
  { return val; }

  public BinaryTree left()
  { return left; }

  public BinaryTree right()
  { return right; }

  // There are no methods for changing the  left  and  right  links;
  //  we can do without these for quite some time.   A data structure
  //  that lacks methods for altering its private attributes is called
  //  _immutable_.   Immutable trees are useful when a program must
  //  build, maintain, and share multiple trees.
}

