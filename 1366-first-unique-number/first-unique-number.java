class FirstUnique {
    // Map<Integer, Integer> map;
    // PriorityQueue<Integer> minHeap;
    // public FirstUnique(int[] nums) {
    //     map = new HashMap<>();
    //     minHeap = new PriorityQueue<>(
    //         (a,b) -> map.get(a) - map.get(b)
    //     );
    //     for(int i : nums) 
    //         map.put(i , map.getOrDefault(i , 0) + 1);
    //     for(int i : nums) minHeap.add(i);
    // }
    
    // public int showFirstUnique() {
    //     while(!minHeap.isEmpty() && map.get(minHeap.peek()) > 1) {
    //         minHeap.poll();
    //     }
    //     return minHeap.isEmpty() ? -1 : minHeap.peek();
    // }
    
    // public void add(int value) {
    //     map.put(value , map.getOrDefault(value , 0) + 1);
    //     if (map.get(value) == 1) {
    //         minHeap.offer(value);
    //     }
    // }
    private Map<Integer, Integer> frequencyMap;
    private Queue<Integer> uniqueQueue;

    public FirstUnique(int[] nums) {
        frequencyMap = new HashMap<>();
        uniqueQueue = new LinkedList<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!uniqueQueue.isEmpty() && frequencyMap.get(uniqueQueue.peek()) > 1) {
            uniqueQueue.poll();
        }

        return uniqueQueue.isEmpty() ? -1 : uniqueQueue.peek();
    }

    public void add(int value) {
        frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        
        if (frequencyMap.get(value) == 1) {
            uniqueQueue.offer(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */