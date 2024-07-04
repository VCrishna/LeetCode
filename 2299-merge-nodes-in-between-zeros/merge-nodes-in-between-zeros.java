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
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int sum = 0;

        head = head.next; // Skip the initial zero node

        while (head != null) {
            if (head.val == 0) {
                if (sum > 0) { // Ensuring we only add nodes with non-zero sum
                    temp.next = new ListNode(sum);
                    temp = temp.next;
                    sum = 0; // Reseting sum after creating a new node
                }
            } else {
                sum += head.val; // Accumulating the sum
            }
            head = head.next; // Moving to the next node
        }

        return result.next;

    }
}