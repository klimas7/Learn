package pl.klimas7.learn.algorithm.heightTree;

public class Node
{
  private Node leftNode = null;
  private Node rigthNode = null;

  public Node()
  {

  }

  public Node(Node leftNode, Node rightNode)
  {
    this.leftNode = leftNode;
    this.rigthNode = rightNode;
  }

  public boolean hasChilds()
  {
    return leftNode != null || rigthNode != null;
  }

  public void setLeftNode(Node leftNode)
  {
    this.leftNode = leftNode;
  }

  public void setRigthNode(Node rigthNode)
  {
    this.rigthNode = rigthNode;
  }

  public Node getLeftNode()
  {
    return leftNode;
  }

  public Node getRigthNode()
  {
    return rigthNode;
  }
}
