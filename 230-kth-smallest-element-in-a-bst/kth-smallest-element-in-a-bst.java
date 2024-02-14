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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        // Collections.sort(lst);
        return lst.get(k - 1);
    }

    public void inorder(TreeNode root, List<Integer> lst) {
        if (root == null)
            return;
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }
}

/**
 * My Approach
 */
// class Solution {
// List<Integer> lst;
// public int kthSmallest(TreeNode root, int k) {
// lst = new ArrayList<>();
// bst(root,lst);
// Collections.sort(lst);
// return lst.get(k-1);
// }
// public void bst(TreeNode root,List<Integer> lst){
// if(root != null){
// lst.add(root.val);
// }
// if(root.left != null)
// bst(root.left,lst);
// if(root.right != null)
// bst(root.right,lst);
// }
// }