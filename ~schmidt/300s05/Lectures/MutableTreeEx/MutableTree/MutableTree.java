
package MutableTree;
/** MutableTree defines the data type of binary trees that can be altered
  *   once they are constructed.  Important: substructures of this form
  *   of tree _cannot_ be shared!
  * Forms of this tree are intended to be:  <br>
  *  (i) a leaf,  which holds the address of its parent node (if any), or  <br>
  *  (ii) a node that holds a value, a left subtree, a right subtree,
  *       and the address of its parent node (if any). <br>
  * Methods listed below should be overridden as needed by subclasses. */
public abstract class MutableTree
{ /** value returns the value held within a tree node
    * @return the value  */ 
  public Object value()
  { throw new RuntimeException("BinaryTree error: no value"); }

  /** left  returns the left subtree of this tree
    * @return the left subtree  */
  public MutableTree left()
  { throw new RuntimeException("BinaryTree error: no left subtree"); }

  /** right  returns the right subtree of this tree
    * @return the right subtree  */
  public MutableTree right()
  { throw new RuntimeException("BinaryTree error: no right subtree"); }

  /** parent  returns the address of the parent node to this tree
    * @return the parent  */
  public abstract Node parent();


  /** setValue resets the value held within a tree node
    * @param v - the new value  */
  public void setValue(Object v)
  { throw new RuntimeException("BinaryTree error: no value to alter"); }

  /** setLeft resets the left subtree of this tree
    * @param t - the new left subtree  */
  public void setLeft(MutableTree t)
  { throw new RuntimeException("BinaryTree error: no left subtree to alter"); }
    
  /** setRight resets the right subtree of this tree 
    * @param t - the new right subtree  */
  public void setRight(MutableTree t)
  { throw new RuntimeException("BinaryTree error: no right subtree to alter"); }

  /** setParent resets the parent of this tree
    * @param p - the new parent (it must be a Node)  */
  public abstract void setParent(Node p);


  /** printContents prints all the values held within a binary tree;
    * the tree is traversed left-to-right _pre-order_ (value printed first),
    * formatted and labelled so that you can see the tree's structure */
  public void printContents()
  { printContentsIndented("", this);  // print the contents of the tree
                         // object to whom this invocation was directed
    System.out.println();
  }

  private void printContentsIndented(String indent, MutableTree t)
  { if ( t instanceof Leaf )
         { System.out.print(indent + "Leaf " + t.toString()); 
           System.out.print(";  parent = ");
           if ( t.parent() == null )
                { System.out.println("null"); }
           else { System.out.println(t.parent().toString()); }
         }
    else { System.out.println(indent + "Node " + t.toString() + "--------");
           String new_indent = indent + "| ";
           System.out.println(new_indent + "value = " + t.value().toString());

           System.out.print(new_indent + "parent = ");
           if ( t.parent() == null )
                { System.out.println("null"); }
           else { System.out.println(t.parent().toString()); }

           System.out.println(new_indent + "left =");
           printContentsIndented(new_indent + "  ", t.left());
           System.out.println(new_indent + "right =");
           printContentsIndented(new_indent + "  ", t.right());
         }
  }
}
