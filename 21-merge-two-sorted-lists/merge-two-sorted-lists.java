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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Creating a dummy node as the head of the merged list
        ListNode mergedHead = new ListNode(0);
        // Creating a temporary pointer to traverse and build the merged list
        ListNode temp = mergedHead;

        // Continuing the loop until either list1 or list2 becomes null
        while (list1 != null && list2 != null) {
            // Comparing values of nodes in list1 and list2, 
            // and link the smaller value node to the merged list
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Moving the temporary pointer to the last node in the merged list
            temp = temp.next;
        }

        // Checking if there are remaining nodes in list1 and link them to the merged list
        if (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
        }

        // Checking if there are remaining nodes in list2 and link them to the merged list
        if (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
        }

        // Returning the head of the merged list (skip the dummy node)
        return mergedHead.next;
    }
}
