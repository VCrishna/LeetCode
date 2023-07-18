class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1); // Dummy head node
        tail = new Node(-1, -1); // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node); // Move the accessed node to the head of the list to update the access order
            return node.value;
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update the value of the existing node
            moveToHead(node); // Move the updated node to the head of the list to update the access order
        } else {
            if (cache.size() == capacity) {
                Node toRemove = tail.prev; // Get the node to be removed (least recently used)
                removeNode(toRemove); // Remove the node from the list
                cache.remove(toRemove.key); // Remove the node from the map
            }
            Node newNode = new Node(key, value); // Create a new node
            cache.put(key, newNode); // Add the new node to the map
            addToHead(newNode); // Add the new node to the head of the list
        }
    }

    private void moveToHead(Node node) {
        removeNode(node); // Remove the node from its current position in the list
        addToHead(node); // Add the node to the head of the list
    }

    private void removeNode(Node node) {
        node.prev.next = node.next; // Update the next pointer of the previous node
        node.next.prev = node.prev; // Update the previous pointer of the next node
    }

    private void addToHead(Node node) {
        node.next = head.next; // Make the next pointer of the new node point to the current first node
        node.prev = head; // Make the previous pointer of the new node point to the head
        head.next.prev = node; // Make the previous pointer of the current first node point to the new node
        head.next = node; // Make the next pointer of the head point to the new node
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
// class Node {
//     Node prev;
//     Node next;
//     int key;
//     int value;
//     Node(int key, int value) {
//         this.key = key;
//         this.value = value;
//     }
// }
// class LRUCache {
//     int capacity;
//     HashMap<Integer, Node> map;
//     Node head;
//     Node tail;
//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         map = new HashMap<>(capacity);
//         head = new Node(0, 0);
//         tail = new Node(0, 0);
//         head.next = tail;
//         tail.prev = head;
//     }
//     public int get(int key) {
//         if (!map.containsKey(key)) {
//             return -1;
//         }
//         // move recently used node to the top of the linkedlist
//         // simpley remove the node and add the node back at the head
//         Node node = map.get(key);
//         // Check if the node is already at the front of the linked list.
//         if (node == head.next) {
//             return node.value;
//         }
//         // Move the node to the front of the linked list.
//         // inseting/adding back to the linkedlist at head
//         removeNode(node);
//         addNode(node);
//         return node.value;
//     }
//     public void put(int key, int value) {
//         // if key already present in the map
//         // then we need to update value and move it to the top
//         if (map.containsKey(key)) {
//             Node node = map.get(key);
//             node.value = value;
//         }
//         // If the cache is full, evict the least recently used node.
//         if (capacity == map.size()) {
//             // remove the least recently used node i.e., tail.prev
//             removeNode(tail.prev);
//         }
//         // Add the new node to the front of the linked list.
//         Node node = new Node(key, value);
//         addNode(node);
//     }
//     public void addNode(Node newNode) {
//         map.put(newNode.key,newNode);
//         newNode.next = head.next;
//         head.next.prev = newNode;
//         head.next = newNode;
//         newNode.prev = head;
//     }
//     public void removeNode(Node node) {
//     map.remove(node.key);
//     Node nodeNext = node.next;
//     Node nodePrev = node.prev;
//     nodePrev.next = nodeNext;
//     nodeNext.prev = nodePrev;
// }
//     // public void removeNode(Node node) {
//     //     map.remove(node.key);
//     //     Node nodeNext = node.next;
//     //     Node nodePrev = node.prev;
//     //     nodePrev.next = nodeNext;
//     //     nodeNext.prev = nodePrev;
//     // }
// }
// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */
