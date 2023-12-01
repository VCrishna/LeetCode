class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0;
        int i = 0, j = 0;
        while (w1 < word1.length && w2 < word2.length) {
            if(word1[w1].charAt(i) != word2[w2].charAt(j)) {
                return false;
            }
            i++;
            j++;
            if(i == word1[w1].length()) {
                i = 0;
                w1++;
            }
            if(j == word2[w2].length()) {
                j = 0;
                w2++;
            }
        }
        if (w1 != word1.length || w2 != word2.length) {
            return false;
        }
        return true;
    }

    public boolean arrayStringsAreEqual_BRUTE_FORCE(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) sb1.append(s);
        for (String s : word2) sb2.append(s);
        return sb1.toString().equals(sb2.toString());
    }
}
