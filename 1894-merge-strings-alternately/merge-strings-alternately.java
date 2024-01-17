class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while(index1 < word1.length() && index2 < word2.length()) {
            result.append(word1.charAt(index1++));
            result.append(word2.charAt(index2++));
        }
        while(index1 < word1.length()) {
            result.append(word1.charAt(index1++));
        }
        while(index2 < word2.length()) {
            result.append(word2.charAt(index2++));
        }

        return result.toString();
    }
}