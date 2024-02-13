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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            map.put(current.val, map.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }
        ListNode previous = newHead;
        current = head;
        while (current != null) {
            if (map.get(current.val) > 1) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return newHead.next;
    }
}