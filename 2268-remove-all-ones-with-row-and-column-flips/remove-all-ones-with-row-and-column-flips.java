class Solution {
    /*
        Basically the "pattern" of each row should be the same, by pattern, 
        I mean following:
            001100 and 001100 are the same pattern
            001100 and 110011 (the invert of original) are the same pattern
        Only in above situation, one matrix can be converted to all zero
 */
    public boolean removeOnes(int[][] grid) {
        int[] first = grid[0];
        int[] firstInvert = invert(grid[0]);
        
        for(int i = 1; i < grid.length; i++) {
            int[] current = grid[i];
            if(!Arrays.equals(current, first) && !(Arrays.equals(current, firstInvert)))
                return false;
        }
        return true;
    }
    public int[] invert(int[] arr) {
        int[] invertedArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            invertedArray[i] = 1 - arr[i];
        }
        return invertedArray;
    }
}
