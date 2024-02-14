class Solution {
    // public boolean checkValidString(String s) {
    //     int leftMin = 0;
    //     int leftMax = 0;

    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             leftMin++;
    //             leftMax++;
    //         } else if (c == ')') {
    //             leftMin--;
    //             leftMax--;
    //         } else {
    //             leftMin--;
    //             leftMax++;
    //         }
    //         if (leftMax < 0) {
    //             return false;
    //         }
    //         if (leftMin < 0) {
    //             leftMin = 0;
    //         }
    //     }

    //     return leftMin == 0;
    // }
    public boolean checkValidString(String s) {
        Stack<Integer> leftParentheses = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParentheses.push(i);
            } else if (c == '*') {
                asterisks.push(i);
            } else { // c == ')'
                if (!leftParentheses.isEmpty()) {
                    leftParentheses.pop();
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }
        
        while (!leftParentheses.isEmpty() && !asterisks.isEmpty()) {
            if (leftParentheses.peek() > asterisks.peek()) {
                return false;
            }
            leftParentheses.pop();
            asterisks.pop();
        }
        
        return leftParentheses.isEmpty();
    }
}