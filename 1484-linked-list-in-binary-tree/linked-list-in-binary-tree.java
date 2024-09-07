/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(subPath(head,root)){
            return true;
        }
        if(root == null){
            return false;
        }
        return 
            isSubPath(head, root.left) ||
            isSubPath(head, root.right)
        ;
    }

    public boolean subPath(ListNode listNode, TreeNode treeNode) {
        if(listNode == null) {
            return true;
        }
        if(treeNode == null || listNode.val != treeNode.val) {
            return false;
        }
        return (
            subPath(listNode.next, treeNode.left) ||
            subPath(listNode.next, treeNode.right)
        );
    }
}