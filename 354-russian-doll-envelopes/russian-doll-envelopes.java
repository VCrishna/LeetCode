class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort the envelopes based on width, and if width is same, sort by height in descending order
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        // Step 2: Apply LIS algorithm based on height
        
        // Create an array to store the heights of the envelopes forming the LIS
        int[] lis = new int[envelopes.length];
        
        // Initialize the length of the LIS to 0
        int lisLength = 0;
        
        // Iterate through the sorted envelopes
        for (int[] envelope : envelopes) {
            // Use binary search to find the correct position for the current envelope's height
            int index = Arrays.binarySearch(lis, 0, lisLength, envelope[1]);
            
            // If binarySearch returns a non-negative value, it means the element is found,
            // otherwise, it returns (-(insertion point) - 1), where the insertion point is the index
            // where the current envelope's height should be inserted to maintain the LIS property
            
            // If index is negative, convert it to the insertion point
            if (index < 0) {
                index = -(index + 1);
            }
            
            // Store the current envelope's height at the correct position
            lis[index] = envelope[1];
            
            // If the index where the height was inserted is at the end of the LIS,
            // update the length of the LIS
            if (index == lisLength) {
                lisLength++;
            }
        }
        
        // Return the length of the LIS, which represents the maximum number of envelopes that can be nested
        return lisLength;
    }
}
