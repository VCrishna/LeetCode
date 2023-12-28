// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         backtrack(n, n, n, "", result);
//         return result;
//     }

//     public void backtrack(int n, int left, int right, String currentString, List<String> result) {
//         if (left == 0 && right == 0) {
//             result.add(currentString);
//             return;
//         }
//         if (left > 0)
//             backtrack(n, left - 1, right, currentString + "(", result);
//         if (right > left)
//             backtrack(n, left, right - 1, currentString + ")", result);
//     }
// }

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

    public void generate(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) generate(result, str + "(", left - 1, right);
        if (right > left) generate(result, str + ")", left, right - 1);
    }
}
