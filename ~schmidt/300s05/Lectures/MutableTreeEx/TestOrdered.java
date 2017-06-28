
import MutableOrderedTree.*;
public class TestOrdered
{ public static void main(String[] args)
  {  OrderedTree tree = new OrderedTree();
    
     tree.insert(new IntRecord(8));
     tree.print();

     tree.insert(new IntRecord(6));
     tree.insert(new IntRecord(2));
     tree.insert(new IntRecord(10));
     tree.insert(new IntRecord(4));
     tree.print();

     System.out.println( tree.find(new IntKey(10)) );

     System.out.println( tree.delete(new IntKey(8)));
     tree.print();

     System.out.println( tree.delete(new IntKey(6)));
     tree.print();

     System.out.println( tree.delete(new IntKey(4)));
     tree.print();
  }
}

