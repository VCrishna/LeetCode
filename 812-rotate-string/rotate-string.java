class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if both strings have the same length, 
        // otherwise rotation is not possible
        if (s.length() != goal.length()) {
            return false;
        }
        // Concatenate s with itself
        String doubled = s + s;
        // Check if goal is a substring of the concatenated string
        return doubled.contains(goal);
    }
}