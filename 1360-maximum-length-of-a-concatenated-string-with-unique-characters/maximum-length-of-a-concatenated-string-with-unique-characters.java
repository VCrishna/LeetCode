class Solution {
    private int result = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, 0, "");
        return result;
    }

    private void backtrack(List<String> arr, int index, String currentString) {
        if (index == arr.size() && isUnique(currentString)) {
            result = Math.max(result, currentString.length());
            return;
        }

        if (index == arr.size()) {
            return;
        }

        // consider current word
        backtrack(arr, index + 1, currentString + arr.get(index));
        // do not consider current word
        backtrack(arr, index + 1, currentString);
    }

    private boolean isUnique(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!uniqueChars.add(c)) {
                return false;
            }
        }
        return true;
    }
}