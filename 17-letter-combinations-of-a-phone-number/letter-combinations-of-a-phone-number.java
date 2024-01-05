class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mappings = new String[] { "", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        // digits, result, currentIndex, currentString, mappings
        // generateCombinations(digits, result, 0, "", mappings);
        if(digits.length() > 0) {
            backtrack(digits, result, 0, new StringBuilder(), mappings);
        }
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
        if (currentString.length() == digits.length()) {
            result.add(currentString);
            return;
        }
        String letters = mappings[digits.charAt(currentIndex) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, result, currentIndex + 1, currentString + letters.charAt(i), mappings);
        }
    }

    private void backtrack(
        String digits,
        List<String> result,
        int index, 
        StringBuilder path,
        String[] mappings
    ) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = mappings[digits.charAt(index) - '0'];
        for (char letter : possibleLetters.toCharArray()) {
            // Move on to the next digit
            path.append(letter);  // Append the current letter
            backtrack(digits, result, index + 1, path, mappings);
            path.deleteCharAt(path.length() - 1);  // Backtrack by removing the last character

        }
    }
}
