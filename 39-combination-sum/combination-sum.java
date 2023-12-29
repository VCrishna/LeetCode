class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        
        // call backtrack funtion
        backtrack(0, currentList, 0, target, candidates, result);

        return result;
    }

    public void backtrack(
        int currentSum,
        List<Integer> currentList, 
        int currentIndex, 
        int target, 
        int[] candidates,
        List<List<Integer>> result
    ) {
        if(currentSum == target) {
            result.add(new ArrayList(currentList));
            return;
        }
        if(currentIndex >= candidates.length || currentSum > target) {
            return;
        }
        
        // considering the element
        currentList.add(candidates[currentIndex]);
        backtrack(
            currentSum + candidates[currentIndex], 
            currentList, 
            currentIndex, 
            target,
            candidates,
            result);
        // not considering the element
        currentList.remove(currentList.get(currentList.size() - 1));
        backtrack(
            currentSum, 
            currentList, 
            currentIndex + 1, 
            target,
            candidates,
            result);
    }
}