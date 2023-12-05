class Solution {
    public int numberOfMatches(int n) {
        int result = -1;
        while(n > 0) {
            if (n % 2 == 0) {
                result += (n / 2);
                n /= 2;
            }
            else {
                result++;
                n--;
                result += (n / 2);
                n /= 2;
            }
        }

        return result;
    }
}