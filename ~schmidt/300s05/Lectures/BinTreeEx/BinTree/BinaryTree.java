
package BinTree;
/** BinaryTree defines the data type of binary trees:  <p>
  *  (i) a leaf, or  <p>
  *  (ii) a node that holds a value, a left subtree, and a right subtree. <p>
  * Methods listed below should be overridden as needed by subclasses. */
public abstract class BinaryTree
{ /** value returns the value held within a tree node
    * @return the value  */ 
  public Object value()
  { throw new RuntimeException("BinaryTree error: no value"); }

  /** left  returns the left subtree of this tree
    * @return the left subtree  */
  public BinaryTree left()
  { throw new RuntimeException("BinaryTree error: no left subtree"); }

  /** right  returns the right subtree of this tree
    * @return the right subtree  */
  public BinaryTree right()
  { throw new RuntimeException("BinaryTree error: no right subtree"); }
}
