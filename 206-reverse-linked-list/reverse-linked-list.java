/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // Initialize the head of the reversed list as null
        ListNode reversedHead = null;
        // Initialize a pointer to traverse the original list
        ListNode current = head;

        // Continuing the loop until the end of the original list is reached
        while (current != null) {
            // Saving the next node in the original list
            ListNode currentNext = current.next;
            // Updating the next pointer to point to the reversed list
            current.next = reversedHead;
            // Moving the reversed head to the current node
            reversedHead = current;
            // Moving to the next node in the original list
            current = currentNext;
        }
        // Returning the head of the reversed list
        return reversedHead;
    }
}