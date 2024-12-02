class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.indexOf(searchWord) == 0)
            return 1;
        int index = sentence.indexOf(" " + searchWord);
        if (index == -1)
            return -1;

        int count = 0;
        for (int i = 0; i < index + 1; i++) {
            if (sentence.charAt(i) == ' ') {
                count++;
            }
        }
        return count + 1;
    }
}