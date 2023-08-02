class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(ArrayToList(nums));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                backtrack(result, nums, start + 1);
                swap(nums, i, start);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> ArrayToList(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i : nums) result.add(i);
        return result;
    }
}
