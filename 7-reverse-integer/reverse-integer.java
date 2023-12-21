class Solution {
    public int reverse(int x) {
        int neg = x < 0 ? -1 : 1;

        long reversed = 0l;

        x = neg * x;

        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
        }

        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        return (int) reversed * neg;
    }
}