class Solution {
    public int minOperations(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                if (s.charAt(i) == '0') count += 1;
            } else {
                if (s.charAt(i) == '1') count += 1;
            }
        }

        return Math.min(count, s.length() - count);
    }
}
