class MyHashSet {
    private static final int numBuckets = 1000;
    private LinkedList<Entry>[] buckets;

    private static class Entry {
        int key;
        Entry next;

        Entry(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        buckets = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return;
            }
        }

        bucket.add(new Entry(key));
    }

    public void remove(int key) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        Entry toRemove = null;
        for (Entry entry : bucket) {
            if (entry.key == key) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }

    public boolean contains(int key) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */