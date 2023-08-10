class Solution {

    public int minimizeMax(int[] nums, int p) {
        if (p==0) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        int result = right;

        while (left <= right) {
            int threshold = left + (right - left) / 2;
            if (isValid(nums, p, threshold)) {
                result = threshold;
                right = threshold - 1;
            } else {
                left = threshold + 1;
            }
        }
        return result;
    }

    public boolean isValid(int[] nums, int p, int threshold) {
        int count = 0;
        int index = 1;
        while (index < nums.length) {
            if(nums[index] - nums[index - 1] <= threshold) {
                count++;
                index += 2;
            }
            else{
                index++;
            }
            if (count == p) 
                return true;
        }
        return false;
    }
}
