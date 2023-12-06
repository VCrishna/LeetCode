class Solution {
    public int totalMoney(int n) {
        int day = 0;
        int deposit = 1;
        int result = 0;
        while (day < n) {
            result += deposit;
            deposit++;
            day++;
            if(day % 7 == 0) {
                deposit = 1 + (day / 7);
            }
        }
        return result;
    }
}