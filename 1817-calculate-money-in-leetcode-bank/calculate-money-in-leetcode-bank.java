class Solution {
    public int totalMoney(int n) {
      int weeks = n / 7;
      // week 1
      int low = 28;
      int high = 28 + 7 * ( weeks - 1);
      // int result = (low + high) * (weeks / 2);
      int result = (weeks * (low + high) / 2);
      int monday = weeks + 1;
      for(int i = 0; i < n % 7; i++) {
        result += i + monday;
      }


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
