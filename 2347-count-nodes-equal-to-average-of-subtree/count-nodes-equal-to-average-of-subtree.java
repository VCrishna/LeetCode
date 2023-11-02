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
    int avg;
    public int averageOfSubtree(TreeNode root) {
        avg = 0;

        dfs(root);

        return avg;
    }
    public int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};  // {sumSoFar, noOfNodesCount}
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sumSoFar = left[0] + right[0] + root.val;
        int noOfNodesCount = left[1] + right[1] + 1;

        if( sumSoFar / noOfNodesCount == root.val) {
            avg++;
        }

        return new int[]{sumSoFar , noOfNodesCount};
    }
}