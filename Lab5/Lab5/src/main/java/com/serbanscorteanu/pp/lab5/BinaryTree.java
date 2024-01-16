package com.serbanscorteanu.pp.lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTree<T extends Comparable<T>> {
   private Node<T> root;

   public void add(T val) {
       root = insertRec(root, val);
   }

   private Node<T> insertRec(Node<T> root, T val) {
       Node<T> nodeToBeInserted = new Node<T>(val);
       if (root == null) {
           return nodeToBeInserted;
       }
       // I need two pointers to keep count of the previous/parent in order to connect it with the child if needed
       Node<T> currentNode = root;
       Node<T> parentNode;

       while(true) {
           // make the parent equal with current node, so I can go lower down the tree
           parentNode = currentNode;
           // more efficient
           int comparisonValue = val.compareTo(currentNode.val);
           // fast exit
           if (comparisonValue == 0) {
               break;
           }
           // if value is lower go left
           if (comparisonValue < 0) {
               currentNode = currentNode.left;
               // if no more values on the left - insert new node as the lift child of the parent
               if (currentNode == null) {
                   parentNode.left = nodeToBeInserted;
                   break;
               }
           // if values is higher go right
           } else {
               currentNode = currentNode.right;
               // if no more values on the right - insert new node as the right child of the parent
               if (currentNode == null) {
                   parentNode.right = nodeToBeInserted;
                   break;
               }
           }
       }
       return root;
   }

   public void inOrder() {
       inOrderRec(root);
   }

   private void inOrderRec(Node<T> curr) {
       // as long as the current node is not null
       // base case
       if (curr == null) {
           return;
       };

        // recursive case
       // go all the way to the left and start printing afterward
       inOrderRec(curr.left);
       System.out.print(curr.val + " ");
       inOrderRec(curr.right);
   }

   private static class Node<T> {
       T val;
       Node<T> left, right;

       public Node(T val) {
           this.val = val;
       }
   }
}