class Solution {
    public int passThePillow(int n, int time) {
        int result = 1;
        boolean forward = true;
        while(time > 0) {
            if (forward) {
                if (result < n) {
                    result++;
                } else {
                    forward = false;
                    result--; // Change direction and move to the previous person
                }
            } else {
                if (result > 1) {
                    result--;
                } else {
                    forward = true;
                    result++; // Change direction and move to the next person
                }
            }
            time--;
        }
        return result;
    }
}