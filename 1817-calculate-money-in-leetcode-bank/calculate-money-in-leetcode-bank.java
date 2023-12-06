class Solution {

    public int totalMoney(int n) {
        // Calculate the number of complete weeks
        int weeks = n / 7;

        // Calculate the total money for the complete weeks using arithmetic series formula
        // week 1
        int low = 28; // Initial money on Monday of the first week
        int high = 28 + 7 * (weeks - 1); // Money on Sunday of the last complete week
        int result = (weeks * (low + high) / 2); // Sum of the arithmetic series for complete weeks

        // Calculate money for the remaining days
        int monday = weeks + 1; // Money on Monday of the current week
        for (int i = 0; i < n % 7; i++) {
            result += i + monday; // Add money for each remaining day of the current week
        }
        // Return the total money
        return result;
    }
    public int totalMoney_BRUTE_FORCE(int n) {
        int day = 0;
        int deposit = 1;
        int result = 0;
        while (day < n) {
            // everyday we deposit so we increase result by deposit amount
            result += deposit;
            // for next day deposit should be increased by than the previous day
            deposit++;
            // incrementing day by 1
            day++;
            // to reset the deposit
            // checking if the day is first day of the week if so
            if (day % 7 == 0) {
                // updating the deposit
                deposit = 1 + (day / 7);
            }
        }
        return result;
    }
}
