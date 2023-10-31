/**
    'a' can only be followed by 'e'.
    'e' can be followed by either 'a' or 'i'.
    'i' can be followed by 'a', 'e', 'o', or 'u'.
    'o' can be only be followed by 'i' or 'u'.
    'u' can only be followed by 'a'.
    
    -> For 'a', a valid string of length i can only be formed by appending 'e' 
       to a valid string of length i-1 that ends with 'e', 'i', or 'u'.

    -> For 'e', a valid string of length i can be formed by appending 'a' or 'i' 
       to a valid string of length i-1 that ends with 'a' or 'e'.

    -> For 'i', a valid string of length i can be formed by appending 'a', 'e', 'o', or 'u' 
       to a valid string of length i-1 that ends with 'a', 'e', 'i', 'o', or 'u'.

    -> For 'o', a valid string of length i can only be formed by appending 'i' or 'u' 
       to a valid string of length i-1 that ends with 'i' or 'o'.

    -> For 'u', a valid string of length i can be formed by appending 'a' or 'i' 
       to a valid string of length i-1 that ends with 'i' or 'u'.

 */

class Solution {

    public int countVowelPermutation(int n) {
        long[] aVowelPermutationCount = new long[n];
        long[] eVowelPermutationCount = new long[n];
        long[] iVowelPermutationCount = new long[n];
        long[] oVowelPermutationCount = new long[n];
        long[] uVowelPermutationCount = new long[n];

        aVowelPermutationCount[0] = 1L;
        eVowelPermutationCount[0] = 1L;
        iVowelPermutationCount[0] = 1L;
        oVowelPermutationCount[0] = 1L;
        uVowelPermutationCount[0] = 1L;

        int MOD = (int) 1e9 + 7;

        for (int i = 1; i < n; i++) {
            aVowelPermutationCount[i] = ( eVowelPermutationCount[i - 1] + 
                                          iVowelPermutationCount[i - 1] + 
                                          uVowelPermutationCount[i - 1]) % MOD;
            eVowelPermutationCount[i] = ( aVowelPermutationCount[i - 1] + 
                                          iVowelPermutationCount[i - 1]) % MOD;
            iVowelPermutationCount[i] = ( eVowelPermutationCount[i - 1] + 
                                          oVowelPermutationCount[i - 1]) % MOD;
            oVowelPermutationCount[i] = ( iVowelPermutationCount[i - 1]) % MOD;
            
            uVowelPermutationCount[i] = ( oVowelPermutationCount[i - 1] + 
                                          iVowelPermutationCount[i - 1]) % MOD;
        }
        long result = 0l;

        result = ( aVowelPermutationCount[n - 1] + 
                   eVowelPermutationCount[n - 1] + 
                   iVowelPermutationCount[n - 1] + 
                   oVowelPermutationCount[n - 1] + 
                   uVowelPermutationCount[n - 1]) % MOD;

        return (int) result;
    }
}
