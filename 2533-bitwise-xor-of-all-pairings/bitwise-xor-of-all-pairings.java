class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0; // Initialize the result variable to hold the cumulative XOR result.
        int n1 = nums1.length; // Get the length of the first array, nums1.
        int n2 = nums2.length; // Get the length of the second array, nums2.

        // If the length of nums2 is odd, XOR all elements of nums1 into the result.
        // Intuition:
        // Each element in nums1 contributes to the XOR result once for every element in nums2.
        // If nums2.length is odd, each element in nums1 is effectively XORed an odd number of times (odd repetitions).
        // XORing a number an odd number of times retains its original contribution.
        if (n2 % 2 == 1) 
            for (int num : nums1) 
                res ^= num; // XOR each element in nums1 into res.

        // If the length of nums1 is odd, XOR all elements of nums2 into the result.
        // Intuition:
        // Similarly, each element in nums2 contributes to the XOR result once for every element in nums1.
        // If nums1.length is odd, each element in nums2 is effectively XORed an odd number of times.
        // Thus, XORing a number an odd number of times retains its original contribution.
        if (n1 % 2 == 1) 
            for (int num : nums2) 
                res ^= num; // XOR each element in nums2 into res.

        // Return the cumulative XOR result.
        return res;
    }
}
