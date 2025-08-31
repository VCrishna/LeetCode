class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        // Step 1: Traverse all cells
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                // If empty cell found
                if (board[row][col] == '.') {
                    
                    // Step 2: Try digits 1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // place number
                            
                            // Step 3: Recurse to solve further
                            if (backtrack(board)) {
                                return true; // solved
                            }
                            
                            // Step 4: Undo (backtrack)
                            board[row][col] = '.';
                        }
                    }
                    
                    // If no digit works → dead end → backtrack
                    return false;
                }
            }
        }
        // If no empty cells left, puzzle is solved
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // Check row, col, and 3x3 sub-box
        for (int i = 0; i < 9; i++) {
            // Same row
            if (board[row][i] == c) return false;
            // Same col
            if (board[i][col] == c) return false;
            // Same 3x3 sub-box
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false;
        }
        return true;
    }
}
