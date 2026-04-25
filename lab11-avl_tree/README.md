Project 1: Implementing an AVL Tree

Objective

Implement a self-balancing AVL Tree to handle insertions, update node heights, and perform single (left, right) and double (left-right, right-left) rotations to maintain the balance factor of each node within {-1, 0, 1}.

Requirements

Create an AVLTree.java file containing the AVLNode and AVLTree classes.
AVLNode: Should store an integer key, height, and references to left and right children.
AVLTree: To include:
public void insert(int key) - A public method to insert a key.
A private recursive insert method that returns the new root of the subtree.
Methods to get height and balanceFactor of a node.
Methods for rightRotate, leftRotate, leftRightRotate, and rightLeftRotate.
The insert logic must check the balance factor and perform the correct rotation(s) upon imbalance.
public void preorder(), public void inorder(), public void postorder() - Public methods to start traversals.
Private recursive methods for each traversal.
Create a AVLTreeDriver.java file to test your implementation.
The driver inserts a sequence of numbers that specifically triggers all four types of rotations (or at least one single and one double rotation). A good sequence is: 10, 20, 30 (triggers left rotate), 5, 4 (triggers right rotate), 8 (triggers left-right rotate), 25 (triggers right-left rotate).
The driver prints all three traversals (preorder, inorder, postorder) of the final tree.

Code Templates

Use these templates to get started. You must complete the implementations.
AVLTree.java

// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        // TODO: Initialize key, height, left, and right
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        return 0; // placeholder
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        return 0; // placeholder
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        return 0; // placeholder
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        return null; // placeholder
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        return null; // placeholder
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        return null; // placeholder
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        return null; // placeholder
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        return null; // placeholder
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        // placeholder
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        // placeholder
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        // placeholder
    }
}

AVLTreeDriver.java


public class AVLTreeDriver {

    public static void main(String[] args) {
    
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        // TODO: Add more insertions to test all 4 rotation cases

        // TODO: Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // TODO: Add expected results as comments for verification
    }
}
