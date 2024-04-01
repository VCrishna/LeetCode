class Solution {
    public long countSubarrays(int[] nums, int k) {
        // Finding the maximum element in the array
        int maxElement = Arrays.stream(nums).max().getAsInt();
        
        // List to store indexes of occurrences of the maximum element
        List<Integer> indexesOfMaxElements = new ArrayList<>();
        
        // Variable to store the final answer
        long ans = 0;

        // Iterating through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is the maximum element, add its index to the list
            if (nums[i] == maxElement) {
                indexesOfMaxElements.add(i);
            }

            // Counting the frequency of occurrences of the maximum element
            int freq = indexesOfMaxElements.size();
            
            // If the frequency is greater than or equal to 'k'
            if (freq >= k) {
                // Adding the index of the (freq - k + 1)-th occurrence of the maximum element to the answer
                ans += indexesOfMaxElements.get(freq - k) + 1;
            }
        }

        // Returning the final answer
        return ans;
    }
}
