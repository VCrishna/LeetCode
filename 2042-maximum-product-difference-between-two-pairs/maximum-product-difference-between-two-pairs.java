class Solution {
    public int maxProductDifference(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int i : nums) {
            if (i > biggest) {
                secondBiggest = biggest;
                biggest = i;
            }
            else {
                secondBiggest = Math.max(secondBiggest, i);
            }
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            }
            else {
                secondSmallest = Math.min(secondSmallest, i);
            }
        }
        return biggest * secondBiggest - smallest * secondSmallest;
    }

    public int maxProductDifference_BRUTE_FORCE(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}
