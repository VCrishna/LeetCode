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
        // Creating a dummy node to simplify the creation of the result linked list
        ListNode dummy = new ListNode(0);

        // Separate pointer to build the result linked list
        ListNode resultPointer = dummy;
        
        // Pointers to the current nodes in the input lists l1 and l2
        ListNode n1 = l1;
        ListNode n2 = l2;

        int carry = 0;
        
        // Looping until both input lists are exhausted
        while (n1 != null || n2 != null) {
            // Initializing sum with the current carry
            int sum = carry;
            
            // If there are still nodes in n1, 
            // adding their value to sum and move to the next node
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            // If there are still nodes in n2, 
            // adding their value to sum and move to the next node
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }

            // Creating a new node with the value sum % 10 and attaching it to the result linked list
            resultPointer.next = new ListNode(sum % 10);
            // Moving the resultPointer to the newly added node
            resultPointer = resultPointer.next;
            
            // Updating carry for the next iteration
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
