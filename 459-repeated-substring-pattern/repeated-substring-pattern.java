class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        System.out.println(str.substring(1, str.length() - 1));
        return str.substring(1, str.length() - 1).contains(s);
    }
}