class Node {
    int val;
    Node next;

    public Node(int x) {
        this.val = x;
    }
}

class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new Node(-1);
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        // Node addH = new Node(val);
        // addH.next = head.next;
        // head.next = addH;
        // size++;
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        Node addT = new Node(val);
        Node dummy = head;
        for (int i = 0; i < size; i++) {
            dummy = dummy.next;
        }
        dummy.next = addT;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        Node addI = new Node(val);
        Node dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        addI.next = dummy.next;
        dummy.next = addI;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size)
            return;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */