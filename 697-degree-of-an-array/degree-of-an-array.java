class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        Map<Integer, Integer> firstSeen = new HashMap<>();
        int minLength = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            firstSeen.putIfAbsent(nums[i], i);
            if (map.get(nums[i]) > degree) {
                degree = map.get(nums[i]);
                minLength = i - firstSeen.get(nums[i]) + 1;
            } else if (map.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
            }
        }

        return minLength;

    }
}