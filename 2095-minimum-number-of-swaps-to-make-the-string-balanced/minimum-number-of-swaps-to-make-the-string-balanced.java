class Solution {
    public int minSwaps(String s) {
        Stack<Character> stck = new Stack();
        for (char i : s.toCharArray()) {
            if (i == '[') {
                stck.push(i);
            } else {
                if (!stck.isEmpty() && i == ']') {
                    stck.pop();
                } else {
                    stck.push(i);
                }
            }
        }
        return stck.size() / 2;

    }
}