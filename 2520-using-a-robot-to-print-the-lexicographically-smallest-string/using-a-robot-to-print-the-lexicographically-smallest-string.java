class Solution {
    public String robotWithString(String s) {

        int n = s.length();
        char[] minSuffix = new char[n];

        // minSuffix[i] will hold the smallest character from index i to the end
        minSuffix[n - 1] = s.charAt(n - 1);

        // Fill the minSuffix array backwards
        for (int i = n - 2; i >= 0; i--) {
            // At each step, store the minimum character between current and the one after
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }
        
        StringBuilder p = new StringBuilder();  // Result string
        Stack<Character> t = new Stack<>();     // Robot's stack

        // Traverse through the string s
        for (int i = 0; i < n; i++) {
            // Push current character onto stack
            t.push(s.charAt(i));

            // While stack is not empty and top of stack is <= smallest upcoming char in suffix
            while (!t.isEmpty() && (i == n - 1 || t.peek() <= minSuffix[i + 1])) {
                // Pop from stack and append to result
                p.append(t.pop());
            }
        }

        return p.toString();  // Final result
    }
}
