package com.company.lab2;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("\nPreOrder");
        tree.printTreeInPreOrder();
        System.out.println("\nInOrder");
        tree.printTreeInOrder();
        System.out.println("\nReverseOrder");
        tree.printTreeInReverseOrder();
        System.out.println("\nPostOrder");
        tree.printTreeInPostOrder();

        System.out.println("\nIn order print: ");
        tree.printTreeInOrder();

        System.out.println("\nDelete 20: ");
        tree.deleteKey(20);
        System.out.println("\nIn order print without 20");
        tree.printTreeInOrder();

        System.out.println("\nDelete 30: ");
        tree.deleteKey(30);
        System.out.println("In order print without 20 and 30");
        tree.printTreeInOrder();

        System.out.println("\nDelete 50: ");
        tree.deleteKey(50);
        System.out.println("In order print without 20, 30 and 50");
        tree.printTreeInOrder();

        System.out.println("\n***************************");
        System.out.println("BUBBLESORT");
        int[] myArray = {12,56,210,14,7,3,80};
        BubbleSort blist = new BubbleSort();
        System.out.println("\nPrinting my list before BubbleSort");
        blist.printArray(myArray);
        System.out.println("\nPrinting my list after BubbleSort");
        blist.bubbleSort(myArray);
        blist.printArray(myArray);
    }
}