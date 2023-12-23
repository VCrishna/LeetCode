class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return 0;
    }
    public int findDuplicate_SORTING(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) return nums[i];
        }
        return 0;
    }
}