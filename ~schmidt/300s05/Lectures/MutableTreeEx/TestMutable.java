
import MutableTree.*;
/** TestMutable constructs a mutable tree in stages and deletes a node from it.
  *  IMPORTANT:  when working with a mutable tree, sharing is never allowed! */
public class TestMutable
{  public static void main(String[] args)
   { // build a Node that holds "b" and two leaves:
     Leaf empty1 = new Leaf(null);
     Leaf empty2 = new Leaf(null);
     Node btree = new Node(null, "b", empty1, empty2);
     empty1.setParent(btree);   // connect leaves to parent node
     empty2.setParent(btree);

     // let's place the previous instructions into a helper method,
     // makeNewNode,  and let that method do the tedious work:
     Node ctree = makeNewNode(null, "c");  // build a tree that holds just "c"

     // now, make a node that holds "a" and uses btree and ctree as subtrees:
     Node atree = new Node(null, "a", btree, ctree);
     btree.setParent(atree);
     ctree.setParent(atree);

     atree.printContents();

     // add  "d"  as  ctree's  left subtree---no tree traversal needed;
     // we just reset a link:
     if ( ctree.left() instanceof Leaf )  // verify that we can attach  dtree
        { Node dtree = makeNewNode(ctree, "d");
          ctree.setLeft(dtree);
        }

     atree.printContents();

     
     // let's delete "b" from the tree without traversing the entire tree:
     Node bparent = btree.parent();
     if ( bparent != null )  // verify that  btree  is not the root
        { Leaf replacement = new Leaf(bparent); 
          if ( bparent.left() == btree )  // is btree its parent's left subtree?
               { bparent.setLeft(replacement); }
          else // it's the right subtree of its parent:
               { bparent.setRight(replacement); }
        }

     atree.printContents();
  }


  /** makeNewNode builds a Node that holds  value  and links to  parent */
  private static Node makeNewNode(Node parent, Object value)
  { Leaf empty1 = new Leaf(null);
    Leaf empty2 = new Leaf(null);
    Node new_node = new Node(parent, value, empty1, empty2);
    empty1.setParent(new_node);   // connect leaves to parent node
    empty2.setParent(new_node);
    return new_node;
  }
}

