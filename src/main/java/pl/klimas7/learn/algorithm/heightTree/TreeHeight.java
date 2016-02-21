package pl.klimas7.learn.algorithm.heightTree;

public class TreeHeight
{

  public static int getHeight(Node node)
  {
    if (node == null || !node.hasChilds())
      return 0;

    int lh = getHeight(node.getLeftNode());
    int rh = getHeight(node.getRigthNode());

    return Math.max(lh,rh) + 1;
  }

}
