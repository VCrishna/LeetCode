class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        int prefixCount = 0;

        while (right < nums.length) {
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            if (countMap.size() > k) {
                countMap.remove(nums[left]);
                left++;
                prefixCount = 0; // Reset prefix count when removing elements
            }
            while (countMap.size() == k && countMap.get(nums[left]) > 1) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                left++;
                prefixCount++;
            }
            if (countMap.size() == k) {
                result += prefixCount + 1; // Count subarrays ending at right pointer
            }
            right++;
        }

        return result;
    }
}