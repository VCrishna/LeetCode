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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> a - b
        );
        for(ListNode list : lists) {
            while(list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!minHeap.isEmpty()) {
            temp.next = new ListNode(minHeap.remove());
            temp = temp.next;
        }
        return dummy.next;
    }
}