class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0 || digits == null)
            return result;
        String[] mappings = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        generateLetterCombinations(result, mappings, "", 0, digits);
        return result;
    }
    public void generateLetterCombinations(List<String> result, String[] mappings, String currentString,int index, String digits) {

        if(currentString.length() == digits.length()) {
            result.add(currentString);
            return;
        }

        String letters = mappings[digits.charAt(index) - '0'];
        // System.out.println(letters);
        for (int i = 0; i < letters.length(); i++) {
            generateLetterCombinations(result, mappings, currentString + letters.charAt(i), index + 1, digits);
        }
    }
}