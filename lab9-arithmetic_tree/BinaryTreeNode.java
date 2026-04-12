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
        System.out.print(value + " ");        // visits parent first
        // 2. Recursively call on left child (if not null)
        if (left != null){
            left.traversePreorder();            // then visit left
        }
        // 3. Recursively call on right child (if not null)
        if (right != null){
            right.traversePreorder();           // then visit right last
        }
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
        if (left != null){
            System.out.print("( ");
            left.traverseInorder();             // visit left first
        }
        // 2. Print this node's value
        System.out.print(value + " ");        // then visit parent
        // 3. Recursively call on right child (if not null)
        if (right != null){
            right.traverseInorder();            // then visit right last
            System.out.print(") ");
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * This should output Postfix (RPN) notation.
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call on left child (if not null)
        if (left != null){
            left.traversePostorder();       // visit left child first
        }
        // 2. Recursively call on right child (if not null)
        if (right != null){
            right.traversePostorder();      // then visit right child
        }
        // 3. Print this node's value
        System.out.print(value + " ");    // then visit parent last
    }
}