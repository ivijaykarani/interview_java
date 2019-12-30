import java.util.ArrayList;

public class BinarySearchTreeChecker {
    private static BinaryTreeNode root = null;
    private static ArrayList<BinaryTreeNode> elements = new ArrayList<BinaryTreeNode>();
    private static BinaryTreeNode result = null;
    private static int kElement = -1;

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

    public static void insertBinaryTree(int v) {
        BinaryTreeNode node = new BinaryTreeNode(v);
        if (root == null) {
            root = node;
        }
        else {
            insertTree(node, root);
        }
    }

    private static void insertTree(BinaryTreeNode node, BinaryTreeNode currNode) {
        if (node.value > currNode.value) {
            if (currNode.right == null) {
                currNode.right = node;
            }
            else {
                insertTree(node, currNode.right);
            }
        }
        else if (node.value < currNode.value) {
            if (currNode.left == null) {
                currNode.left = node;
            }
            else {
                insertTree(node, currNode.left);
            }
        }
    }

    public static BinaryTreeNode searchBinaryTree(int v) {
        if (root != null) {
            return searchTree(v, root);
        }
        return null;
    }

    private static BinaryTreeNode searchTree(int v, BinaryTreeNode currNode) {
        if (currNode.value == v)
            return currNode;
        else if (v > currNode.value) {
            if (currNode.right == null)
                return null;
            else
                searchTree(v, currNode.right);
        }
        else if (v < currNode.value) {
            if (currNode.left == null)
                return null;
            else
                searchTree(v, currNode.left);
        }
        return null;
    }

    public static void deleteBinaryTree(int v) {
        boolean isBinaryDelete = false;
        if (root.value == v) {
            BinaryTreeNode enode = new BinaryTreeNode(-1);
            enode.right = root;
            root = enode;
            isBinaryDelete = true;
        }

        deleteTree(v, root, root);

        if (isBinaryDelete) {
            BinaryTreeNode enode = root;
            root = root.right;
            enode.right = null;
        }
    }

    private static void deleteTree(int v, BinaryTreeNode currNode, BinaryTreeNode parent) {
        if (v == currNode.value) {
            if ((currNode.left == null) && (currNode.right == null)) {
            }
            else if (currNode.left == null) {
                if (parent.left == currNode)
                    parent.left = currNode.right;
                else
                    parent.right = currNode.right;
            }
            else if (currNode.right == null) {
                if (parent.left == currNode)
                    parent.left = currNode.left;
                else
                    parent.right = currNode.left;
            }
            else {
                BinaryTreeNode n = FindLowestValueNode(currNode.right);
                currNode.value = n.value;
                if (n == currNode.right) {
                    currNode.right = n.right;
                    n.right = null;
                }
                else {
                    currNode.right.left = n.right;
                    n.right = null;
                }
            }
        }
        else if (v > currNode.value) {
            deleteTree(v, currNode.right, currNode);
        }
        else if (v < currNode.value) {
            deleteTree(v, currNode.left, currNode);
        }
    }

    private static BinaryTreeNode FindLowestValueNode(BinaryTreeNode currNode) {
        if (currNode.left == null)
            return currNode;
        else
            return FindLowestValueNode(currNode.left);
    }

    public static boolean validateBinaryTree() {
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBinaryTree(BinaryTreeNode currNode, int min, int max) {
        if (currNode == null)
            return true;
        if (currNode.value < min || currNode.value > max)
            return false;

        return isBinaryTree(currNode.left, min, currNode.value-1) && isBinaryTree(currNode.right, currNode.value+1, max);
    }

    public static void preorderT() {
        preorderTree(root);
    }
    private static void preorderTree(BinaryTreeNode currNode) {
        if (currNode != null)
            System.out.print(currNode.value + " ");
        if (currNode.left != null)
            preorderTree(currNode.left);
        if (currNode.right != null)
            preorderTree(currNode.right);
    }

    public static void inorderT() {
        inorderTree(root);
    }
    private static void inorderTree(BinaryTreeNode currNode) {
        if (currNode.left != null) {
            inorderTree(currNode.left);
        }
        System.out.print(currNode.value + " ");
        if (currNode.right != null)
            inorderTree(currNode.right);
    }

    public static void postorderT() {
        postorderTree(root);
    }
    private static void postorderTree(BinaryTreeNode currNode) {
        if (currNode.left != null)
            postorderTree(currNode.left);
        if (currNode.right != null)
            postorderTree(currNode.right);
        System.out.print(currNode.value + " ");
    }

    public static int find2ndSmallestElement() {
        kElement = 2;
        result = null;
        find2ndSmallestTree(root);
        if (result != null) {
            return result.value;
        }
        return -1;
    }
    private static void find2ndSmallestTree(BinaryTreeNode currNode) {
        if (currNode.left != null && result == null) {
            find2ndSmallestTree(currNode.left);
        }
        kElement--;
        if (kElement == 0) {
            result = currNode;
            return;
        }

        if(currNode.right != null && result == null) {
            find2ndSmallestTree(currNode.right);
        }
    }

    public static int findKthLargestElement(int kvalue) {
        kElement = kvalue;
        result = null;
        findKthLargestTree(root);
        if (result != null) {
            return result.value;
        }
        return -1;
    }
    private static void findKthLargestTree(BinaryTreeNode currNode) {
        if (currNode.right != null && result == null)
            findKthLargestTree(currNode.right);
        kElement--;
        if (kElement == 0) {
            result = currNode;
            return;
        }
        if (currNode.left != null && result == null)
            findKthLargestTree(currNode.left);
    }

    public static void main(String[] args) {

    }
}
