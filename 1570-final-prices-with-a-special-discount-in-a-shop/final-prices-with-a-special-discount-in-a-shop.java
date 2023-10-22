class Solution {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) 
            prices[i] = getPrice(i, prices[i], prices);
        return prices;
    }
    public int getPrice(int i, int price, int[] prices) {
        for (int j = i + 1; j < prices.length; j++) 
            if (prices[j] <= prices[i]) 
                return price - prices[j];
        return price;
    }
}
/**

The finalPrices function takes an integer array prices as input and returns an integer array as the output. It initializes a for loop that iterates from 0 to the length of the prices array.

Inside the loop, it calls the getPrice function, passing the current index i, the price at index i in the prices array, and the prices array itself. The getPrice function calculates the discount for the current item based on the subsequent items.

The getPrice function also uses a for loop, starting from the index next to i (i + 1) and continuing until the end of the prices array. It checks if the price at the current index j is less than or equal to the price at index i. If it is, it means a discount is available.

In that case, the function subtracts the discounted price (the price at index j) from the original price (the price at index i) and returns the result. This represents the final price the customer will pay for the item.

If no discount is found during the iteration, the function simply returns the original price, indicating that no discount is applicable for that item.

Back in the finalPrices function, the result of the getPrice function is assigned to the ith index of the prices array. This updates the array with the final prices for each item as they are processed.

Finally, after iterating through all the items in the prices array, the modified prices array is returned as the output of the finalPrices function.

 */
