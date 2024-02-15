class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int length = nums.length;
        sum = (length) * (length + 1) / 2;
        for (int i = 0; i < length; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}

// class Solution {
// public int missingNumber(int[] nums) {
// int res = nums.length;
// for(int i=0; i<nums.length; i++){
// res ^= i;
// System.out.println(res);
// res ^= nums[i];
// System.out.println(res);
// }
// return res;
// }
// }