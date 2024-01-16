package com.serbanscorteanu.pp.practice;

public class BinaryTreePracticeSerban {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.addNode(50, "Boss");
        bst.addNode(25, "Vice President");
        bst.addNode(15, "Office Manager");
        bst.addNode(30, "Secretary");
        bst.addNode(75, "Sales Manager");
        bst.addNode(85, "Salesman 1");

//        bst.traverseInOrder(bst.root);
//        System.out.println();
//        bst.traversePreOrder(bst.root);
//        System.out.println();
//        bst.traversePostOrder(bst.root);
//        System.out.println();
//
//        System.out.println(bst.findNode(30));
//        System.out.println(bst.findNode(29));

        bst.printBSTValuesInSortedArray(bst.root);

    }
}
