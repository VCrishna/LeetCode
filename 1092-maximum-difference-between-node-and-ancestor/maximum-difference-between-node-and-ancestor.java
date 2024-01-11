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
    public int maxAncestorDiff(TreeNode root) {
        // dfs (root, min, max)
        dfs(root, root.val, root.val);
        return result;
    }
    public void dfs(TreeNode root, int min, int max) {
        if(root == null) {
            return;
        }
        // result
		result = Math.max(result, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        // update min and max for the child nodes
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}