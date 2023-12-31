class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        Map<Character, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(indexMap.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, i - indexMap.get(s.charAt(i)) - 1);
            }
            else {
                indexMap.put(s.charAt(i), i);
            }
        }

        return maxLength;
    }
    public int maxLengthBetweenEqualCharacters_BRUTE_FORCE(String s) {
        int maxLength = -1;

        for(int left = 0; left < s.length(); left++) {
            for(int right = s.length() - 1; right >= 0; right--) {
                if(s.charAt(left) == s.charAt(right)) {
                    maxLength = Math.max(maxLength, right - left - 1);
                }
            }
        }

        return maxLength;
    }
}