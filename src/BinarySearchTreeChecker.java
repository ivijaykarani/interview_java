public class BinarySearchTreeChecker {
    static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static boolean isBinaryTree(BinaryTreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        else {
            if (root.left != null) {
                if (root.left.value > root.value)
                    return false;
                else {
                    boolean status = isBinaryTree(root.left);
                    if (!status)
                        return status;
                }
            }
            if (root.right != null) {
                if (root.right.value < root.value)
                    return false;
                else {
                    return isBinaryTree(root.right);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
