class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int o : nums) map.put(o, map.getOrDefault(o, 0) + 1);
        int count = 0;
        for (int i : map.values()) {
            if (i == 1) {
                return -1;
            } else {
                count += Math.ceil((double) i / 3);
            }
        }
        return count;
    }
}
