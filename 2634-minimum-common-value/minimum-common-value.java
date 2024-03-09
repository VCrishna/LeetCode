class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // Initializing two pointers, i and j, 
        // to traverse nums1 and nums2 respectively
        int i = 0, j = 0;
        
        // Looping until either of the arrays is fully traversed
        while (i < nums1.length && j < nums2.length) {
            // If the current elements pointed by i and j are equal, 
            // returning the common element
            if (nums1[i] == nums2[j])
                return nums1[i];
            // If the current element in nums1 is less than that in nums2, 
            // moving to the next element in nums1
            else if (nums1[i] < nums2[j])
                i++;
            // If the current element in nums2 is less than that in nums1, 
            // moving to the next element in nums2
            else
                j++;
        }
        // If no common element is found, return -1
        return -1;
    }
}
