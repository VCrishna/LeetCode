class Solution {
    public int maxSumDivThree(int[] nums) {

        // Total sum of all elements
        int total = 0;

        // Track the smallest and second smallest elements with remainder 1
        int minRem1 = 99999, secondMinRem1 = 99999;

        // Track the smallest and second smallest elements with remainder 2
        int minRem2 = 99999, secondMinRem2 = 99999;

        // Step 1: Compute total sum and track smallest remainders
        for (int num : nums) {
            total += num;

            int rem = num % 3;

            // Case: remainder 1 element
            if (rem == 1) {
                if (num < minRem1) {
                    secondMinRem1 = minRem1;
                    minRem1 = num;
                } else if (num < secondMinRem1) {
                    secondMinRem1 = num;
                }
            }

            // Case: remainder 2 element
            else if (rem == 2) {
                if (num < minRem2) {
                    secondMinRem2 = minRem2;
                    minRem2 = num;
                } else if (num < secondMinRem2) {
                    secondMinRem2 = num;
                }
            }
        }

        // Step 2: If total is already divisible by 3, return it
        if (total % 3 == 0) {
            return total;
        }

        // Step 3: Adjust if total % 3 == 1
        // Two ways to fix:
        // Option A: subtract the smallest remainder-1 element
        // Option B: subtract two smallest remainder-2 elements
        if (total % 3 == 1) {
            int optionA = total - minRem1;
            int optionB = total - minRem2 - secondMinRem2;
            return Math.max(optionA, optionB);
        }

        // Step 4: Adjust if total % 3 == 2
        // Two ways to fix:
        // Option A: subtract the smallest remainder-2 element
        // Option B: subtract two smallest remainder-1 elements
        int optionA = total - minRem2;
        int optionB = total - minRem1 - secondMinRem1;
        return Math.max(optionA, optionB);
    }
}
