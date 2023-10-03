class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            result += map.getOrDefault(num,0);
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return result;        
    }
    // Brute Force
    // public int numIdenticalPairs(int[] nums) {
    //     int result = 0;
    //     for(int i = 0; i < nums.length; i++) {
    //         for(int j = i+1; j < nums.length; j++) {
    //             if(nums[i] == nums[j])
    //                 result++;
    //         }
    //     }
    //     return result;        
    // }
}