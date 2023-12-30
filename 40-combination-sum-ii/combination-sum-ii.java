class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(
            candidates,
            target,
            result,
            currentList,
            0
        );

        return result;
    }
    public void backtrack(
            int[] candidates, 
            int target, 
            List<List<Integer>> result, 
            List<Integer> currentList, 
            int currentIndex) {
                if(target == 0) {
                    result.add(new ArrayList<>(currentList));
                }
                else if(target < 0 || currentIndex >= candidates.length) {
                    return;
                }
                for(int i = currentIndex; i < candidates.length; i++) {
                    if(i > currentIndex && candidates[i] == candidates[i - 1]) {
                        continue;
                    }
                    currentList.add(candidates[i]);
                    backtrack(
                        candidates,
                        target - candidates[i],
                        result,
                        currentList,
                        i + 1
                    );
                    currentList.remove(currentList.size() - 1);
                }

            }
}