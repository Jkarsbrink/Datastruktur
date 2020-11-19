package com.company.lab2;

public class BinaryTree {
    Node root;

    private static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    public void deleteKey(int key) {
        root = deleteKeyRec(root, key);
    }

    private Node deleteKeyRec(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteKeyRec(root.left, key);
        else if (key > root.key)
            root.right = deleteKeyRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = miniValue(root.right);
            root.right = deleteKeyRec(root.right, root.key);
        }
        return root;
    }

    private int miniValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    //    1. pre-order              done() 😃
    //    2. in-order               done() 😃
    //    3. reverse in-order       done() 😃
    //    4. post-order             done() 😃
    public void printTreeInPreOrder() {
        printTreeInPreOrderRec(root);
    }

    private void printTreeInPreOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            printTreeInPreOrderRec(root.left);
            printTreeInPreOrderRec(root.right);
        }
    }

    public void printTreeInOrder() {
        printTreeInOrderRec(root);
    }

    private void printTreeInOrderRec(Node root) {
        if (root != null) {
            printTreeInOrderRec(root.left);
            System.out.print(root.key + " ");
            printTreeInOrderRec(root.right);
        }
    }

    public void printTreeInReverseOrder() {
        printTreeInReverseOrderRec(root);
    }

    private void printTreeInReverseOrderRec(Node root) {
        if (root != null) {
            printTreeInReverseOrderRec(root.right);
            System.out.print(root.key + " ");
            printTreeInReverseOrderRec(root.left);
        }
    }

    public void printTreeInPostOrder() {
        printTreeInPostOrderRec(root);
    }

    private void printTreeInPostOrderRec(Node root) {
        if (root != null) {
            printTreeInPostOrderRec(root.left);
            printTreeInPostOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }


    public Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key < key)
            return search(root.right, key);
        return search(root.left, key);
    }
}
