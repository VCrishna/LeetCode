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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null)
            return head;
        List<Integer> lst=new ArrayList<>();
        while(head!=null){
            lst.add(head.val);
            head=head.next;
        }
        
        k = k%lst.size();
        reverse(lst,0,lst.size()-1);
        reverse(lst,0,k-1);
        reverse(lst,k,lst.size()-1);

        // lst.forEach(System.out::println);
        // Creating ListNode object to return
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        for(Integer x:lst){
            ListNode temp0=new ListNode(x);
            temp.next=temp0;
            temp=temp0;
        }

        return dummy.next;
    }

    public static void reverse(List<Integer> lst,int start,int end){
        while(start<end){
            int temp=lst.get(start);
            lst.set(start,lst.get(end));
            lst.set(end,temp);
            start++;
            end--;
        }
    }
}