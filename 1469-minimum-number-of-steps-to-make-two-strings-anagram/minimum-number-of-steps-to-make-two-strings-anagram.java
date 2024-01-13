class Solution {
    public int minSteps(String s, String t) {
        int[] freqArray = new int[26];

        for(char c : s.toCharArray()) {
            freqArray[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            freqArray[c - 'a']--;
        }
        int result = 0;
        for(int i = 0; i < 26; i++) {
            if(freqArray[i] > 0) {
                result += freqArray[i];
            }
        }
        return result;
    }
}