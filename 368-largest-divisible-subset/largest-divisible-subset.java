class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Initialize the result list to store the largest divisible subset
        List<Integer> result = new ArrayList<>();
        
        // Sort the input array in ascending order
        Arrays.sort(nums);
        
        // Get the length of the input array
        int n = nums.length;
        
        // Initialize an array to store the length of the largest divisible subset ending at each index
        int[] dp = new int[n];
        
        // Initialize all elements of dp array to 1 (minimum subset size is 1)
        Arrays.fill(dp, 1);
        
        // Index of the element with the maximum length divisible subset
        int maxIndex = 0;
        
        // Iterate through each element of the input array
        for (int i = 1; i < n; i++) {
            // Iterate through the elements before the current element
            for (int j = 0; j < i; j++) {
                // If nums[i] is divisible by nums[j] and length of subset ending at nums[i] can be increased by including nums[j]
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
            // If the current length of subset is equal to maxLength and currNum is divisible by nums[i]
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
    public List<Integer> largestDivisibleSubset_MORE_SPACE(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> dp = new ArrayList<>();

        for(int num : nums) {
            dp.add(new  ArrayList<>());
        }

        for(int i = 0; i < nums.length; i++) {
            List<Integer> current = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                if(
                    nums[i] % nums[j] == 0 &&
                    current.size() < dp.get(j).size()
                    )
                    {
                        current = dp.get(j);
                    }
            }
            dp.get(i).addAll(current);
            dp.get(i).add(nums[i]);
        }

        for(int i = 0; i < dp.size(); i++) {
            if(result.size() < dp.get(i).size()){
                result = dp.get(i);
            }
        }

        return result;
    }
}