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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        List<Integer> lst = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            lst.add(temp.val);
            temp = temp.next;
        }
        // lst.forEach(System.out::println);
        int partitionSize = lst.size() / k;
        int remainder = lst.size() % k;
        int startIndex = 0;
        List<List<Integer>> bigLst = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int endIndex = startIndex + partitionSize + (i < remainder ? 1 : 0);
            // System.out.println(endIndex);
            bigLst.add(lst.subList(startIndex, endIndex));
            startIndex = endIndex;
        }
        // bigLst.forEach(System.out::println);
        for (int i = 0; i < k; i++) {
            ListNode currentListNode = new ListNode(0);
            ListNode dummy = currentListNode;
            for (int num : bigLst.get(i)) {
                ListNode ln = new ListNode(num);
                dummy.next = ln;
                dummy = dummy.next;
            }
            result[i] = currentListNode.next;
        }
        return result;
    }
}
