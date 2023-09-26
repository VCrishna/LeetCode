class Solution {
    public String smallestSubsequence(String s) {
        int strLength = s.length();
        int[] lastIndexArray = new int[26];
        for (int i = 0; i < strLength; i++) {
            lastIndexArray[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strLength; i++) {
            int ch = s.charAt(i) - 'a';
            if (visited[ch]) 
                continue;
            visited[ch] = true;
            while (
                !stack.isEmpty() && 
                stack.peek() > ch && 
                lastIndexArray[stack.peek()] > i
            ) {
                visited[stack.pop()] = false;
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) 
            sb.append((char) (i + 'a'));
        return sb.toString();
    }
}
