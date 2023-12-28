class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0,  0, n);
        return result;
    }

    public void generate(List<String> result, String currentString, int open, int close, int max) {
        if (currentString.length() == max * 2) {
            result.add(currentString);
            return;
        }
        if (open < max) 
            generate(result, currentString + "(", open + 1, close, max);
        if (close < open) 
            generate(result, currentString + ")", open, close + 1, max);
    }
}
