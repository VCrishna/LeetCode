class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);  // sort for greedy allocation
        int nextAvailable = Integer.MIN_VALUE; // smallest number we can use next
        int count = 0;

        for (int num : nums) {
            int left = num - k;
            int right = num + k;

            // We want to assign the smallest number >= nextAvailable and >= left
            int assign = Math.max(nextAvailable, left);

            // If assign is still within [left, right], we can use it
            if (assign <= right) {
                count++;
                nextAvailable = assign + 1; // move pointer forward
            }
        }

        return count;
    }
}
