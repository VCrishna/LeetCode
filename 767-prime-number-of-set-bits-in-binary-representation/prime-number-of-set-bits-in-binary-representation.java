class Solution {

    // Prime numbers possible for set-bit count (max 32 bits → max 32 ones)
    private static int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19 };

    /*
        Compute nCk using factorial division.

        Instead of full factorial,
        we compute:

            n! / (k! * (n-k)!)

        as:

            (k+1 ... n) / (2 ... n-k)
    */
    private int comb(int n, int k) {

        if (n <= 0 || k <= 0 || k > n)
            return 0;

        long numerator = 1, denominator = 1;

        for (int i = k + 1; i <= n; i++) {
            numerator *= i;
        }

        for (int i = 2; i <= n - k; i++) {
            denominator *= i;
        }

        return (int) (numerator / denominator);
    }

    /*
        Count how many ways we can choose additional set bits
        so that total set bits becomes prime.

        av = available bit positions
        al = already used set bits
    */
    private int countValid(int availableBits, int alreadySet) {

        int totalWays = 0;

        for (int prime : PRIMES) {

            int needed = prime - alreadySet;

            if (needed < 0 || needed > availableBits)
                continue;

            totalWays += comb(availableBits, needed);
        }

        return totalWays;
    }

    /*
        Return how many prime values <= num exist in PRIMES.
        Used to check final count.
    */
    private int countPrimes(int num) {

        for (int i = PRIMES.length - 1; i >= 0; i--) {
            if (num >= PRIMES[i]) {
                return i + 1;
            }
        }

        return 0;
    }

    /*
        Count numbers in range [0, num]
        whose number of set bits is prime.

        This is a classic "digit DP on bits" idea.

        We walk bit by bit from MSB to LSB.
    */
    private int countNum(int num) {

        if (num == 0)
            return 0;

        int mask = 0x40000000;   // highest bit (2^30)
        int bitPosition = 31;    // remaining bit positions
        int setBitsSoFar = 0;    // number of 1s seen so far
        int totalCount = 0;

        while (mask != 0) {

            if ((num & mask) != 0) {

                /*
                    If current bit is 1,
                    we can place 0 here
                    and freely choose remaining bits.

                    Count all valid combinations of remaining bits.
                */
                totalCount += countValid(bitPosition - 1, setBitsSoFar);

                // Fix this bit as 1 and continue
                setBitsSoFar++;
            }

            mask >>>= 1;
            bitPosition--;
        }

        /*
            Finally check num itself:
            If total set bits in num is prime,
            add 1.
        */
        totalCount += countPrimes(setBitsSoFar);

        return totalCount;
    }

    /*
        Count numbers in range [left, right]
        having prime number of set bits.
    */
    public int countPrimeSetBits(int left, int right) {

        return countNum(right) - countNum(left - 1);
    }
}
