class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; // Triplet not possible

        // Prefix max: max value to the left of each index
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // Suffix max: max value to the right of each index
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }

        // Compute the maximum triplet value
        long maxTripletValue = 0;
        for (int j = 1; j < n - 1; j++) { // j is the middle element
            if (prefixMax[j - 1] > nums[j] && suffixMax[j + 1] > 0) { 
                maxTripletValue = Math.max(
                    maxTripletValue,
                    (long) (prefixMax[j - 1] - nums[j]) * suffixMax[j + 1]
                );
            }
        }

        return maxTripletValue;
    }
}
