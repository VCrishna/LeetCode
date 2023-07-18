class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        if(mat.length == 0 || mat[0].length == 0)
            return new int[0];
        
        int rows = mat.length, columns = mat[0].length;

        int result[] = new int[rows * columns];

        int currentRow = 0, currentColumn = 0;

        // Variable used to keep track of direction UP or DOWN
        boolean up = true;

        for(int i = 0;i<result.length;i++){
            // moving up
            if(up){
                result[i] = mat[currentRow][currentColumn];
                currentRow--;
                currentColumn++;
                // exceed the boundary
                if(!(currentRow >= 0 && currentColumn <= columns - 1)){
                    // return to the previous valid position
                    currentRow++;
                    currentColumn--;
                    
                    // Going to the element right to it(same row, next column) is always preferable
                    // while changing the direction from moving up to moving down 
                    // unless the next column is invalid 
                    if(currentColumn < columns - 1)
                        currentColumn++;
                    else
                        currentRow++;
                    // will move down for next iteration  
                    up = !up;
                }
            }
            // moving down
            else{
                result[i] = mat[currentRow][currentColumn];
                currentRow++;
                currentColumn--;
                // exceed the boundary
                if(!(currentRow <= rows - 1 && currentColumn >= 0))
                {
                    // return to the previous valid position
                    currentRow--;
                    currentColumn++;
                    
                    // Going to the element below it(same column, next row) is always preferable
                    // while changing the direction from moving down to moving up 
                    // unless the next row is invalid 
                    if(currentRow < rows - 1)
                        currentRow++;
                    else
                        currentColumn++;
                    // will move up for next iteration  
                    up = !up;
            }
        } 
    }
    return result;
    }
}
