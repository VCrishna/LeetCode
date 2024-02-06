class Solution {
    public boolean backspaceCompare(String S, String T) {
        // Initialize pointers for traversing the strings from the end
        int i = S.length() - 1, j = T.length() - 1;
        // Variables to track the number of backspaces encountered in each string
        int skipS = 0, skipT = 0;

        // Iterate until there are characters left in either string
        while (i >= 0 || j >= 0) {
            // Find the position of the next possible character in S after skipping  backspaces
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    // If encountering a backspace, 
                    // increment skipS and move to the previous  character
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    // If encountering a character to be skipped due to a previous backspace,
                    // decrement skipS
                    skipS--;
                    i--;
                } else {
                    // If encountering an actual character, break out of the loop
                    break;
                }
            }

            // Find the position of the next possible character in T after skipping
            // backspaces
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    // If encountering a backspace, increment skipT and move to the previous
                    // character
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    // If encountering a character to be skipped due to a previous backspace,
                    // decrement skipT
                    skipT--;
                    j--;
                } else {
                    // If encountering an actual character, break out of the loop
                    break;
                }
            }

            // If there are characters left in both strings and they are different, return
            // false
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;

            // If there are characters left in one string but not the other, return false
            if ((i >= 0) != (j >= 0))
                return false;

            // Move to the previous characters in both strings
            i--;
            j--;
        }

        // If no differences are found, return true
        return true;
    }

    public boolean backspaceCompare_BRUTE_FORCE(String s, String t) {
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