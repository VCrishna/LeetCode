class Solution {
    public int maxProfit(int[] prices) {

        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else{
                max=Math.max(max,prices[i]-min);
            }
        }
        return max;
        // int max=0;
        // int left=0;
        // int right=1;
        // while(right<prices.length){
        //     int profit=0;
        //     profit=prices[right]-prices[left];
        //     max=Math.max(max,profit);
        //     if(prices[left]<prices[right]){
        //         right++;
        //     }
        //     else{
        //         left++;
        //         right++;
        //     }
        // }

        // return max;
        
    }
}