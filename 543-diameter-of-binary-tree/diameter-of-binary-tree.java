/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    public int dfs(TreeNode current) {
        if (current == null) {
            return 0;
        }
        // recursively finding the longest path in
        // both left child and right child
        int left = dfs(current.left);
        int right = dfs(current.right);
        // updating the diameter if left_path plus right_path is larger
        result = Math.max(result, (left + right));
        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return 1 + Math.max(left, right);
    }
}