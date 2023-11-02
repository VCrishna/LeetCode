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
    double average;

    public double maximumAverageSubtree(TreeNode root) {
        average = 0.0;

        dfs(root);

        return average;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) 
            return new int[] { 0, 0 };
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sumSoFar = left[0] + right[0] + root.val;
        int countOfNode = left[1] + right[1] + 1;

        // Calculate the average as a double
        double currentAverage = (double) sumSoFar / countOfNode;

        average = Math.max(average, currentAverage);

        return new int[] { sumSoFar, countOfNode };
    }
}
