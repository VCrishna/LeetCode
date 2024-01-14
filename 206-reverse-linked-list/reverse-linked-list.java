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
    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode current = head;
        while(current != null) {
            ListNode currentNext = current.next;
            current.next = reversedHead;
            reversedHead = current;
            current = currentNext;
        }
        return reversedHead;
    }
}