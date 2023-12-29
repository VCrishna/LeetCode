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

/**

Iterative Approach

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, 0, 0, candidates, target);
        return ans;
    }
    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int i, int sum, int[] candidates, int target) {
        // base case sum == target
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        // combination from (i, n) | it means including self
        for(int j = i ; j < candidates.length ; j++) {
            int num = candidates[j];
            if(sum + num <= target){
                curr.add(num);
                backtrack(curr, ans, j , sum + num, candidates, target);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
 */