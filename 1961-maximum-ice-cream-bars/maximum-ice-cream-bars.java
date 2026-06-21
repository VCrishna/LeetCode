class Solution {
    public int maxIceCream(int[] costs, int coins) {

        /*
         * Intuition:
         *
         * To maximize the number of ice creams purchased, we should always buy the
         * cheapest available ice creams first.
         *
         * Instead of sorting the array (O(n log n)), we use Counting Sort because
         * costs are bounded. We count the frequency of every cost and purchase
         * them in increasing order.
         */

        // Find the maximum cost to size the frequency array.
        int maximumCost = 0;
        for (int cost : costs) {
            maximumCost = Math.max(maximumCost, cost);
        }

        // frequency[c] = number of ice creams costing c coins.
        int[] frequency = new int[maximumCost + 1];
        for (int cost : costs) {
            frequency[cost]++;
        }

        int iceCreamsBought = 0;

        // Buy ice creams from the cheapest cost to the most expensive.
        for (int cost = 1; cost <= maximumCost; cost++) {

            // No ice cream with this cost.
            if (frequency[cost] == 0) {
                continue;
            }

            /*
             * We can buy at most:
             * 1. All available ice creams of this cost.
             * 2. Or as many as our remaining coins allow.
             */
            int purchasable = Math.min(frequency[cost], coins / cost);

            iceCreamsBought += purchasable;
            coins -= purchasable * cost;

            /*
             * If we cannot even afford one ice cream of the current cost,
             * we also cannot afford any more expensive ice creams.
             */
            if (coins < cost) {
                break;
            }
        }

        return iceCreamsBought;
    }
}