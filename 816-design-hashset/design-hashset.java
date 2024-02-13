class MyHashSet {
    private final LinkedList[] buckets;
    private static final int AMOUNT_OF_BUCKETS = 10000;

    public MyHashSet() {
        buckets = new LinkedList[AMOUNT_OF_BUCKETS];
        for (int i = 0; i < AMOUNT_OF_BUCKETS; i++) {
            buckets[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int bucketNumber = key % AMOUNT_OF_BUCKETS;
        LinkedList<Integer> bucket = buckets[bucketNumber];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int bucketNumber = key % AMOUNT_OF_BUCKETS;
        LinkedList<Integer> bucket = buckets[bucketNumber];
        bucket.removeIf(value -> value == key);
    }

    public boolean contains(int key) {
        int bucketNumber = key % AMOUNT_OF_BUCKETS;
        LinkedList<Integer> bucket = buckets[bucketNumber];
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */