class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        for(String word : s.split(" ")) {
            result.append(new StringBuilder(word).reverse().toString());
            result.append(" ");
        }
        return result.toString().stripTrailing();
    }
}