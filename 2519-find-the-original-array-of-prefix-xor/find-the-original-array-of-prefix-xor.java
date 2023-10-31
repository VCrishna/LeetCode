class Solution {
    public int[] findArray(int[] pref) {
        // The inverse of XOR is XOR itself
        // If the length of the given array `pref` is 1 or 0,
        // there's nothing to compute. So, return the same array.
        if (pref.length <= 1) return pref;
        // Create a new array `result` with the same length as `pref`
        int[] result = new int[pref.length];
        // The first element remains unchanged.
        result[0] = pref[0];
        // Loop through the array starting from the second element
        for (int i = 1; i < pref.length; i++) {
            // Compute the `i-th` element of the result using the XOR (^) operation
            // between the `(i-1)-th` and `i-th` elements of the `pref` array.
            // Intuitively, this operation retrieves the original value of the array
            // from which the prefix sum array `pref` was computed.
            result[i] = pref[i - 1] ^ pref[i];
        }

        return result;
    }
}
