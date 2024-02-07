class MyHashMap {
    private static final int numBuckets = 1000;
    private LinkedList<Entry>[] buckets;

    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    public int get(int key) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
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
}

class MyHashMap_INT_ARRAY {
    int[] map;

    public MyHashMap_INT_ARRAY() {
        map = new int[1000001];
        // Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value + 1;
    }

    public int get(int key) {
        return map[key] - 1;
    }

    public void remove(int key) {
        map[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */