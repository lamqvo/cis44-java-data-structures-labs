// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        // TODO: Initialize key, height, left, and right
        this.key = key;
        this.height = 1;    // new node starts at height 1
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return N.height; // placeholder
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a: b; // placeholder
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        if (N == null){
            return 0;
        }
        return height(N.left) - height(N.right); // placeholder
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode z) {
        AVLNode y = z.left;
        AVLNode T3 = y.right;

        // rotate right
        y.right = z;
        z.left = T3;

        // update heights
        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y; // return root
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // rotate left
        y.left = x;
        x.right = T2;

        // update heights
        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y; // new root
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z); // placeholder
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y); // placeholder
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        // 1. Standard BST Insertion (Base Case)
        if (node == null){
            return new AVLNode(key);
        }
        if (key < node.key){
            node.left = insert(node.left, key);
        }
        else if (key > node.key){
            node.right = insert(node.right, key);
        }
        else {
            return node;
        }

        // 2. Update Height of the Current Node
        // Height is calculated from the height of its taller child plus 1
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Check Balance Factor
        int balance = getBalance(node);

        // 4. Perform Rotations if Unbalanced (Balance Factor > 1 or < -1)

        // Case 1: Left Left (LL) - Requires a Single Right Rotation
        // LL case: balance > 1 AND key < left.key
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Case 2: Right Right (RR) - Requires a Single Left Rotation
        // RR case: balance < -1 AND key > right.key
        if (balance < -1 && key > node.right.key){
            return leftRotate(node);
        }

        // Case 3: Left Right (LR) - Requires a Double Rotation (Left then Right)
        // LR case: balance > 1 AND key > left.key
        if (balance > 1 && key > node.left.key){
//            node.left = leftRotate(node.left);
            return leftRightRotate(node);
        }

        // Case 4: Right Left (RL) - Requires a Double Rotation (Right then Left)
        // RL case: balance < -1 AND key < right.key
        if (balance < -1 && key < node.right.key){
//            node.right = rightRotate(node.right)
            return rightLeftRotate(node);
        }

        return node; // placeholder
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        // placeholder
        if (node != null){
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        // placeholder
        if (node != null){
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        // placeholder
        if (node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}
