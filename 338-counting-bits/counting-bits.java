/**

The line `result[i] = result[i & (i - 1)] + 1;` is used to calculate the number of set bits (or number of 1s) in the binary representation of `i`.

Let's break down this line of code step by step:

1. `i & (i - 1)`:
   This bitwise operation `&` performs an AND operation between `i` and `(i - 1)`. 
   The result of this operation is a number that has the same bits set as the result of `(i - 1)`, 
   but with the rightmost set bit in `i` is cleared. In other words, it removes the rightmost set bit from `i`.

   For example, if `i` is 10, which is `1010` in binary, then `(i - 1)` is 9, which is `1001` in binary. 
   Performing `i & (i - 1)` gives us 8, which is `1000` in binary.

   The purpose of this operation is to clear the rightmost set bit of `i` because the number of set bits in `i` and `i & (i - 1)` differ by exactly 1.

2. `result[i & (i - 1)] + 1`:
   
   Once we have `i & (i - 1)`, we use it as an index to access the `result` array. 
   The value at index `i & (i - 1)` represents the number of set bits in the binary representation of `i & (i - 1)`.

   By adding 1 to this count, we get the number of set bits in the binary representation of `i`.

   For example, if `result[8]` is 2, then `result[8 & (8 - 1)]` gives us `result[8 & 7]`, 
   which is `result[0b1000 & 0b0111]`, resulting in `result[0b0000]`. If this value is 2, 
   then `result[8]` will be `result[0b0000] + 1`, which is 3.

   This step utilizes the previously calculated counts to build up the result for larger numbers based on the counts for smaller numbers.

    The overall purpose of this line of code is to calculate the number of set bits in the binary representation of `i`
    by utilizing the counts of set bits in the binary representations of smaller numbers.

*/
class Solution {
    public int[] countBits(int n) {
        // result array used to store the no. of 1's present in each number
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1; // Count the number of 1s in i and store it in result[i]
        }
        return result;
    }
}
