package pl.klimas7.learn.algorithm.heightTree;

import java.util.HashMap;

public class MainClass
{

  public static void main(String[] args)
  {
    HashMap<MapTest, Integer> test = new HashMap<MapTest, Integer>();
    test.put(new MapTest("1","2","3"),Integer.valueOf(1));
    test.put(new MapTest("1","2","4"),Integer.valueOf(2));
    
    Tree tree = new Tree();
    tree.buildTree();
    
    System.out.println("Tree has height: " + TreeHeight.getHeight(tree.getRoot()));
  }

}
