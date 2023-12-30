class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, result, new ArrayList<>(), 0);

        return result;
    }

    public void backtrack (
        int[] nums, 
        List<List<Integer>> result,
        List<Integer> currentList,
        int currentIndex) {
            if(!result.contains(currentList)) {
                result.add(new ArrayList<>(currentList));
            }
            if(currentIndex >= nums.length) {
                return;
            }
            for(int i = currentIndex; i < nums.length; i++) {
                currentList.add(nums[i]);
                backtrack(nums, result, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
            }

    }
}