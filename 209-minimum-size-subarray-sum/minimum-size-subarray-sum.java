class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int currentWindowSum = 0;
        for (int right = 0; right < nums.length; right++) {
            currentWindowSum += nums[right];

            while (currentWindowSum >= target) {
                result = Math.min(result, right - left + 1);
                currentWindowSum -= nums[left++];
            }

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}


// Greedy
// Arrays.sort(nums);
// int right = nums.length-1;
// int sum=0;
// int count=0;
// while(right >= 0){
//     sum += nums[right];
//     count++;
//     if(sum >= target){
//         return count;
//     }
//     right--;
// }
// return 0;

// Method 2
// int length = nums.length, 
// left = 0, 
// right = 0, 
// sum = 0, 
// min = Integer.MAX_VALUE;

// while(right < length){
// sum += nums[right];
// while(sum >= target){
//     min = Math.min(min, right - left+1);
//     sum -= nums[left++];
// }
// right++;
// }
// return min == Integer.MAX_VALUE?0:min; 