class Solution {
    public int numSpecial(int[][] mat) {
        int result = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1 && checkSpecial(mat,i,j))
                    result++;
            }
        }
        return result;
    }
    public boolean checkSpecial(int[][] mat, int row, int column) {
        // check row - fixeed row, variable column
        for(int i = 0; i < mat[row].length; i++) {
            if(mat[row][i] != 0 && column != i) return false;
        }
        // check column
        for(int i = 0; i < mat.length; i++) {
            if(mat[i][column] != 0 && row != i) return false;
        }

        return true;
    }
}