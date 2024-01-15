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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        // Separate pointer to build the result linked list
        ListNode resultPointer = dummy;

        ListNode n1 = l1;
        ListNode n2 = l2;

        int carry = 0;

        while (n1 != null || n2 != null) {
            int sum = carry;

            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }

            // Creating a new node with the value and attach it to the result linked list
            resultPointer.next = new ListNode(sum % 10);
            // Moving the resultPointer to the newly added node
            resultPointer = resultPointer.next;

            carry = sum / 10;
        }

        // If there's a carry after processing all nodes, 
        // appending a new node with the carry
        if (carry != 0) {
            resultPointer.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
