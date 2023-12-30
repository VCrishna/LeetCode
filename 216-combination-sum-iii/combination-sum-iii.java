class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(
            k,
            n,
            result,
            currentList,
            0,
            1
        );
        return result;
    }

    public void backtrack(
        int k, 
        int n,
        List<List<Integer>> result,
        List<Integer> currentList,
        int currentSum,
        int currentIndex) {
            if(currentList.size() == k && currentSum == n) {
                result.add(new ArrayList(currentList));
            }
            else if(currentList.size() > k && currentSum > n) {
                return;
            }
            for(int i = currentIndex; i <= 9 ; i++) {
                currentList.add(i);
                backtrack(
                    k,
                    n,
                    result,
                    currentList,
                    currentSum + i,
                    i + 1
                );
                currentList.remove(currentList.size() - 1);
            }
    }
}