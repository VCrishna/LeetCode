class Solution {
    public int maxFrequencyElements(int[] nums) {
        int result = 0, max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }
        for (int val : map.values()) {
            if (max == val) {
                result += val;
            }
        }
        return result;
    }
}