class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(n, k, 1, currentList, result);
        return result;
    }
    public void backtrack(
        int n, 
        int k, 
        int currentIndex, 
        List<Integer> currentList, 
        List<List<Integer>> result) {
            if(currentList.size() == k) {
                result.add(new ArrayList<>(currentList));
                return;
            }
            for(int i = currentIndex; i < n + 1; i ++) {
                currentList.add(i);
                backtrack(n, k, i + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }

    }
}