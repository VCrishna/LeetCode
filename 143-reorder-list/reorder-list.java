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

        // Move secondHalf to the middle of the list
        while (secondHalf != null && secondHalf.next != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }

        // Reverse the secondHalf
        ListNode reversedSecondHalf = reverse(firstHalf.next);

        // Break the list after the firstHalf
        firstHalf.next = null;

        // Merge the firstHalf and reversedSecondHalf
        merge(head, reversedSecondHalf);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void merge(ListNode firstHalf, ListNode reversedSecondHalf) {
        while (firstHalf != null && reversedSecondHalf != null) {
            ListNode firstHalfNext = firstHalf.next;
            ListNode reversedSecondHalfNext = reversedSecondHalf.next;

            firstHalf.next = reversedSecondHalf;
            firstHalf = firstHalfNext;

            reversedSecondHalf.next = firstHalfNext;
            reversedSecondHalf = reversedSecondHalfNext;
        }
    }
}
