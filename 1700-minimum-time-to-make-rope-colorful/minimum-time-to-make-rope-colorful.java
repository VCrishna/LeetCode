class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;

        // Start iterating from the second balloon
        for (int i = 1; i < colors.length(); i++) {

            // Check if the current balloon has the same color as the previous one
            if (colors.charAt(i) == colors.charAt(i - 1)) {

                // Remove the balloon with smaller neededTime (to avoid same-color consecutive balloons)
                // Add that cost to minCost
                minCost += Math.min(neededTime[i], neededTime[i - 1]);

                // Keep the balloon with the larger neededTime for future comparisons
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        // Return total minimum cost to remove balloons
        return minCost;
    }
}
