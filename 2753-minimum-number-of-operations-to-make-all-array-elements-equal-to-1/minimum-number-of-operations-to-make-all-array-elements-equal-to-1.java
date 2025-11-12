class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;  // count of numbers already equal to 1
        int g = 0;     // overall gcd of the array
        
        // Step 1: Count 1s and compute gcd of all elements
        for (int x : nums) {
            if (x == 1) {
                num1++;
            }
            g = gcd(g, x);
        }
        
        // Step 2: If there are already 1s
        if (num1 > 0) {
            return n - num1;  // each non-1 needs one operation
        }
        
        // Step 3: If gcd of all elements > 1, impossible to get a 1
        if (g > 1) {
            return -1;
        }

        // Step 4: Otherwise, find the shortest subarray with gcd == 1
        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;  // no need to extend further
                }
            }
        }
        
        // Step 5: Total operations = (to get one 1) + (to spread 1s)
        return minLen + n - 2;
    }

    // Helper method to compute gcd using Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
