class Solution {
    public String smallestSubsequence(String s) {
        // Length of the given input string
        int strLength = s.length();
        // Array to hold the last occurrence indexes of characters in the given string
        int[] lastIndexArray = new int[26];
        
        // Updating the last occurrence indexes of characters in the array
        for (int i = 0; i < strLength; i++) 
            lastIndexArray[s.charAt(i) - 'a'] = i;
        
        // Visited array is used to handle duplications
        // We cannot add duplicate characters to the output string
        // Every character present in string s must be part of the output string
        // The frequency of each character should be 1
        // The output string should be lexographically smallest
        boolean[] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        
        // Iterating through the characters of the string
        for (int i = 0; i < strLength; i++) {
            // Extracting the current character
            int ch = s.charAt(i) - 'a';
            
            // Checking if the character is visited already
            // If it is visited already, we simply skip it 
            // as we do not want to add duplicates to the output string
            if (visited[ch])
                continue;
            
            // If it was not visited, we update the visited array
            // Marking that character as visited
            visited[ch] = true;

            // While loop to remove characters from the stack that are greater than the current character 
            // and have a later occurrence in the string
            while (!stack.isEmpty() 
                && stack.peek() > ch 
                && lastIndexArray[stack.peek()] > i) {
                // Pop the element from the stack and mark it as unvisited
                visited[stack.pop()] = false;
            }
            
            // Push the character into the stack
            stack.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Iterating over stack to build the result string
        // Since the stack contains characters in reverse order, we append characters from bottom to top
        for (int i : stack) 
            sb.append((char) (i + 'a'));
        
        return sb.toString();
    }
}