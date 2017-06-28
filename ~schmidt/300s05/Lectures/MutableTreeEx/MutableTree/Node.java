
package MutableTree;
/** Node models a nonempty tree node, holding a value, two subtrees, and
  *  a link to this Node's parent Node  */
public class Node extends MutableTree
{ private Object val;
  private MutableTree left;
  private MutableTree right;
  private Node my_parent;

  /** Constructor Node constructs the tree node
    * @param p - this node's parent node
    * @param v - the value held in the node
    * @param l - the left subtree
    * @param r - the right subtree  */
  public Node(Node p, Object v, MutableTree l, MutableTree r)
  { my_parent = p;
    val = v;
    left = l;
    right = r;
  }

  public Object value()
  { return val; }

  public MutableTree left()
  { return left; }

  public MutableTree right()
  { return right; }

  public Node parent()
  { return my_parent; }

  public void setValue(Object v)
  { val = v; }

  public void setLeft(MutableTree t)
  { left = t; }

  public void setRight(MutableTree t)
  { right = t; }

  public void setParent(Node p)
  { my_parent = p; }

}

