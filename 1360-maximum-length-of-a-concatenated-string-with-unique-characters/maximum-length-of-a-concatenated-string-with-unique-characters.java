class Solution {
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        // arr, index, currentString, int[] result
        backtrack(arr, 0, "", result);
        return result[0];
    }
    public void backtrack(
        List<String> arr,
        int index,
        String currentString,
        int[] result
    ) {
        if(index == arr.size() && noOfUniqueCharacters(currentString) > result[0]) {
            result[0] = noOfUniqueCharacters(currentString);
            return;
        }
        if(index == arr.size()) {
            return;
        }
        // consider current word
        backtrack(arr, index + 1, currentString + arr.get(index), result);
        // do not consider current word
        backtrack(arr, index + 1, currentString, result);
    }
    public int noOfUniqueCharacters(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            if(count[c - 'a']++ > 0) {
                return -1;
            }
        }
        return s.length();
    }
}