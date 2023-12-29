class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(target, 0, candidates, currentList, result ); 
        return result;
    }

    public void backtrack(
        int target, 
        int currentIndex, 
        int[] candidates, 
        List<Integer> currentList, 
        List<List<Integer>> result) {
            if(target == 0) {
                result.add(new ArrayList<>(currentList));
                // return;
            }
            if(target < 0) {
                return;
            }
            for(int i = currentIndex; i < candidates.length; i++) {
                if(i > currentIndex && candidates[i] == candidates[i-1]) 
                    continue;
                // consider current element
                currentList.add(candidates[i]);
                backtrack(target - candidates[i], i + 1, candidates, currentList, result);
                // don't consider current element
                currentList.remove(currentList.size() - 1);
            }
        }
}