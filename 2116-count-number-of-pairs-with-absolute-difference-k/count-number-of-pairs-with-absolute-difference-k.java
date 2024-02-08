class Solution {
    public int countKDifference(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + k)) {
                result += map.get(nums[i] + k);
            }
            if (map.containsKey(nums[i] - k)) {
                result += map.get(nums[i] - k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return result;
    }

    public int countKDifference_BRUTE_FORCE(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    result++;
                }
            }
        }

        return result;
    }
}