class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        for (String word : s.split(" ")) {
            result.append(new StringBuilder(word).reverse().toString());
            result.append(" ");
        }

        // As we append space for every word in the string, 
        // we have also appended space after last word
        // so last space is removed by calling stripTrailing method of string class
        return result.toString().stripTrailing();
    }
}