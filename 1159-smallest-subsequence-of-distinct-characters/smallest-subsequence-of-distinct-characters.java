class Solution {
    public String smallestSubsequence(String s) {
        // length of given input string
        int strLength = s.length();
        // array to hold last occurance of indexes of characters in the given string
        int[] lastIndexArray = new int[26];
        // updating last occured indexes of characters in the array
        for (int i = 0; i < strLength; i++) 
            lastIndexArray[s.charAt(i) - 'a'] = i;
        // visited array is used to handle the duplications
        // we cannot add duplicate characters to the output string
        // every character present in string s must be part of output string
        // and frequency of each character should be 1
        // and output string should be lexographically smallest
        boolean[] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strLength; i++) {
            // extracting current character
            int ch = s.charAt(i) - 'a';
            // checking if the character is visited already
            // if it is visited already we are simplify skiping it 
            // as we donot want to add duplicates to the output string
            if(visited[ch])
                continue;
            // if it was not visited we are updating visited array
            // marking that character as visited
            visited[ch] = true;

            while(
                // stack should not be empty
                !stack.isEmpty() 
                // top character in stack is greater than the current character
                && stack.peek() > ch 
                // last index of my top character is greater than i
                && lastIndexArray[stack.peek()] > i
                ) {
                    // simply delete the element from stack and mark it as un visited
                   visited[stack.pop()] = false;
                }
            // push the character into stack
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        // iterating over stack in this way will help us to iterate from bottom to top of stack
        for (int i : stack) 
            sb.append((char) (i + 'a'));
        return sb.toString();
    }
}