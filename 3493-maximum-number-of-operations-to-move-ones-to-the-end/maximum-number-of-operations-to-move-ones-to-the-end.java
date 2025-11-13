class Solution {
    public int maxOperations(String s) {
        int ones = 0, res = 0;  // `ones`: how many '1' blocks seen, `res`: result counter

        for (int i = 0; i < s.length(); i++) {
            // When we see a '1', we're inside or starting a new block of ones
            if (s.charAt(i) == '1') {
                ones++;
            }
            // When we see a '0' that follows a '1' (i.e., end of a '1' block)
            else if (i > 0 && s.charAt(i - 1) == '1') {
                res += ones;  // Each block of ones contributes one operation
            }
        }

        return res;
    }
}
