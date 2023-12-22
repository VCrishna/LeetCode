class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) 
            return nums;
        // number, frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) 
            map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        maxHeap.addAll(map.keySet());
        int[] result = new int[k];
        for(int i = 0; i < k ; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
