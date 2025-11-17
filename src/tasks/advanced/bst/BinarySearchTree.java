package tasks.advanced.bst;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value){
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value){
        if (root == null){
            return new TreeNode(value);
        }

        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);
            
        return root;
    }

    public boolean search(int value){
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value){
        if (root == null) return false;
        if (root.value == value) return true;

        return value < root.value
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }

    public void delete(int value){
        root = deleteRec(root, value);
    }

    private TreeNode deleteRec(TreeNode root, int value){
        if (root == null) return null;

        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);

        else {
            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    private int minValue(TreeNode root){
        int min = root.value;
        while (root.left != null){
            root  = root.left;
            min = root.value;
        }
        return min;
    }

    public void inOrder(){
        inOrderRec(root);
        System.out.println();
    }
    private void inOrderRec(TreeNode root){
        if (root != null){
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder(){
        preOrderRec(root);
        System.out.println();
    }
    private void preOrderRec(TreeNode root){
        if (root != null){
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder(){
        postOrderRec(root);
        System.out.println();
    }
    private void postOrderRec(TreeNode root){
        if (root != null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}