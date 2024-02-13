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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = reverseListNode(head, k);
            head.next = reverseKGroup(ptr, k);
            return reversedHead;
        }
        return head;
    }

    public ListNode reverseListNode(ListNode head, int k) {
        ListNode reverseHead = null;
        ListNode tempPtr = head;

        while (k > 0) {
            ListNode currentNext = tempPtr.next;
            tempPtr.next = reverseHead;
            reverseHead = tempPtr;
            tempPtr = currentNext;
            k--;
        }

        return reverseHead;
    }
}