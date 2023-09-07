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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        // Finding the node at position left-1
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Find the nodes at positions left, right, and right+1
        ListNode current = prev.next;
        ListNode next = current.next;
        ListNode tail = current;
        for(int i = left; i< right;i++) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        tail.next = next;
        prev.next = current;
        return dummy.next;
    }
}