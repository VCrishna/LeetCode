class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        // If k == 0, all elements should be set to 0
        if (k == 0) {
            return result; // An array filled with 0s
        }
        
        // Handle k > 0: sum of the next k elements
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Circular array using modulo
                }
                result[i] = sum;
            }
        }
        
        // Handle k < 0: sum of the previous |k| elements
        else { // k < 0
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Circular array using modulo
                }
                result[i] = sum;
            }
        }
        
        return result;
    }

    // Intial brute force
    public int[] decryptBruteForce(int[] code, int k) {
        int[] kGreater = new int[code.length];
        int[] kLesser = new int[code.length];
        int sum = 0;
        for (int i : code) {
            sum += i;
        }
        // if k > 0
        for (int i = 0; i < code.length; i++) {
            kGreater[i] = sum - code[i];
        }
        // if k < 0
        for (int i = code.length - 1; i >= 0; i--) {
            kLesser[i] = sum - code[i];
        }
        for (int i = 0; i < code.length; i++) {
            if (k > 0) {
                code[i] = kGreater[i];
            } else if (k < 0) {
                code[i] = kLesser[i];
            }
            else {
                code[i] = 0;
            }
        }
        return code;
    }
}