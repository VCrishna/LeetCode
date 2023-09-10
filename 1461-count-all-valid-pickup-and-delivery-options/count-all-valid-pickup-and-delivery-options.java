class Solution {
    // Valid slots = n * 2;
    // count valid ways to arrange a pair p1 and d1
    // n * (n - 1) --> Choices can be made
    // ex: n = 4
    // p1 , d1, p2 , d2 --> valid way
    // d1 , p1, p2 , d2 --> invalid way --> d1 occured before p1 so it is invalid
    // only half of them occurs before d so we divide n * (n - 1) by 2 to get valid choices
    public int countOrders(int n) {
        // it is mentioned in the question that we need to divide result with mod 10 ^ 9 + 7 in each iteration
        long modulo = (long) (1e9 + 7);
        // result variable
        long result = 1;
        // total number of slots available --> 2 * n (pickup, delivery)
        int slots = 2 * n;
        // we need to run this loop until the slots are empty
        while(slots > 0) {
            // calculating the valid no. of choices
            // as mentioned above valid and invalid ways (p should occur before d)
            long valid_choices = slots * (slots - 1) / 2;
            // calculating result by multiplying with valid choices and mod with modulo
            result = (result * valid_choices) % modulo;
            // for each iteration we decrease slots by 2 as (p,d)
            slots -= 2;
        }
        // typecasting result to int
        return (int) result;
    }
}
