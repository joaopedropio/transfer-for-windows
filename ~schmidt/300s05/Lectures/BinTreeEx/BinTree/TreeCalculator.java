
package BinTree;
/** TreeCalculator holds some basic methods for computing on BinaryTrees */
public class TreeCalculator
{ public TreeCalculator() { }

  /** countNodes returns the number of Node-objects within a tree
    * @param t - the tree analyzed
    * @return the number of Nodes within  t  */
  public int countNodes(BinaryTree t)
  { int answer;
    if ( t instanceof Leaf )
         { answer = 0; }
    else // t must be a Node:
         { int left_answer = countNodes(t.left());
           int right_answer = countNodes(t.right());
           answer = 1 + left_answer + right_answer;
         }
    return answer;
  }


  /** printPreOrder prints all the values held within a binary tree;
    *  the tree is traversed left-to-right _pre-order_ (value printed first)
    * @param t - the tree traversed and printed  */
  public void printPreOrder(BinaryTree t)
  { if ( t instanceof Leaf )
         { }  // no value to print
    else // t must be a Node:
         { System.out.println( (t.value()).toString() );  // print node's value 
           printPreOrder(t.left());   // print nodes in left subtree
           printPreOrder(t.right());  // print nodes in right subtree
         }
  }


  /** printInOrder prints all the values held within a binary tree;
    *  the tree is traversed left-to-right _in-order_ (value printed in middle)
    * @param t - the tree traversed and printed  */
  public void printInOrder(BinaryTree t)
  { if ( t instanceof Leaf )
         { }  // no value to print
    else // t must be a Node:
         { printInOrder(t.left());   // print nodes in left subtree
           System.out.println( (t.value()).toString() );  // print node's value
           printInOrder(t.right());  // print nodes in right subtree
         }
  }


  /** printContents prints all the values held within a binary tree;
    * the tree is traversed left-to-right pre-order (value printed first),
    * formatted and labelled so that you can see the tree's structure */
  public void printContents(BinaryTree t)
  { printContentsIndented("", t);
    System.out.println();
  }

  /** printContentsIndented prints tree  t  with initial indentation  indent */
  private void printContentsIndented(String indent, BinaryTree t)
  { if ( t instanceof Leaf )
         { System.out.println(indent + "Leaf"); }
    else // t instance of Node:
         { System.out.println(indent + "Node--------");
           String new_indent = indent + "| ";
           // the  toString  method concocts a string value for an object:
           System.out.println(new_indent + "value = " + t.value().toString());
           System.out.println(new_indent + "left =");
           printContentsIndented(new_indent + "  ", t.left());
           System.out.println(new_indent + "right =");
           printContentsIndented(new_indent + "  ", t.right());
         }
  }


  /** insertToRight adds an object as the rightmost node of an existing tree,
    *  that is, in the tree's ``rightmost lower corner''.
    *  It is an exercise to show how we can build a brand new tree from
    *  an existing tree without using  setLeft  and   setRight  methods
    *  on the tree's nodes.
    * @param v - the object to be inserted 
    * @param t - the existing tree
    * @return a newly constructed tree (which shares most of  t!)  that
    *   looks just like  t  except it holds  v  as its rightmost Node.  */
  public BinaryTree insertToRight(Object v, BinaryTree t)
  { BinaryTree answer;
    if ( t instanceof Leaf )
         { answer = new Node(v, new Leaf(), new Leaf()); }
    else // t must be a Node:
         { BinaryTree right_answer = insertToRight(v, t.right());
           // build answer tree by combining existing left subtree with newly
           //  constructed right subtree with existing value in a new Node:
           answer = new Node(t.value(), t.left(), right_answer);
         }
    return answer;
    // Notice that this method does _not_ change any links within tree,  t !
    //  Instead, it builds an  answer  tree that shares most of t's subtrees
    //  and has new Nodes along the path from  answer's  root to where
    //  v  is inserted.  
  }

  /** insertToLeft adds an object as the leftmost node of an existing tree,
    *  that is, in the tree's ``leftmost lower corner''.
    *  It is a mirror image of the above method,  insertToRight.
    * @param v - the object to be inserted
    * @param t - the existing tree
    * @return a newly constructed tree (which shares most of  t!)  that
    *   looks just like  t  except it holds  v  as its leftmost Node.  */
  public BinaryTree insertToLeft(Object v, BinaryTree t)
  { BinaryTree answer;
    if ( t instanceof Leaf )
         { answer = new Node(v, new Leaf(), new Leaf()); }
    else // t must be a Node:
         { BinaryTree left_answer = insertToLeft(v, t.left());
           answer = new Node(t.value(), left_answer, t.right() );
         }
    return answer;
  } 
}

