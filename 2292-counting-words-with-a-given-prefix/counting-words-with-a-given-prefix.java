class Solution {
    public int prefixCount(String[] words, String pref) {
        int result = 0;

        for (String word : words) {
            result += word.startsWith(pref) ? 1 : 0;
        }

        return result;
    }
}