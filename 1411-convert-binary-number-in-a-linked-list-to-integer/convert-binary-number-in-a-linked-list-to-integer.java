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
    public int getDecimalValue(ListNode head) {
        String str = "";
        while (head != null) {
            str = str + String.valueOf(head.val);
            head = head.next;
        }
        return Integer.parseInt(str, 2);
    }
}