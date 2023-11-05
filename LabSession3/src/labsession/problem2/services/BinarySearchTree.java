package labsession.problem2.services;

import java.util.HashSet;

/**
 * BinarySearchTree class represents a binary search tree data structure.
 */
public class BinarySearchTree {
    private Node root;

    /**
     * Node class represents a node in the binary search tree.
     */
    private class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    /**
     * Constructor for BinarySearchTree class.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a node with the given value into the binary search tree.
     *
     * @param val the value to be inserted
     */
    public void insertNode(int val) {
        root = insertNode(root, val);
    }

    /**
     * Private helper method to recursively insert a node with the given value into the binary search tree.
     *
     * @param node the current node
     * @param val  the value to be inserted
     * @return the modified node
     */
    private Node insertNode(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.data) {
            node.left = insertNode(node.left, val);
        } else if (val > node.data) {
            node.right = insertNode(node.right, val);
        }
        return node;
    }

    /**
     * Performs in-order traversal of the binary search tree.
     */
    public void inOrderTraversal() {
        System.out.print("Inorder traversal : ");
        inOrderTraversal(root);
        System.out.println();
    }

    /**
     * Private helper method to recursively perform in-order traversal of the binary search tree.
     *
     * @param node the current node
     */
    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    /**
     * Finds a pair of nodes in the binary search tree that sum up to the given value.
     *
     * @param sum the target sum
     */
    public void findPairWithGivenSum(int sum) {
        HashSet<Integer> set = new HashSet<>();
        set.clear();
        Integer num = findPair(root, set, sum);
        if (num != null) {
            System.out.println("Tree contains pair: (" + num + ", " + (sum - num) + ") with sum: " + sum);
        } else {
            System.out.println("Pair not available.");
        }
    }

    /**
     * Private helper method to recursively find a pair of nodes with the given sum in the binary search tree.
     *
     * @param node the current node
     * @param set  the set to store visited nodes
     * @param sum  the target sum
     * @return the value of one node in the pair, if found; otherwise, null
     */
    private Integer findPair(Node node, HashSet<Integer> set, int sum) {
        if (node == null) {
            return null;
        }
        Integer left = findPair(node.left, set, sum);
        if (left != null) {
            return left;
        }
        if (set.contains(sum - node.data)) {
            return node.data;
        }
        set.add(node.data);
        Integer right = findPair(node.right, set, sum);
        if (right != null) {
            return right;
        }
        return null;
    }
}