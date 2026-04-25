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
        System.out.println("Splitting node with keys: " + node.keys);

        int k0 = node.keys.get(0);
        int k1 = node.keys.get(1); // middle key to promote
        int k2 = node.keys.get(2);
        int k3 = node.keys.get(3);

        // 1. Create a new right node
        TwoFourNode rightNode = new TwoFourNode();

        // 2. Promote middle key to parent
        int middleKey = k1;

        // 3. Move keys and children appropriately
        rightNode.keys.add(k2);
        rightNode.keys.add(k3);

        node.keys.clear();
        node.keys.add(k0);

        if (!node.isLeaf()) {
            List<TwoFourNode> oldChildren = new ArrayList<>(node.children);

            node.children.clear();
            node.children.add(oldChildren.get(0));
            node.children.add(oldChildren.get(1));

            rightNode.children.add(oldChildren.get(2));
            rightNode.children.add(oldChildren.get(3));
            rightNode.children.add(oldChildren.get(4));
        }

        // 4. Update parent pointers
        if (!node.isLeaf()) {
            for (TwoFourNode child : node.children) {
                child.parent = node;
            }

            for (TwoFourNode child : rightNode.children) {
                child.parent = rightNode;
            }
        }

        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(middleKey);
            newRoot.children.add(node);
            newRoot.children.add(rightNode);
            node.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
        } else {
            TwoFourNode parent = node.parent;
            int index = parent.children.indexOf(node);

            parent.keys.add(index, middleKey);
            parent.children.add(index + 1, rightNode);
            rightNode.parent = parent;
        }
//        System.out.println("Splitting node with keys: " + node.keys);
        System.out.println("\tAfter split, root node: " + node.parent.keys);
        System.out.println("\tAfter split, left node: " + node.keys);
        System.out.println("\tAfter split, right node: " + rightNode.keys);
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }
    // Inorder traversal
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
    // Preorder traversal
    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }
    private void preorder(TwoFourNode node) {
        if (node == null) return;

        // Visit keys first
        for (int key : node.keys) {
            System.out.print(key + " ");
        }

        // Then visit children
        for (TwoFourNode child : node.children) {
            preorder(child);
        }
    }
    // Postorder traversal
    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(TwoFourNode node) {
        if (node == null) return;

        // Visit children first
        for (TwoFourNode child : node.children) {
            postorder(child);
        }

        // Then visit keys
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
    }

}
