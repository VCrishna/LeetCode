class Solution {
    List<List<Integer>> combinations;
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        combinations=new ArrayList<List<Integer>>();
        this.n  = n;
        this.k = k;
        backtrack(1,new ArrayList<>());
        return combinations;
    }
    public void backtrack(int start, List<Integer> combination) {
        if(combination.size() == k) {
            combinations.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = start; i < n+1; i++){
            combination.add(i);
            backtrack(i+1, combination);
            combination.remove(combination.size() - 1);
        }
    }
}