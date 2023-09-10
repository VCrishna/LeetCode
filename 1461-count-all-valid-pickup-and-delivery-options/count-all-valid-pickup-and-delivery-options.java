class Solution {
    // Valid slots = n * 2;
    // count valid ways to arrange a pair p1 and d1
    // n * (n - 1) --> Choices can be made
    // ex: n = 4
    // p1 , d1, p2 , d2 --> valid way
    // d1 , p1, p2 , d2 --> invalid way --> d1 occured before p1 so it is invalid
    // only half of them occurs before d so we divide n * (n - 1) by 2 to get valid choices
    public int countOrders(int n) {
        long mod = (long) (1e9 + 7);
        long result = 1;
        int slots = 2 * n;
        while(slots > 0) {
            long valid_choices = slots * (slots - 1) / 2;
            result = (result * valid_choices) % mod;
            slots -= 2;
        }
        // for (int i = 1; i <= n; i++) {
        //     long valid_choices = slots * (slots - 1) / 2;
        //     result = (result * valid_choices) % mod;
        //     slots -= 2;
        // }

        return (int) result;
    }
}
