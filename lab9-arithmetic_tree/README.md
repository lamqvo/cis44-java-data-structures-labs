Objectives

Implement a binary tree structure using a linked representation.
Apply preorder, inorder, and postorder traversals to the tree.
Understand how binary trees can represent complex, ordered data like mathematical expressions.
Practice writing and testing recursive algorithms for binary trees.
Task

You will create a Java program that builds an arithmetic expression tree for the expression ( (3 + 7) * (9 - 4) ). You must implement a BinaryTreeNode class and an ExpressionTreeDriver class to build and traverse the tree.
Template: BinaryTreeNode.java


public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * (Visit Parent, then Left, then Right)
     * This should output Prefix notation.
     */
    public void traversePreorder() {
        // Your code here
        // 1. Print this node's value
        // 2. Recursively call on left child (if not null)
        // 3. Recursively call on right child (if not null)
    }

    /**
     * Performs an inorder traversal starting from this node.
     * (Visit Left, then Parent, then Right)
     * This should output Infix notation (you can add parentheses for clarity).
     */
    public void traverseInorder() {
        // Your code here
        // (Optional: Print "(" before recursing left)
        // 1. Recursively call on left child (if not null)
        // 2. Print this node's value
        // 3. Recursively call on right child (if not null)
        // (Optional: Print ")" after recursing right)
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * This should output Postfix (RPN) notation.
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call on left child (if not null)
        // 2. Recursively call on right child (if not null)
        // 3. Print this node's value
    }
}
Template: ExpressionTreeDriver.java


public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Manually build the tree for: ( (3 + 7) * (9 - 4) )
        //
        //         *
        //        / \
        //       +   -
        //      / \ / \
        //     3  7 9  4
        //
        
        BinaryTreeNode root = new BinaryTreeNode("*");
        
        BinaryTreeNode nodePlus = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");
        
        // --- TO BE COMPLETED BY STUDENT ---
        // Connect root, nodePlus, and nodeMinus
        // root.left = ...
        // root.right = ...
        // nodePlus.parent = ...

        // Create and connect the leaves (operands)
        // BinaryTreeNode node3 = new BinaryTreeNode("3");
        // BinaryTreeNode node7 = new BinaryTreeNode("7");
        // ...
        
        // Connect leaves to their parents (nodePlus and nodeMinus)
        // nodePlus.left = ...
        // nodePlus.right = ...
        // node3.parent = ...


        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();
    }
}
