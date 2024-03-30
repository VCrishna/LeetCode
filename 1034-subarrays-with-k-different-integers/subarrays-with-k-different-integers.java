import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Creating a map to store the count of each element in the current window
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Initializing pointers and variables
        int left = 0; // Left pointer of the current window
        int right = 0; // Right pointer of the current window
        int result = 0; // Count of subarrays with exactly k distinct elements
        int prefixCount = 0; // Count of subarrays ending at the right pointer
        
        // Looping through the array until the right pointer reaches the end
        while (right < nums.length) {
            // Adding the current element to the countMap and update its count
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            
            // If the number of distinct elements in the current window exceeds k
            if (countMap.size() > k) {
                // Removing elements from the left side of the window until we have exactly k distinct elements
                countMap.remove(nums[left]);
                left++;
                prefixCount = 0; // Reseting prefixCount as we are removing elements
            }
            
            // While we have exactly k distinct elements in the current window
            while (countMap.size() == k && countMap.get(nums[left]) > 1) {
                // Moving the left pointer to shrink the window and update prefixCount
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                left++;
                prefixCount++;
            }
            
            // If we have exactly k distinct elements in the current window
            if (countMap.size() == k) {
                // Incrementing the result by the count of subarrays ending at the right pointer
                result += prefixCount + 1;
            }
            
            // Moving the right pointer to expand the window
            right++;
        }

        // Return the total count of subarrays with exactly k distinct elements
        return result;
    }
}
