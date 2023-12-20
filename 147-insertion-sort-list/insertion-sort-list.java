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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode preInsert;
        ListNode toInsert;

        ListNode current = head;

        while(current != null && current.next != null) {
            if(current.val <= current.next.val) {
                current = current.next;
            }
            else {
                toInsert = current.next;
                // locating preInsert node/position
                preInsert = dummyHead;
                while(preInsert.next.val < toInsert.val) {
                    preInsert = preInsert.next;
                }
                current.next = toInsert.next;
                // insert toInsert after preInsert
                toInsert.next = preInsert.next;
                preInsert.next = toInsert;
            }
        }

        return dummyHead.next;
    }
}
/**
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        while(cur != null) {            
            ListNode start = head;
            //skip all elements from the sorted part which are smaller than the current
            while(start.val <  cur.val && start != cur) {
                start = start.next;
            }            

            int prev = cur.val;
            // insert cur element in its position in the sorted part and move all elements after it  until we reach cur
            while(start != cur.next) {
                int tmp = start.val;
                start.val = prev;
                prev = tmp;
                start = start.next;
            }            
            cur = cur.next;            
        }        
        return head;        
    }
 */
