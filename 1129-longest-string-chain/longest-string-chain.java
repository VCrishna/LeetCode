class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 1) return words.length;
        Map<String, Integer> memo = new HashMap<>();
        int count = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // Arrays.sort(words, Comparator.comparingInt(String::length));
        memo.putIfAbsent(words[0], words[0].length());
        for (String word : words) {
            memo.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder current = new StringBuilder(word);
                String next = current.deleteCharAt(i).toString();
                if (memo.containsKey(next)) {
                    memo.put(word, Math.max(memo.get(word), memo.get(next) + 1));
                }
            }
            count = Math.max(count, memo.get(word));
        }
        return count;
    }
}
