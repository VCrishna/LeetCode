class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        // calling backtrack
        backtrack(
            target,
            0,
            0,
            currentList,
            result,
            candidates          
        );

        return result;
    }

    public void backtrack (
        int target,
        int currentSum,
        int currentIndex,
        List<Integer> currentList,
        List<List<Integer>> result,
        int[] candidates
    ) {
        
        if(currentSum == target) {
            result.add(new ArrayList(currentList));
            return;
        }
        if(currentIndex >= candidates.length || currentSum > target) {
            return;
        }

        // consider current value
        // add the value into currentList
        currentList.add(candidates[currentIndex]);
        backtrack(
            target,
            currentSum + candidates[currentIndex],
            currentIndex,
            currentList,
            result,
            candidates          
        );

        // donot consider the current value
        // clean after backtrack - remove element from currentList
        currentList.remove(currentList.get(currentList.size() - 1));
        backtrack(
            target,
            currentSum,
            currentIndex + 1,
            currentList,
            result,
            candidates          
        );
    }
}