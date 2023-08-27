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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // head is at the beginning of the left half
        // temp is at the end of left half
        // temp.next is set to null and making it as the end of first half
        temp.next = null;
        // slow is at the beginning of the right half
        // fast is at the end of right half
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);

        return megerSort(left_side, right_side);
    }
    public ListNode megerSort(ListNode left, ListNode right) {
        ListNode sorted_temp = new ListNode(0);
        ListNode current = sorted_temp;

        while(left != null && right != null) {
            if(left.val < right.val) {
                current.next = left;
                left = left.next;
            }
            else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if(left != null) {
            current.next = left;
            left = left.next;
        }
        if(right != null) {
            current.next = right;
            right = right.next;
        }

        return sorted_temp.next;
    }
}
