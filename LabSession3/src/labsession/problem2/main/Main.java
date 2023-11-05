package labsession.problem2.main;

import java.util.*;

import labsession.problem2.services.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the binary search tree
        int size = scanner.nextInt();
        
        // Create a new instance of BinarySearchTree
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        
        // Insert nodes into the binary search tree
        while (size-- > 0) {
            binarySearchTree.insertNode(scanner.nextInt());
        }
        
        // Perform in-order traversal on the binary search tree
        binarySearchTree.inOrderTraversal();
        
        // Read the target sum
        int targetSum = scanner.nextInt();
        
        // Find pairs in the binary search tree that add up to the target sum
        binarySearchTree.findPairWithGivenSum(targetSum);
        
        // Close the scanner
        scanner.close();
    }
}