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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        // Checking if the "tree rooted at root" 
        // is identical to "tree roooted at subRoot"
        else if(isSameTree(root,subRoot)){
            return true;
        }
        // If not, check for "tree rooted at root.left" and "tree rooted at root.right"
        // If either of them returns true, return true
        else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        // If any of the nodes is null, then both must be null
        if(root == null || subRoot == null){
            return root == null && subRoot == null;
        }
        // If both nodes are non-empty, then they are identical only if
        // 1. Their values are equal
        // 2. Their left subtrees are identical
        // 3. Their right subtrees are identical
        else if(root.val == subRoot.val){
            return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
        }
        else{
            return false;
        }
    }
}