class Solution {
    public int minAddToMakeValid(String s) {
        if (s.length() == 0 || s == null)
            return 0;

        Stack<Character> stck = new Stack<>();
        for (char i : s.toCharArray()) {
            if (!stck.isEmpty() && i == ')' && stck.peek() == '(')
                stck.pop();
            else
                stck.push(i);
        }
        return stck.size();
    }
}