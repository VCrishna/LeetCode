class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        int result = right;

        while(left <= right) {
            // int middle_difference = left + (right - left) / 2;
            int middle_difference = (left + right) / 2;
            if(helper(nums, p, middle_difference)) {
                result = middle_difference;
                right = middle_difference - 1;
            }
            else {
                left = middle_difference + 1;
            }
        }

        return result;

    }
    public boolean helper(int[] nums, int p, int diff) {
        
        for(int index = 1;index < nums.length; index++) {
            if(nums[index] - nums[index-1] <= diff) {
                p--;
                index++;
            }
        }
        return p<=0;
    }
}