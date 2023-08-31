class Solution {
    public int minTaps(int n, int[] ranges) {
        // minTapsOpen is used to find total number of taps to keep open to cover the garden
        int minTapsOpen = 0;
        // min and max variables are used to find a tap that covers min and max distance
        int min = 0;
        int max = 0;

        // we have to scan until max is less than n i.e., length of the garden
        while(max < n) {

            // scanning the ranges to find max distance a tap can cover
            for(int i = 0; i < ranges.length; i++) {
                
                // it was mentioned in the question that a tap can cover the area
                // [i - ranges[i], i + ranges[i]] if it was open
                if(i - ranges[i] <= min && i + ranges[i] > max) {
                    // if this condition is satisfied then we update our max with i + ranges[i]
                    max = i + ranges[i];
                }
            }
            
            // edge case
            // after first iteration, if still the min and max variables are equal
            // then we return -1
            if(min == max)
                return -1;
            // else we increment minTapsOpen and update our min with max
            // as the max will become the new minimum
            minTapsOpen++;
            min = max;

        }

        return minTapsOpen;
        
    }
}