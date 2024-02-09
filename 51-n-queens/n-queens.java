class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Initializing the list to store all solutions
        List<List<String>> result = new ArrayList<>();

        // Sets to keep track of occupied columns and diagonals
        Set<Integer> column = new HashSet();
        Set<Integer> positiveDiagonal = new HashSet(); // (row + column)
        Set<Integer> negativeDiagonal = new HashSet(); // (row - column)

        // Initializing the chessboard with empty cells
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Starting the backtracking algorithm to find solutions
        backtrack(
            board,
            result,
            column,
            positiveDiagonal,
            negativeDiagonal,
            n,
            0
        );

        return result;
    }
    
    // Backtracking algorithm to find all solutions
    private void backtrack(
        char board[][],
        List<List<String>> result,
        Set<Integer> columnSet,
        Set<Integer> positiveDiagonal,
        Set<Integer> negativeDiagonal,
        int nSize,
        int currentRow) {
        
        // If all queens are placed, add the solution to the result
        if(currentRow == nSize) {
            result.add(createBoard(board, nSize));
            return;
        }
        
        // Iterating through each column in the current row
        for(int column = 0; column < nSize; column++) {
            int pDiagonal = currentRow + column; // Calculate positive diagonal
            int nDiagonal = currentRow - column; // Calculate negative diagonal
            
            // Checking if the current position conflicts with existing queens
            if(
                columnSet.contains(column) ||
                positiveDiagonal.contains(pDiagonal) ||
                negativeDiagonal.contains(nDiagonal)) {
                    continue; // Skipping this position if there's a conflict
                }
            
            // Placing the queen at the current position
            columnSet.add(column);
            positiveDiagonal.add(pDiagonal);
            negativeDiagonal.add(nDiagonal);
            board[currentRow][column] = 'Q';
            
            // Recursively searching for solutions for the next row
            backtrack(
                board,
                result,
                columnSet,
                positiveDiagonal,
                negativeDiagonal,
                nSize,
                currentRow + 1
            );

            // Backtrack: Remove the queen and reset the sets for the next iteration
            columnSet.remove(column);
            positiveDiagonal.remove(pDiagonal);
            negativeDiagonal.remove(nDiagonal);
            board[currentRow][column] = '.';
        }
    }
    
    // Helper method to create a chessboard configuration from char array
    private List<String> createBoard(char[][] charBoard, int n) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < n; row++) {
            String current_row = new String(charBoard[row]);
            board.add(current_row);
        }
        
        return board;
    }
}