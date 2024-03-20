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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // Converting list1 and list2 into ArrayLists for easier manipulation
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        // Traversing list1 and list2 to populate the ArrayLists
        while (list1 != null) {
            l1.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            l2.add(list2.val);
            list2 = list2.next;
        }

        // Extracting sublist from list1 before index 'a'
        List<Integer> subList1 = l1.subList(0, a);
        // Extracting sublist from list1 after index 'b'
        List<Integer> subList2 = l1.subList(b + 1, l1.size());

        // Combining sublist2 from list1 and list2
        l2.addAll(subList2);
        subList1.addAll(l2);

        // Creating a dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        // Creating ListNode objects from the merged ArrayList
        for (Integer it : subList1) {
            ListNode temp0 = new ListNode(it);
            temp.next = temp0;
            temp = temp0;
        }

        // Returning the merged list starting 
        // from the next node of the dummy node
        return dummy.next;
    }
}