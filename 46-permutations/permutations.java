class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0);
        return result;
    }

    public void backtrack(
        int[] nums,
        List<List<Integer>> result,
        int start
    ) {
        if(start == nums.length) {
            result.add(ArrayToList(nums));
        }
        for(int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            backtrack(nums, result, start + 1);
            swap(nums, i, start);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> ArrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) list.add(i);
        return list;
    }
}