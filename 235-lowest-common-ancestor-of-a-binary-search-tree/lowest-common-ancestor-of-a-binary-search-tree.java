/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null, return null.
        if (root == null)
            return root;
        
        // If both nodes, p and q, are less than the current root value,
        // then the lowest common ancestor must be in the left subtree.
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // If both nodes, p and q, are greater than the current root value,
        // then the lowest common ancestor must be in the right subtree.
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // If one node is on the left subtree and the other is on the right subtree
        // or if one of the nodes is the current root itself, then the current root
        // is the lowest common ancestor.
        return root;
    }
}
