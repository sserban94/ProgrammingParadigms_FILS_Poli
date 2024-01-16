package lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTree<T extends Comparable<T>> {
   private Node<T> root;

   public void add(T val) {
       root = insertRec(root, val);
   }

   private Node<T> insertRec(Node<T> root, T val) {
       //TODO implement insert
       return null;
   }

   public void inOrder() {
       inOrderRec(root);
   }

   private void inOrderRec(Node<T> curr) {
       //TODO implement inorder
   }

   private static class Node<T> {
       T val;
       Node<T> left, right;

       public Node(T val) {
           this.val = val;
       }
   }
}