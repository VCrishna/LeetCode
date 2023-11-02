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
    // Initialize a variable to keep track of the maximum average.
    double maxAverage;

    public double maximumAverageSubtree(TreeNode root) {
        // Initialize the maxAverage to 0.0
        maxAverage = 0.0;
        
        // Start the depth-first search from the root of the tree.
        dfs(root);

        // Return the maximum average found in the tree.
        return maxAverage;
    }

    public int[] dfs(TreeNode root) {
        // If the current node is null, return [0, 0] indicating sum and count are both zero.
        if (root == null)
            return new int[] { 0, 0 }; 
        
        // Recursively calculate the sum and count for the left subtree.
        int[] left = dfs(root.left);
        // Recursively calculate the sum and count for the right subtree.
        int[] right = dfs(root.right);

        // Calculate the sum of values in the current subtree.
        int sumSoFar = left[0] + right[0] + root.val; 
        // Calculate the count of nodes in the current subtree, including the current node.
        int countOfNode = left[1] + right[1] + 1; 

        // Calculate the average as a double to preserve decimal values.
        double currentAverage = (double) sumSoFar / countOfNode;

        // Update the maxAverage with the maximum value found so far.
        maxAverage = Math.max(maxAverage, currentAverage);
        
        // Return the sum and count of the current subtree for use in the parent node's calculation.
        return new int[] { sumSoFar, countOfNode };
    }
}

