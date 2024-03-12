/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // The observation here is that the sum from index 0 to index M will be 
        // equal to sum from index 0 to index N if sum from index (M+1) to index N is 0.
        // Thus, here we track the sum from index 0 to each index, using a Map to indicate
        // the farthest index N that we can remove from index M, then we shall be able to
        // remove M+1 -> N and continue from N+1. This works since we don't have to optimize
        // for the number of sequences to be removed
        
        // Map from sum from index 0 to the farthest value that the sum stays unchanged.
        Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();
        
        // Need the dummy node to track the new head if changed.
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        // First iteration to compute the map.
        int sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            sumToFarthestNodeMap.put(sum, p);
        }
        // sumToFarthestNodeMap.entrySet().forEach(System.out::println);
        // Second iteration to re-connect the nodes to the farthest node where the sum stays unchanged
        sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            p.next = sumToFarthestNodeMap.get(sum).next;
        }
        
        // Done, return the head from preHead
        return preHead.next;
    }
}
// Method 1
// class Solution {
//     public ListNode removeZeroSumSublists(ListNode head) {
//         ListNode dummy=new ListNode(0);
//         dummy.next = head;
//         HashMap<Integer,ListNode> hmp=new HashMap<>();
//         int pSum=0;
//         hmp.put(pSum,dummy);
//         while(head!=null){
//             pSum+=head.val;
//             if(hmp.containsKey(pSum)){
//                 // removing entries from map
//                 ListNode toRemove=hmp.get(pSum).next;
//                 int SUM=pSum;
//                 while(toRemove != head){
//                     SUM += toRemove.val;
//                     hmp.remove(SUM);
//                     toRemove = toRemove.next;
//                 }
//                 // delete nodes
//                 hmp.get(pSum).next = head.next;
//             }
//             else{
//                 hmp.put(pSum, head);
//             }
//             head=head.next;
//         }
//         return dummy.next;
//     }
// }