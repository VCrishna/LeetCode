class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 1) return words.length;
        int result = 0;
        Map<String, Integer> memo = new HashMap<>();
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        for (String word : words) {
            int longest = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String prev = current.deleteCharAt(i).toString();
                longest = Math.max(longest, memo.getOrDefault(prev, 0) + 1);
            }
            memo.put(word, longest);
            result = Math.max(result, longest);
        }

        return result;
    }
}
