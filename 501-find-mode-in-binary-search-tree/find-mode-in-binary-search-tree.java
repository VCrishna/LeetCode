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

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freqCounter = new HashMap<>();
        dfs(root, freqCounter);
        int maxCount = Integer.MIN_VALUE;
        for (int i : freqCounter.values()) {
            maxCount = Math.max(maxCount, i);
        }
        Set<Integer> s = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : freqCounter.entrySet()) {
            if (entry.getValue() == maxCount) {
                s.add(entry.getKey());
            }
        }
        int[] result = new int[s.size()];
        int index = 0;
        for (int i : s) 
            result[index++] = i;
        return result;
    }

    public static void dfs(TreeNode root, Map<Integer, Integer> freqCounter) {
        if (root == null) {
            return;
        }
        freqCounter.put(root.val, freqCounter.getOrDefault(root.val, 0) + 1);
        dfs(root.left, freqCounter);
        dfs(root.right, freqCounter);
    }
}
