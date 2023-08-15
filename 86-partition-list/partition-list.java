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
    public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode();
        ListNode before = result;
        ListNode after = new ListNode();
        ListNode afterTemp = after;

        while(head != null) {
            if(head.val < x) {
                ListNode b1 = new ListNode(head.val);
                before.next = b1;
                before = b1;
            }
            else{
                ListNode a1 = new ListNode(head.val);
                afterTemp.next = a1;
                afterTemp = a1;
            }
            head = head.next;
        }
        before.next = after.next;
        return result.next;
    }
}