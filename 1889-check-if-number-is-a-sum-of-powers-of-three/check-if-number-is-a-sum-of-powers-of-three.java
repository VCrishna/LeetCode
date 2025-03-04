class Solution {
    public boolean checkPowersOfThree(int n) {
        boolean result = true;

        while(n > 0) {
            if(n % 3 == 2) {
                return false;
            }
            n /= 3;
        }

        return result;
    }
}