
package MutableTree;
/** Leaf models a tree leaf---an empty tree  */
public class Leaf extends MutableTree
{ private Node my_parent;

  /** Constructor Leaf constructs the empty tree 
    * @param p - this node's parent  */
  public Leaf(Node p)
  { my_parent = p; }

  public Node parent()
  { return my_parent; }

  public void setParent(Node p)
  { my_parent = p; }
}
