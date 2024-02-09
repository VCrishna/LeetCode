class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Initializing the result list to store the largest divisible subset
        List<Integer> result = new ArrayList<>();

        // Sorting the input array in ascending order
        Arrays.sort(nums);

        // Getting the length of the input array
        int n = nums.length;

        // Initializing an array to store the length of the largest divisible subset
        // ending at each index
        int[] dp = new int[n];

        // Initializing all elements of dp array to 1 (minimum subset size is 1)
        Arrays.fill(dp, 1);

        // Index of the element with the maximum length divisible subset
        int maxIndex = 0;

        // Iterating through each element of the input array
        for (int i = 1; i < n; i++) {
            // Iterating through the elements before the current element
            for (int j = 0; j < i; j++) {
                // If nums[i] is divisible by nums[j] and length of subset ending at nums[i] can
                // be increased by including nums[j]
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    // Update the length of the subset ending at nums[i]
                    dp[i] = dp[j] + 1;
                    // Update the index of the element with the maximum length divisible subset
                    if (dp[i] > dp[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
        }

        // Get the maximum length of the divisible subset
        int maxLength = dp[maxIndex];

        // Get the number at maxIndex
        int currNum = nums[maxIndex];

        // Traverse backward from maxIndex to construct the largest divisible subset
        for (int i = maxIndex; i >= 0; i--) {
            // If the current length of subset is equal to maxLength and currNum is
            // divisible by nums[i]
            if (maxLength == dp[i] && currNum % nums[i] == 0) {
                // Add nums[i] to the result list
                result.add(nums[i]);
                // Update currNum to nums[i]
                currNum = nums[i];
                // Decrement maxLength
                maxLength--;
            }
        }

        // Return the largest divisible subset
        return result;
    }

    // This method finds the largest divisible subset using more space
    public List<Integer> largestDivisibleSubset_MORE_SPACE(int[] nums) {
        // Initialize the result list to store the largest divisible subset
        List<Integer> result = new ArrayList<>();

        // Sort the input array in ascending order
        Arrays.sort(nums);

        // Initialize a list of lists to store the subsets ending at each index
        List<List<Integer>> dp = new ArrayList<>();

        // Initialize subsets for each number in the sorted array
        for (int num : nums) {
            dp.add(new ArrayList<>());
        }

        // Iterate through each number in the sorted array
        for (int i = 0; i < nums.length; i++) {
            // Initialize the current subset
            List<Integer> current = new ArrayList<>();

            // Iterate through the numbers before the current number
            for (int j = 0; j < i; j++) {
                // If nums[i] is divisible by nums[j] and the subset ending at nums[j] is larger
                if (nums[i] % nums[j] == 0 && current.size() < dp.get(j).size()) {
                    // Update the current subset to be the subset ending at nums[j]
                    current = dp.get(j);
                }
            }

            // Add the current number to the current subset
            dp.get(i).addAll(current);
            dp.get(i).add(nums[i]);
        }

        // Find the largest subset among all subsets
        for (int i = 0; i < dp.size(); i++) {
            if (result.size() < dp.get(i).size()) {
                result = dp.get(i);
            }
        }

        // Return the largest divisible subset
        return result;
    }
}