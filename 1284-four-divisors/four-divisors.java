class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        int[] sumOfDivisors = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sumOfDivisors[i] = findAndReturnNumberofDivisors(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (sumOfDivisors[i] != -1) {
                result += sumOfDivisors[i];
            }
        }
        return result;
    }

    public int findAndReturnNumberofDivisors(int n) {
        int sum = 0;
        int count = 0;

        // Loop only up to sqrt(n) to find divisors
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;  // i is a divisor
                sum += i;

                // Check if n / i is a different divisor
                if (i != n / i) {
                    count++;
                    sum += n / i;
                }
            }
        }

        // If exactly 4 divisors, return their sum, else return -1
        return count == 4 ? sum : -1;
    }
}