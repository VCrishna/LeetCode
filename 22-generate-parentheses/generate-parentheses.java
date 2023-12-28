class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, n, "", result);
        return result;
    }

    public void backtrack(int n, int left, int right, String currentString, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(currentString);
            return;
        }
        if (left > 0) 
            backtrack(n, left - 1, right, currentString + "(", result);
        if (right > left) 
            backtrack(n, left, right - 1, currentString + ")", result);
    }
}
