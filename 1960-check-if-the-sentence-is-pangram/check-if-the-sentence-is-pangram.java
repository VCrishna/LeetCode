class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] charCount = new int[26];

        for(char c : sentence.toCharArray()) {
            charCount[c - 'a']++;
        }
        for(int i : charCount) {
            if(i == 0)
                return false;
        }
        return true;
    }
}