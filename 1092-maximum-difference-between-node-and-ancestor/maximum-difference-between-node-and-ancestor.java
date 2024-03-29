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
    int result;
    public int maxAncestorDiff(TreeNode root) {
        result = 0;
        // dfs - root, min, max
        dfs(root, root.val, root.val);
        return result;
    }
    public void dfs(TreeNode root, int min, int max) {
        if(root == null) {
            return;
        }
        result = Math.max(result, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}