package tasks.advanced.bst;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order Traversal");
        bst.inOrder();
        System.out.println("Pre-order Traversal");
        bst.preOrder();
        System.out.println("Post-order Traversal");
        bst.postOrder();

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));

        System.out.println("Deleting 20...");
        bst.delete(20);
        bst.inOrder();

        System.out.println("Deleting 30...");
        bst.delete(30);
        bst.inOrder();

        System.out.println("Deleting 50...");
        bst.delete(50);
        bst.inOrder();
    }
}

