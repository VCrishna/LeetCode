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
    int count;
    int[] freqArray;

    public int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        freqArray = new int[10];
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        freqArray[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPalindrome()) {
                count++;
            }
        } else {
            dfs(root.left);
            dfs(root.right);
        }
        freqArray[root.val]--;
    }

    public boolean isPalindrome() {
        int oddCount = 0;

        // Count the number of nodes with odd frequency
        for (int i = 1; i <= 9; i++) {
            if (freqArray[i] % 2 != 0) {
                oddCount++;
            }
        }

        // Ensure at most one node has odd frequency
        return oddCount <= 1;
    }

}