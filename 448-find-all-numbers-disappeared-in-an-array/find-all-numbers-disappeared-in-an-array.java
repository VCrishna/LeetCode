class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i : nums) {
            int index = Math.abs(i);
            if(nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
    public List<Integer> findDisappearedNumbers_BRUTE_FORCE(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i))
                result.add(i);
        }
        return result;
    }
}