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
        // result variable
        ListNode[] result = new ListNode[k];
        // lst stores all the numbers of linked list
        List<Integer> lst = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            lst.add(temp.val);
            temp = temp.next;
        }
        // lst.forEach(System.out::println);
        // Size of each partition
        int partitionSize = lst.size() / k;
        // remainder is used to add extra elements into the sub lists
        int remainder = lst.size() % k;
        // variable used to keep track of starting index for each sub list
        int startIndex = 0;
        List<List<Integer>> bigLst = new ArrayList<>();
        // as we need to divide given linkedlist into k sublists so we iterate until k
        for (int i = 0; i < k; i++) {
            // calculating end index
            int endIndex = startIndex + partitionSize + (i < remainder ? 1 : 0);
            // System.out.println(endIndex);
            // adding sublist from start to end and updating start index
            bigLst.add(lst.subList(startIndex, endIndex));
            startIndex = endIndex;
        }
        // bigLst.forEach(System.out::println);
        // creating linkedlist from each sublist and adding into result
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
