class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = -1;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(i));
        }
        int result = 0;
        for(int i : map.values()) {
            result += i == maxFreq ? i : 0;
        }
        return result;
    }
}