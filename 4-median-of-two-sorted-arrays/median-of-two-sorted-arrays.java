class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int i = 0, j = 0, k = 0;
        int[] merged = new int[nums1.length + nums2.length];

        // Traverse both arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        // Store remaining elements of first array (if any)
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        // Store remaining elements of second array (if any)
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(merged));
        if(merged.length % 2 != 0) {
            int middle = ((merged.length - 1) / 2);
            return merged[middle];
        }
        else {
            int middle = ((merged.length - 1) / 2);
            result = (merged[middle] + merged[middle+1]);
            // return result;
        }
        return result/2;
    }
}