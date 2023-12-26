class Solution {
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') 
                stck.push(')'); 
            else if (c == '{') 
                stck.push('}'); 
            else if (c == '[') 
                stck.push(']'); 
            else if (stck.isEmpty() || stck.pop() != c) 
                return false;
        }
        return stck.isEmpty();
    }
}
