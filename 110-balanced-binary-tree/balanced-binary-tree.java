/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    // Bottom up approach - O(n)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // since the height of a tree is always greater than or equal to 0
        // we use -1 as a flag to indicate if the subtree is not balanced
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int balance = Math.abs(left - right);
        // left, right subtree is unbalanced or current tree is unbalanced
        if (balance > 1 || left == -1 || right == -1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    // Top Down approach - O(n ^ 2)
    public boolean isBalanced_TD(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height_TD(root.left) - height_TD(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height_TD(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height_TD(root.left), height_TD(root.right));
    }
}
