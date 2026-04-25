public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);    // RR

        // TODO: Add more insertions to test all 4 rotation cases
        tree.insert(5);
        tree.insert(3);     // LL

        tree.insert(7);     // LR

        tree.insert(23);    // RL

        // TODO: Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // TODO: Add expected results as comments for verification
        /* Expected results:
            Inorder: 3 5 7 10 20 23 30
            Preorder: 10 5 3 7 23 20 30
            Postorder: 3 7 5 20 30 23 10
         */
    }
}