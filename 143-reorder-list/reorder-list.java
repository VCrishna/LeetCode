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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = head;

        // Moving secondHalf to the middle of the list
        while (secondHalf != null && secondHalf.next != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }

        // Reversing the secondHalf
        ListNode reversedSecondHalf = reverse(firstHalf.next);

        // Breaking the list after the firstHalf
        firstHalf.next = null;

        // Merging the firstHalf and reversedSecondHalf
        merge(head, reversedSecondHalf);
    }

    public ListNode reverse(ListNode head) {
        // Initializing two pointers: 'prev' to track the reversed list and
        // 'current' to traverse the original list
        ListNode prev = null;
        ListNode current = head;

        // Traversing the original list
        while (current != null) {
            // Saving the next node in the original list
            ListNode next = current.next;

            // Reversing the link by pointing 'current.next' to the previous node
            current.next = prev;

            // Moving 'prev' and 'current' pointers to the next nodes
            prev = current;
            current = next;
        }

        // 'prev' now points to the head of the reversed list
        return prev;
    }

    public void merge(ListNode firstHalf, ListNode reversedSecondHalf) {
        // Merging the two halves by alternating nodes from each half
        while (firstHalf != null && reversedSecondHalf != null) {
            // Saving the next nodes in both halves
            ListNode firstHalfNext = firstHalf.next;
            ListNode reversedSecondHalfNext = reversedSecondHalf.next;

            // Updating the links to connect nodes from the two halves
            firstHalf.next = reversedSecondHalf;
            firstHalf = firstHalfNext;

            // Moving to the next nodes in both halves
            reversedSecondHalf.next = firstHalfNext;
            reversedSecondHalf = reversedSecondHalfNext;
        }
    }

}
