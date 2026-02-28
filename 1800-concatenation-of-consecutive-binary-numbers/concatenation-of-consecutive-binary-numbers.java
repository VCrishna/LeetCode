class Solution {

  public int concatenatedBinary(int n) {

    final int MOD = 1_000_000_007;

    long result = 0;  // Use long to avoid overflow during shifting

    /*
        For each number i from 1 to n:
        We append its binary representation to result.

        Appending binary means:
        1) Shift result left by number of bits in i
        2) Add i
    */
    for (int i = 1; i <= n; ++i) {

      int bits = numberOfBits(i);

      /*
          Example:
          Suppose result = binary 101 (5)
          i = 3 → binary 11 (2 bits)

          Step 1: shift result by 2 bits
                  101 << 2 = 10100

          Step 2: add i
                  10100 + 11 = 10111
      */
      result = ((result << bits) % MOD + i) % MOD;
    }

    return (int) result;
  }

  /*
      Returns number of bits required to represent n in binary.

      For example:
      n = 1 → 1 bit
      n = 2 → 2 bits
      n = 3 → 2 bits
      n = 4 → 3 bits

      Formula:
          floor(log2(n)) + 1
  */
  private int numberOfBits(int n) {
    return (int) (Math.log(n) / Math.log(2)) + 1;
  }
}