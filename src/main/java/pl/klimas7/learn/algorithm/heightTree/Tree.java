package pl.klimas7.learn.algorithm.heightTree;

public class Tree
{
  private Node root = null;
  
  public Tree()
  {
    root = new Node();
  }
  /*
          *           Root
         / \
        *   *         P1
       /   / \ 
      *   *   *       P2
         /    /\
        *    *  *     P3
            /\
           *  *       P4
           |
           *          P5
   */
  
  public void buildTree()
  {
    Node p5_1 = new Node(new Node(new Node(),null),null);
    
    Node p4_1 = new Node(p5_1,null);
    Node p4_2 = new Node();
    
    Node p3_1 = new Node();
    Node p3_2 = new Node(p4_1,p4_2);
    Node p3_3 = new Node();
    
    Node p2_1 = new Node();
    Node p2_2 = new Node(p3_1,null);
    Node p2_3 = new Node(p3_2,p3_3);
    
    Node p1_1 = new Node(p2_1,null);
    Node p1_2 = new Node(p2_2,p2_3);
    
    root.setLeftNode(p1_1);
    root.setRigthNode(p1_2);
  }
  
  public Node getRoot()
  {
    return root;
  }
}
