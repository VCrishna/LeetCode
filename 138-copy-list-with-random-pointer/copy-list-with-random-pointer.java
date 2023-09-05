/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        for(Node key : map.keySet()) {
            Node currentNode = map.get(key);
            currentNode.next = map.get(key.next);
            currentNode.random = map.get(key.random);
        }
        return map.get(head);
    }
}