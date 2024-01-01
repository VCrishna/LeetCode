class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int indexCount = 0;
        if(nums == null || nums.length == 1) {
            return indexCount;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    indexCount += right - left;
                    left++;
                }
                else
                    right--;
            }
        }

        return indexCount;
    }
    // TLE
    public int threeSumSmaller_BRUTE_FORCE(int[] nums, int target) {
        int indexCount = 0;
        if(nums == null || nums.length == 1) {
            return indexCount;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] < target) indexCount++;
                }
            }
        }

        return indexCount;
    }
}