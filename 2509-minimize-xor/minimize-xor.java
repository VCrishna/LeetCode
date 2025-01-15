class Solution {
    public int minimizeXor(int num1, int num2) {
        int countNum1 = countSetBits(num1);
        int countNum2 = countSetBits(num2);

        // If num1 already has the same number of set bits as num2
        if (countNum1 == countNum2) {
            return num1;
        }

        // If num2 has more set bits than num1, we need to set more bits in num1
        if (countNum2 > countNum1) {
            while (countNum1 != countNum2) {
                num1 = num1 | (num1 + 1); // Set the rightmost bit to 1
                countNum1++;
            }
            return num1;
        }

        // If num1 has more set bits than num2, we need to clear some bits in num1
        if (countNum2 < countNum1) {
            while (countNum1 != countNum2) {
                num1 = num1 & (num1 - 1); // Set the rightmost set bit to 0
                countNum1--;
            }
            return num1;
        }
        
        return num1;  // Default case (though this shouldn't be reached)
    }

    // Function to count the number of set bits (1s) using Brian Kernighan’s Algorithm
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // This removes the rightmost set bit
            count++;
        }
        return count;
    }
}