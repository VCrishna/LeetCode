class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        // If the length of s1 is greater than s2, 
        // it's not possible for s1 to be a permutation of s2
        if (len1 > len2)
            return false;

        // Arrays to store the count of characters in the 
        // current window for both strings
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Initializing the counts for the first window of size len1
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        // Checking if the counts of characters in the first window match
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] == count2[i])
                matches++;
        }

        int left = 0;

        // Using a sliding window to traverse the rest of s2
        for (int right = len1; right < len2; right++) {
            // If all characters have matching counts, 
            // s1 is a permutation of the current window in s2
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(right) - 'a';

            // Updating counts for the new character in the window
            count2[index]++;

            // Updating matches based on the change in counts
            if (count1[index] == count2[index]) {
                matches++;
            } 
            // Adjusting matches when the count of the current character in s2 
            // becomes one more than in s1
            else if (count1[index] + 1 == count2[index]) {
                matches--;
            }

            // Updating counts for the character leaving the window
            index = s2.charAt(left) - 'a';
            count2[index]--;

            // Updating matches based on the change in counts
            if (count1[index] == count2[index]) {
                matches++;
            }
            // Adjusting matches when the count of the current character in s2 
            // becomes one less than in s1
            else if (count1[index] - 1 == count2[index]) {
                matches--;
            }

            left++;
        }

        // Checking for the last window
        return matches == 26;
    }
}

// public class Solution {
// public boolean checkInclusion(String s1, String s2) {
// int len1 = s1.length(), len2 = s2.length();

// if (len1 > len2) return false;

// int[] count = new int[26];
// for (int i = 0; i < len1; i++) {
// count[s1.charAt(i) - 'a']++;
// count[s2.charAt(i) - 'a']--;
// }
// if (allZero(count)) return true;

// for (int i = len1; i < len2; i++) {
// count[s2.charAt(i) - 'a']--;
// count[s2.charAt(i - len1) - 'a']++;
// if (allZero(count)) return true;
// }

// return false;
// }

// private boolean allZero(int[] count) {
// for (int i = 0; i < 26; i++) {
// if (count[i] != 0) return false;
// }
// return true;
// }
// }