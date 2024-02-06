class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        while (!st.isEmpty()) {
            s1.append(st.pop());
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            s2.append(st.pop());
        }
        return s1.toString().equals(s2.toString());
    }
}