class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ret=new int[prices.length];
        for(int i=0; i<prices.length;i++){
            for(int j=0; j<prices.length;j++){
                if( j>i && prices[j]<=prices[i]){
                    ret[i]=prices[i]-prices[j];
                    break;
                }
                else{
                    ret[i]=prices[i];
                }
            }
        }
        
        return ret;
    }
}