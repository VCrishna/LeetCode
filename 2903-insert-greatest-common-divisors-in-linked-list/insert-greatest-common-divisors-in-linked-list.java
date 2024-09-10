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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Initializing a pointer to traverse the list
        ListNode current = head;
        // Traversing the list while there are at least two consecutive nodes
        while (current != null && current.next != null) {
            // Finding the GCD of the current node and the next node
            int gcdVal = findGCD(current.val, current.next.val);
            
            // Creating a new node with the GCD value
            ListNode gcdNode = new ListNode(gcdVal);
            
            // Inserting this GCD node between the current node and the next node
            gcdNode.next = current.next;
            current.next = gcdNode;
            
            // Moving the pointer two steps forward (skip the newly inserted GCD node)
            current = gcdNode.next;
        }
        // Returning the modified list starting from the original head
        return head;
    }
    // This method calculates the Greatest Common Divisor (GCD) of two integers using the subtraction-based Euclidean algorithm.
    public static int findGCD(int a, int b) {  
        // Loop continues as long as b is not zero. 
        // The GCD algorithm works until one of the numbers is reduced to 0.
        while (b != 0) {  
            // If a is greater than b, subtract b from a
            if (a > b) {
                a = a - b;
            } 
            // Otherwise, subtract a from b
            else {
                b = b - a;
            }
        }
        // Once b becomes 0, return a as the GCD
        return a;
    }

}