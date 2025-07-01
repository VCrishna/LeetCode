class Solution {
    public int possibleStringCount(String word) {
        // Start with 1 because the original string itself is a valid possibility.
        // Alice might not have made any mistakes.
        long ans = 1;

        // We will scan through the word to find groups of consecutive same characters.
        for (int i = 0, n = word.length(); i < n;) {
            int j = i;

            // Move j forward while characters at i and j are the same.
            // This loop identifies a group of repeated characters starting at i.
            while (j < n && word.charAt(j) == word.charAt(i))
                j++;

            // Suppose characters from i to j-1 are the same (i.e., length = j - i).
            // If group length = L, then we can remove 1 to L - 1 duplicates,
            // giving us (L - 1) different possible original strings.
            // But since Alice can only make *one* such mistake in the whole word,
            // we add all such (L - 1) options to ans and allow choosing any one later.
            ans += (j - i - 1);

            // Move i to j to start the next group.
            i = j;
        }

        // Return total number of distinct original strings:
        // 1 for the original + 1 for each unique reduction of any one group.
        return (int) ans;
    }
}
