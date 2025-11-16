class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        int result = 0;
        int consect = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                consect = 0;
                continue;
            } else {
                consect++;
                result = (result + consect) % mod;
            }
        }
        return result;
    }
}