class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        // Finding the pivot
        while(left < right){
            int middle = left+(right-left)/2;
            if(nums[middle] > nums[right]){
                left=middle+1;
            }else{
                right = middle;
            }
        }
        int start = left;
        left = 0;
        right = nums.length-1;
        // Checking whether target is within the boundary
        if(target >= nums[start] && target <= nums[right]){
            left=start;
        }else{
            right=start;
        }

        // Regular Binary Search
        while(left <= right){
            int middleIndex = left + (right - left)/2;
            int middleValue = nums[middleIndex];
            if(middleValue == target)
                return middleIndex;
            else if(nums[middleIndex] < target){
                left = middleIndex+1;
            }
            else{
                right = middleIndex-1;
            }
        }
        return -1;
    }
}