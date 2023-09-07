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
        ListNode dummy = new ListNode(0);
        dummy.next = head; // dummy is linked to head
        ListNode prev = dummy;

        // Finding the node at position left-1
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Find the nodes at positions left, right, and right+1
        ListNode curr = prev.next;
        ListNode next = curr.next;
        ListNode tail = curr;
        for (int i = left; i < right; i++) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        tail.next = next;

        // Link the reversed section back to the original list
        prev.next = curr;

        return dummy.next;
    }
}