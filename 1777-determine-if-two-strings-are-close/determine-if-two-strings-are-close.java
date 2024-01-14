class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] freqCount1 = new int[26];
        int[] freqCount2 = new int[26];

        for(char c : word1.toCharArray()) {
            freqCount1[c - 'a']++;
        }
        for(char c : word2.toCharArray()) {
            freqCount2[c - 'a']++;
        }
        // checking that all the characters exist in both arrays
        for(int i = 0; i < 26; i++) {
            if((freqCount1[i] == 0 && freqCount2[i] > 0) || 
                (freqCount1[i] > 0 && freqCount2[i] == 0)) {
                    return false;
                }
        }

        Arrays.sort(freqCount1);
        Arrays.sort(freqCount2);
        for(int i = 0; i < 26; i++) {
            if(freqCount1[i] != freqCount2[i]) {
                    return false;
                }
        }
        return true;
    }
}