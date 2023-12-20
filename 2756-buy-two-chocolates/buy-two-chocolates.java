class Solution {
    public int buyChoco(int[] prices, int money) {
        if (prices == null || prices.length < 2) {
            return money;
        }
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p < firstMin) {
                secondMin = firstMin;
                firstMin = p;
            } else if (p < secondMin) {
                secondMin = p;
            }
        }
        int minCost = firstMin + secondMin;
        if (minCost <= money) {
            return money - minCost;
        } else {
            // Not enough money to buy the minimum cost chocolates
            return money;
        }
    }

    public int buyChoco_BRUTE_FORCE(int[] prices, int money) {
        Arrays.sort(prices);
        int minCost = prices[0] + prices[1];
        if (minCost <= money) {
            return money - minCost;
        }
        return money;
    }
}
