class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int middleIndex = left + (right - left) / 2;

            if(arr[middleIndex] < arr[middleIndex + 1]) {
                left = middleIndex + 1;
            }
            else{
                right = middleIndex;
            }

        }
        return left;
    }
}