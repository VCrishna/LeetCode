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
        if (head == null)
            return head;

        // Step 1: Duplicate each node and insert it next to the original node
        Node temp = head;
        while (temp != null) {
            Node tempNew = new Node(temp.val); // Create a new node with the same value
            tempNew.next = temp.next; // Set the next pointer of the new node to the next pointer of the original node
            temp.next = tempNew; // Set the next pointer of the original node to the new node
            temp = temp.next.next; // Move to the next original node
        }

        // Step 2: Update the random pointers of the duplicated nodes
        Node newHead = head.next; // Store the head of the new list (the first duplicated node)
        temp = head;
        while (temp != null) {
            Node next = temp.next; // Get the duplicated node
            if (temp.random != null)
                next.random = temp.random.next; // Set the random pointer of the duplicated node to the duplicated
                                                // random node
            temp = next.next; // Move to the next original node
        }

        // Step 3: Separate the original and duplicated nodes
        temp = head;
        while (temp != null) {
            Node copy = temp.next; // Get the duplicated node
            temp.next = copy.next; // Update the next pointer of the original node to skip the duplicated node
            if (copy.next != null) {
                copy.next = temp.next.next; // Update the next pointer of the duplicated node to skip the original node
            }
            temp = temp.next; // Move to the next original node
        }

        return newHead; // Return the head of the duplicated list
    }
}
