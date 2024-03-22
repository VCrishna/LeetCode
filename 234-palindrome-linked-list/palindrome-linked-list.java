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
    public boolean isPalindrome(ListNode head) {
        // Initializing two pointers slow and fast to traverse the list
        ListNode slow = head, fast = head;

        // Moving fast pointer two steps ahead and slow pointer
        // one step ahead until fast reaches end or null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reversing the second half of the list starting from slow pointer
        slow = reverse(slow);
        fast = head; // Reseting fast pointer to the beginning of the list

        // Traversing both halves simultaneously and check for palindrome
        while (fast.next != null) {
            if (fast.val != slow.val) {
                return false; // If values don't match, it's not a palindrome
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true; // If all values match, it's a palindrome
    }

    // Function to reverse a linked list
    public ListNode reverse(ListNode current) {
        ListNode prev = null; // Initializing previous node as null
        while (current != null) {
            ListNode next = current.next; // Storing next node
            // Reversing the link between current element and previous element
            current.next = prev;
            // Moving prev and current pointers forward
            prev = current;
            current = next;
        }
        return prev; // Returning the new head of the reversed list
    }
}
