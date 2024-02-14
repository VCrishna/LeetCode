class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0; // Counter for minimum unmatched left parentheses.
        int leftMax = 0; // Counter for maximum unmatched left parentheses.

        for (char c : s.toCharArray()) { // Iterate through each character in the string.
            if (c == '(') {
                leftMin++; // Increment leftMin for every left parenthesis.
                leftMax++;
            } else if (c == ')') {
                leftMin--; // Decrement leftMin for every right parenthesis.
                leftMax--;
            } else { // Handling asterisks '*'.
                leftMin--; // Asterisk can be treated as a right parenthesis.
                leftMax++; // Asterisk can be treated as a left parenthesis.
            }
            if (leftMax < 0) { // If at any point, the maximum unmatched left parentheses count becomes
                               // negative, the string becomes invalid.
                return false;
            }
            if (leftMin < 0) { // If leftMin becomes negative, reset it to 0, indicating that we consider the
                               // remaining unmatched '(' as '*'.
                leftMin = 0;
            }
        }

        return leftMin == 0; // If leftMin is 0 at the end, it means all '(' are matched properly.
    }
    public boolean checkValidString_EXTRA_SPACE(String s) {
        Stack<Integer> leftParentheses = new Stack<>();
        Stack<Integer> asterisks = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParentheses.push(i); // Store the index of '(' in the stack.
            } else if (c == '*') {
                asterisks.push(i); // Store the index of '*' in the stack.
            } else { // c == ')'
                if (!leftParentheses.isEmpty()) {
                    leftParentheses.pop(); // If ')' can match with '(', pop the corresponding index from the stack.
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop(); // If ')' can match with '*', pop the corresponding index from the stack.
                } else {
                    return false; // If neither '(' nor '*' is available, the string becomes invalid.
                }
            }
        }

        // Now, matching remaining '(' with '*'.
        while (!leftParentheses.isEmpty() && !asterisks.isEmpty()) {
            if (leftParentheses.peek() > asterisks.peek()) {
                return false; // If the index of '(' is greater than the index of '*', the string becomes
                              // invalid.
            }
            leftParentheses.pop();
            asterisks.pop();
        }

        return leftParentheses.isEmpty(); // If there are no unmatched '(' left, the string is valid.
    }
}
