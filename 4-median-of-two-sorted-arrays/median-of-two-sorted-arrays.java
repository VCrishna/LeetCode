class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            arr[k++] = nums1[i++];
        }
        while (j < len2) {
            arr[k++] = nums2[j++];
        }
        if (arr.length % 2 == 0) {
            return ((arr[(arr.length - 1) / 2] + arr[(arr.length - 1) / 2 + 1]) * 1.0 / 2);
        } else {
            return arr[(arr.length - 1) / 2] * 1.0;
        }
    }
}