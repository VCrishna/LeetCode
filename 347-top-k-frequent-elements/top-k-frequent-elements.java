class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        // map.forEach((key,v) -> System.out.println("Key = "+ key + ", Value = " + v));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> map.get(b) - map.get(a)
        );
        maxHeap.addAll(map.keySet());
        // while(!maxHeap.isEmpty()) {
        //     System.out.println(maxHeap.remove());
        // }
        int[] result = new int[k];
        for(int i = 0; i <  k; i++) {
            result[i] = maxHeap.remove();
        }
        return result;
    }
}