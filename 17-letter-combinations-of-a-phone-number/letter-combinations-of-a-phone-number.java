class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        String[] mappings = new String[] {
            "",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        // digits, result, currentIndex, currentString, mappings
        generateCombinations(digits, result, 0, "", mappings);
        return result;
    }
    // backtracking helper method
    public void generateCombinations(
        String digits, 
        List<String> result,
        int currentIndex,
        String currentString,
        String[] mappings
        ) {
            if(currentString.length() == digits.length()) {
                result.add(currentString);
                return;
            }
            String letters = mappings[digits.charAt(currentIndex) - '0'];
            for(int i = 0; i < letters.length(); i++) {
                generateCombinations(
                    digits,
                    result,
                    currentIndex + 1,
                    currentString + letters.charAt(i),
                    mappings
                );
            }
        }
}