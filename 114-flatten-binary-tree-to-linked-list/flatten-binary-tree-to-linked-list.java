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
    public void flatten(TreeNode root) {
        // Base case: If the root is null, return as there's nothing to flatten
        if (root == null) {
            return;
        }

        // Flatten the left subtree recursively
        flatten(root.left);

        // Flatten the right subtree recursively
        flatten(root.right);

        // Save the right subtree of the current node
        TreeNode rightSubtree = root.right;

        // Make the left subtree the right subtree of the current node
        root.right = root.left;
        root.left = null;

        // Find the end of the current flattened subtree
        while (root.right != null) {
            root = root.right;
        }

        // Attach the right subtree to the end of the current flattened subtree
        root.right = rightSubtree;
    }
}