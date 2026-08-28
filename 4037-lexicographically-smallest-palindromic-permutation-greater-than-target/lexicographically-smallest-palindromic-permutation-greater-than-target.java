class Solution {

    int[] count = new int[26];
    char[] result;

    String target;

    public boolean recursive(int x, boolean match) {
        int mid = target.length() / 2 + target.length() % 2;
        int last = target.length() - 1;
        if (x == mid) {
            // This could also be done by adding a third var to sig
            for (int i = mid - 1; match && i >= 0; i--) {
                if (result[i] > target.charAt(last - i)) {
                    return true;
                } else if (result[i] < target.charAt(last - i)) {
                    return false;
                }
            }
            return !match;
        }
        int i = match ? Math.min(target.charAt(last - x), target.charAt(x) - 'a') : 0;
        boolean middle = target.length() % 2 == 1 && x == target.length() / 2;
        int usage = middle ? 1 : 2; // Only use 1 if at midpoint
        while (i < count.length) {
            if (count[i] >= usage) {
                count[i] -= usage;
                result[x] = (char) (i + 'a');
                if (recursive(x + 1,
                        match && i == target.charAt(x) - 'a')) {
                    return true;
                }
                count[i] += usage;
            }
            i++;
        }
        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean once = false;
        for (int i : count) {
            if (i % 2 == 1) {
                if (once) {
                    return "";
                }
                once = true;
            }
        }
        this.target = target;
        result = new char[s.length()];
        if (!recursive(0, true)) {
            return "";
        }
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = result[i];
        }
        return new String(result);
    }
}