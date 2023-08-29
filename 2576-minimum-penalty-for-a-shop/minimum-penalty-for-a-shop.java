class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix = new int[n + 1];
        int[] postfix = new int[n + 1];
        prefix[0] = 0;
        postfix[n] = 0;
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefix[i] = prefix[i] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            postfix[i] = postfix[i + 1];
            if (customers.charAt(i) == 'Y') {
                postfix[i] = postfix[i] + 1;
            }
        }

        int minimumPenalty = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n + 1; i++) {
            int currentPenalty = prefix[i] + postfix[i];
            if (currentPenalty < minimumPenalty) {
                index = i;
                minimumPenalty = currentPenalty;
            }
        }
        return index;
    }
}
