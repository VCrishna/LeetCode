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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        // Variable for Maximum level
        int maxLevel = 1;
        // Variable for Maximum Sum of nodes in a level
        int maxSum = Integer.MIN_VALUE;
        // Queue to store nodes in each level
        Queue<TreeNode> queue = new LinkedList<>();
        // adding root node into queue
        queue.add(root);
        // variable used to track levels
        int level = 0;

        // Iterating until queue is empty or until end of tree
        while (!queue.isEmpty()) {
            // getting size of that level
            int sizeOfLevel = queue.size();
            // increasing level by 1
            level++;
            // variable used to calculate sum of all nodes in that level
            int sum = 0;
            // iterating over each node, calculating sum
            // and checking if it has left or right nodes and adding them to queue
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            // if current sum is greater than maxSum
            // then updating maxSum, maxLevel
            if (sum > maxSum) {
                maxSum = Math.max(sum, maxSum);
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}