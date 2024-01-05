class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Calculating the total sum of the array elements
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }

        // If the total sum is not divisible evenly by k, return false
        if (totalSum % k != 0) {
            return false; // Not possible to distribute elements into k subsets with equal sums
        }

        // Calculating the target sum that each subset should have
        int targetSum = totalSum / k;

        // Creating an array to keep track of whether an element has been visited or not
        // as we don't want to use same element twice
        boolean[] visited = new boolean[nums.length];

        // Starting the backtracking process to find k subsets with equal sums
        return backtrack(nums, k, 0, 0, targetSum, visited);
    }

    public boolean backtrack(int[] nums, int k, int currentIndex, int currentSubSetSum, int targetSum, boolean[] visited) {
        // If k becomes 0, it means all subsets have been formed, and the function returns true
        if (k == 0) {
            return true; // Valid partitioning found
        }

        // If the current subset sum equals the target sum, initiate the next subset by making a recursive call
        if (currentSubSetSum == targetSum) {
            return backtrack(nums, k - 1, 0, 0, targetSum, visited);
        }

        // Iterate through the array from the current index and try to include each element in the current subset
        for (int i = currentIndex; i < nums.length; i++) {
            // Check if the element hasn't been visited and adding it to the current subset won't exceed the target sum
            if (!visited[i] && currentSubSetSum + nums[i] <= targetSum) {
                // Mark the element as visited
                visited[i] = true;

                // Make a recursive call to explore further possibilities
                if (backtrack(nums, k, i + 1, currentSubSetSum + nums[i], targetSum, visited)) {
                    return true; // If a valid partitioning is found, return true
                }

                // Backtrack by marking the current element as not visited
                visited[i] = false;
            }
        }

        return false; // If no valid partitioning is found, return false
    }
}
