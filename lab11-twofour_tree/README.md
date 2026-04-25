Project 2: Implementing a 2-4 Tree

Objective

Implement a 2-4 Tree (as described in Chapter 11) that handles insertions by splitting nodes when they overflow. A 2-4 tree is a multi-way search tree where each internal node has 1, 2, or 3 keys and 2, 3, or 4 children.

Requirements

Create a TwoFourTree.java file containing the TwoFourNode and TwoFourTree classes.
TwoFourNode: This class is more complex than a binary node. It needs:
An array (or list) to store keys (1, 2, or 3 keys).
An array (or list) to store child references (2, 3, or 4 children).
A reference to its parent node (simplifies splitting).
A count of the number of keys currently in the node.
A boolean to track if it's a leaf.
TwoFourTree: Must include:
A root node.
public void insert(int key) - A public method to insert a key.
A private insert method that finds the correct leaf node for insertion.
A split(TwoFourNode node) method to handle node overflow. This is the core challenge. When a node gets 4 keys, it splits: the middle key moves up to the parent, and the node splits into two new nodes. This splitting can propagate up the tree.
public void inorder() - A public method to start the inorder traversal.
A private recursive inorder(TwoFourNode node) method to print the keys in ascending order.
Create a TwoFourTreeDriver.java file to test your implementation.
The driver must insert a sequence of numbers that forces at least one node split, and preferably a multi-level split. A good sequence is: 10, 20, 30, 40, 50, 5, 15, 25, 35.
The driver must print the inorder traversal of the final tree to verify all keys are stored correctly and in order.
Code Templates

Use these templates to get started. The 2-4 Tree is complex; focus on the logic for insertion and splitting. This template is a partial implementation to guide you.
TwoFourTree.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        // 2. Promote middle key to parent
        // 3. Move keys and children appropriately
        // 4. Update parent pointers
        System.out.println("Splitting node with keys: " + node.keys);
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}
TwoFourTreeDriver.java

public class TwoFourTreeDriver {
    public static void main(String[] args) {
        TwoFourTree tree = new TwoFourTree();

        // Test sequence for splits
        int[] keys = {10, 20, 30, 40, 50, 60, 70, 80, 90, 5, 15, 25, 35};

        System.out.println("Inserting keys into 2-4 Tree...");
        for (int key : keys) {
            System.out.println("Inserting: " + key);
            tree.insert(key);
        }

        System.out.println("\nFinal Tree Traversals:");
        tree.inorder();

        // TODO: Students can also implement preorder/postorder traversal for practice

        System.out.println("\nExpected Inorder: 5 10 15 20 25 30 35 40 50 60 70 80 90");
    }
}
