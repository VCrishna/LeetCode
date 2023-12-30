class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(
            result,
            candidates,
            target,
            currentList, 
            0,
            target
        );
        return result;
    }
    public void backtrack(
            List<List<Integer>> result,
            int[] candidates, 
            int target, 
            List<Integer> currentList, 
            int currentIndex,
            int currentSum
    ) {
        if(currentSum == 0) {
            result.add(new ArrayList(currentList));
        }
        if(currentSum < 0 || currentIndex >= candidates.length) {
            return;
        }
        for(int i = currentIndex; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            backtrack(
                result,
                candidates,
                target,
                currentList, 
                i,
                currentSum - candidates[i]
            );
            currentList.remove(currentList.size() - 1);
        }
    }
}