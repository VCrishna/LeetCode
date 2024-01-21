class Solution {
    public String reverseParentheses(String s) {
        // Use a stack to keep track of the indices of open parentheses '('
        Stack<Integer> stack = new Stack<>();

        // Convert the input string to a character array for easy manipulation
        char[] chars = s.toCharArray();

        // Iterate through the characters of the input string
        for (int i = 0; i < chars.length; i++) {
            // If an open parenthesis '(' is encountered, push its index onto the stack
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                // If a closing parenthesis ')' is encountered, reverse the substring between
                // matching parentheses
                reverseSubstring(chars, stack.pop() + 1, i - 1);
            }
        }

        // Construct the final result by excluding parentheses '(' and ')'
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Helper method to reverse a substring within the character array
    private void reverseSubstring(char[] chars, int start, int end) {
        while (start < end) {
            // Swap characters at start and end indices
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}