class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ret=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length;i++){
            int mul = spells[i];
            int count = 0;
            // Binary Search
            int left = 0;
            int right = potions.length-1;
            while(left <= right){
                // Calculating middle index of potions
                int middleIndex = (left + right)/2;
                // Calculating the product 
                long product = (long) mul * potions[middleIndex];
                // if product >= success then we move right to index middleIndex - 1
                // because all the elements after middle index are greater that success
                // so no need to check
                if(product >= success){
                    right = middleIndex - 1;
                }
                // if product is less then we move left index to middle index + 1
                else{
                    left = middleIndex + 1;
                }
            }
            ret[i] = potions.length-left;
            // for(int j : potions){
            //     if(j * mul >= success)  count++;
            // }
            // ret[i] = count;
        }
        return ret;
    }
}

// spells = [5,1,3], potions = [1,2,3,4,5], success = 7
// Sorted potions = [1,2,3,4,5]
// 5 * 3 = 15