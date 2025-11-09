//package com.adsg.tree.tester;

//import com.adsg.tree.RedBlackTree;

public class RedBlackConsoleTester{
public static void main(String[] args){
RedBlackTree<Integer> myTree=new RedBlackTree<Integer>();
myTree.insert(10);
myTree.insert(5);
myTree.insert(15);
myTree.insert(20);
myTree.insert(30);
myTree.insert(35);
myTree.preOrderTraversal();
myTree.toString();

}

}