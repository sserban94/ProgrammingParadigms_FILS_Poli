package com.serbanscorteanu.pp.practice;

import java.util.ArrayList;
import java.util.List;

public class BST {
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        // if bst is empty
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        // else
        // need two pointers - focused/current pointer and parent to keep track
        // start from the root
        Node focusNode = this.root;
        Node parent;
        // go to the right spot
        while (true) {
            // set the parent same as focus node before going lower in the tree to keep track
            parent = focusNode;
            // if key/value is lower than the one in the current node
            if (key < focusNode.key) {
                // go left
                focusNode = focusNode.leftChild;
                // if left is null
                if (focusNode == null) {
                    // connect the parent with the new node - as the left child
                    parent.leftChild = newNode;
                    // done
                    return;
                }
                // if key/value is equal or higher than the one in current node
            } else {
                focusNode = focusNode.rightChild;
                // if right is null
                if (focusNode == null) {
                    // connect the parent with the new node = as its right child
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public void traverseInOrder(Node focusNode) {
        // check if start node is null
        if (focusNode == null) {
            return;
        }
        traverseInOrder(focusNode.leftChild);
        System.out.println(focusNode);
        traverseInOrder(focusNode.rightChild);
    }

    public void printBSTValuesInSortedArray(Node focusNode) {
        List<Integer> array = new ArrayList<>();
        traverseInOrderAndSaveElement(focusNode, array);
        System.out.println();
        for (Integer elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    private void traverseInOrderAndSaveElement(Node focusNode, List<Integer> array) {
        if (focusNode == null) {
            return;
        }
        traverseInOrderAndSaveElement(focusNode.leftChild, array);
        System.out.println(focusNode);
        array.add(focusNode.key);
        traverseInOrderAndSaveElement(focusNode.rightChild, array);
    }


    public void traversePreOrder(Node focusNode) {
        // check if start node is null
        if (focusNode != null) {
            System.out.println(focusNode);
            traversePreOrder(focusNode.leftChild);
            traversePreOrder(focusNode.rightChild);
        }
    }

    public void traversePostOrder(Node focusNode) {
        // check if start node is null
        if (focusNode != null) {
            System.out.println(focusNode);
            traversePreOrder(focusNode.leftChild);
            traversePreOrder(focusNode.rightChild);
        }
    }

    public Node findNode(int key) {
        if (this.root == null) {
            return null;
        }
        Node focusNode = this.root;
        // while the key hasn't been found yet
        while (focusNode.key != key) {
            // if lower go left
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                // if higher go right
                focusNode = focusNode.rightChild;
            }
            // if not found return null
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }
}
