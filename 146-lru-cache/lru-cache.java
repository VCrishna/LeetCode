class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0); // Dummy head node
        tail = new Node(0, 0); // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Move the accessed node to the head of the list to update the access order
            removeNode(node); // Remove the node from its current position in the list
            addToHead(node); // Add the node to the head of the list
            return node.value;
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update the value of the existing node
            // Move the updated node to the head of the list to update the access order
            removeNode(node); // Remove the node from its current position in the list
            addToHead(node); // Add the node to the head of the list
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
}
// /**
// * Your LRUCache object will be instantiated and called as such:
// * LRUCache obj = new LRUCache(capacity);
// * int param_1 = obj.get(key);
// * obj.put(key,value);
// */
