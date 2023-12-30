class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(
            nums,
            result,
            0,
            new ArrayList<>()
        );
        return result;
    }
    public void backtrack(
        int[] nums,
        List<List<Integer>> result,
        int currentIndex,
        List<Integer> currentList
    ) {

        if(!result.contains(currentList)) {
            result.add(new ArrayList<>(currentList));
        }
        else if(currentIndex > nums.length) {
            return;
        }
        for(int i = currentIndex; i < nums.length; i++) {
            if(i > currentIndex && nums[i] == nums[i-1])
                continue;
            currentList.add(nums[i]);
            backtrack(
                nums,
                result,
                i + 1,
                currentList
            );
            currentList.remove(currentList.size() - 1);
        }
    }
}