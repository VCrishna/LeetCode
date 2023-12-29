class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        // calling backtrack function
        backtrack(target, 0, currentList, result, candidates);
        return result;
    }

    public void backtrack (
        int target,
        int currentIndex,
        List<Integer> currentList,
        List<List<Integer>> result,
        int[] candidates        
    ) {
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        if(target < 0 || currentIndex >= candidates.length) {
            return;
        }

        for(int i = currentIndex; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            backtrack(target - candidates[i], i, currentList, result, candidates);
            currentList.remove(currentList.size() - 1);
        }

    }
}