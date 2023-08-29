class Solution {
    public int bestClosingTime(String customers) {
        // Length of the String customers -- Total number of customers 
        int n = customers.length();
        // prefix array used to store what will be the penalty,
        // if close the shop at that particular index
        int[] prefix = new int[n + 1];
        // postfix array used to store what will be the penalty,
        // if close the shop at that particular index
        int[] postfix = new int[n + 1];
        // Initializing the first element in prefix array and last element in the postfix array to 0
        prefix[0] = 0;
        postfix[n] = 0;
        // To calculate prefix we iterate in forward direction form 0 --> n + 1
        for (int i = 1; i < n + 1; i++) {
            // copying value from previous index
            // if this value is 'N', 
            // which means that there is no customer during that hour when show is open
            // if there's no customer when the shop is open,
            // then we are going to increment the count at this index by 1
            prefix[i] = prefix[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefix[i] = prefix[i] + 1;
            }
        }
        // To calculate postfix we iterate in reverse direction form n - 1 --> 0 (From last element to first)
        for (int i = n - 1; i >= 0; i--) {
            // copying value from previous index
            // if this value is 'Y',
            // which means that there are customers when the shop is closed
            // so we increase the penalty by 1 at that index
            postfix[i] = postfix[i + 1];
            if (customers.charAt(i) == 'Y') {
                postfix[i] = postfix[i] + 1;
            }
        }
        // minimum penalty variable --> Max value as we calculate current penalty 
        // which will be less than Integer.MAX_VALUE
        int minimumPenalty = Integer.MAX_VALUE;
        // index with minimum penalty
        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            // calculating current penalty, it is the sum of values from prefix and postfix array at index i
            int currentPenalty = prefix[i] + postfix[i];
            // if the current penalty is less than the minimum penalty,
            // then we are going to update the minimum penalty and index at which minimum penalty is occured
            if (currentPenalty < minimumPenalty) {
                index = i;
                minimumPenalty = currentPenalty;
            }
        }
        return index;
    }
}
