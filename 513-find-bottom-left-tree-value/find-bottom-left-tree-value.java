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
    public int findBottomLeftValue(TreeNode root) {
        // Initializing the result variable to store the value of 
        // the leftmost node in the bottom row
        int result = 0;
        // Checking if the root is null
        if (root == null) {
            return result; // Return 0 if the root is null
        }
        // Creating a queue to perform level order traversal
        Queue<TreeNode> queue = new ArrayDeque<>();
        // Adding the root to the queue to start traversal from the root
        queue.add(root);

        // Performing level order traversal
        while (!queue.isEmpty()) {
            // Getting the number of nodes at the current level
            int size = queue.size();
            // Traversing through all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Retrieving the current node from the queue
                TreeNode current = queue.remove();
                // Adding the left child of the current node to the queue if it exists
                if (current.left != null) {
                    queue.add(current.left);
                }
                // Adding the right child of the current node to the queue if it exists
                if (current.right != null) {
                    queue.add(current.right);
                }
                // If this is the leftmost node at the current level, 
                // updating the result
                if (i == 0) {
                    result = current.val;
                }
            }
        }
        // Returning the value of the leftmost node in the bottom row
        return result;
    }
}
