class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        backtrack(result, nums, set, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, int[] nums, 
        Set<List<Integer>> set, int start) {
        if (nums.length == start && !set.contains(ArrayToList(nums))) {
            result.add(ArrayToList(nums));
            set.add(ArrayToList(nums));
        }
        else {
            for(int i = start; i<nums.length; i++) {
                swap(nums,i,start);
                backtrack(result, nums, set, start + 1);
                swap(nums,i,start);
            }
        }
    }
    public List<Integer> ArrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array)
            list.add(i);
        return list;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}