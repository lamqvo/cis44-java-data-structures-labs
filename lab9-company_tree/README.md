Objectives

Implement a general tree structure using a linked representation.
Apply preorder and postorder traversals to the tree.
Demonstrate understanding of parent–child relationships in trees.
Practice writing and testing recursive algorithms in Java.
Task

You will create a Java program that models a simple company hierarchy. You must implement a GeneralTreeNode class and a CompanyTreeDriver class to build and traverse the tree.
Template: GeneralTreeNode.java


import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        // Your code here
        // 1. Print this node's name
        // 2. Recursively call traversePreorder on each child
    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call traversePostorder on each child
        // 2. Print this node's name
    }
}
Template: CompanyTreeDriver.java


public class CompanyTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Create the root node (e.g., "CEO")
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads (children of root)
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // --- TO BE COMPLETED BY STUDENT ---
        // Add more nodes to build the following hierarchy:
        //
        // CEO
        //  |-- VP of Sales
        //  |    |-- Sales Manager (NA)
        //  |    |-- Sales Manager (EU)
        //  |
        //  |-- VP of Engineering
        //       |-- Dev Team Lead
        //       |    |-- Developer 1
        //       |    |-- Developer 2
        //       |
        //       |-- QA Team Lead

        // Example for "VP of Sales" children:
        // GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        // GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        // vpSales.addChild(salesNA);
        // vpSales.addChild(salesEU);
        
        // ... add children for "VP of Engineering" ...


        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
