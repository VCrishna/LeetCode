class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                result[index++] = nums[i];
            }
        }

        return result;
    }
}