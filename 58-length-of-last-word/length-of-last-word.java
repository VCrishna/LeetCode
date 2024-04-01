class Solution {
    public int lengthOfLastWord(String s) {
        String[] sp = s.split(" ");
        return sp[sp.length - 1].length();
    }
}