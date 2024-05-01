class Solution {
    public String reversePrefix(String word, char ch) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        StringBuilder rever = new StringBuilder();
        rever.append(word.substring(0, index + 1));
        return rever.reverse().toString() + word.substring(index + 1, word.length());
    }
}