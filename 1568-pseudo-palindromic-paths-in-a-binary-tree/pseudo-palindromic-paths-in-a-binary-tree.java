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
    // Counter for pseudo-palindromic paths
    int count;
    // Array to store frequency of each digit (0 to 9)
    int[] freqArray;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        freqArray = new int[10];
        dfs(root);
        return count;
    }

    // Depth-first search to traverse the binary tree
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // Incrementing the frequency of the current node's value
        freqArray[root.val]++;

        // If the current node is a leaf node (has no left and right children)
        if (root.left == null && root.right == null) {
            // Incrementing count if the path is pseudo-palindromic
            if (isPalindrome()) {
                count++;
            }
        } else {
            dfs(root.left);   // Recursively exploring left subtree
            dfs(root.right);  // Recursively exploring right subtree
        }
        // Backtrack: decrement the frequency of the current node's value
        freqArray[root.val]--;
    }

    // Checking whether the current path is pseudo-palindromic
    public boolean isPalindrome() {
        int oddCount = 0;

        // Counting the number of nodes with odd frequency
        for (int i = 1; i <= 9; i++) {
            if (freqArray[i] % 2 != 0) {
                oddCount++;
            }
        }

            // Ensuring at most one node has odd frequency for the path to be pseudo-palindromic
        return oddCount <= 1;
    }
}