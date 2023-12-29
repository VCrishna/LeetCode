class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currentList.add(candidates[i]);
            // i + 1
            backtrack(target - candidates[i], i + 1, currentList, result, candidates);
            currentList.remove(currentList.size() - 1);
        }

    }
}