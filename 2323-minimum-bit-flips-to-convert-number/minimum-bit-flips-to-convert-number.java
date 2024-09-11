class Solution {
    public int minBitFlips(int start, int goal) {
        // Initializing a counter to track the number of bit flips needed
        int cnt = 0;

        // Looping through all 32 bits of the integers (since an int has 32 bits)
        for (int i = 0; i < 32; i++) {
            // Creating a mask by shifting 1 left by 'i' bits (isolating the i-th bit)
            int msk = (1 << i);

            // Comparing the i-th bit of 'start' and 'goal' using bitwise AND (&) with the mask
            // This checks if the bit in 'start' is 0 while the bit in 'goal' is 1
            // OR if the bit in 'start' is 1 while the bit in 'goal' is 0
            if (((start & msk) == 0 && (goal & msk) != 0)
                    || ((start & msk) != 0 && (goal & msk) == 0)) {
                // If the bits are different, incrementing the flip counter
                cnt++;
            }
        }

        // After checking all 32 bits, returning the total number of flips needed
        return cnt;
    }
}
