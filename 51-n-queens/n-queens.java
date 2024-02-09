class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        Set<Integer> column = new HashSet();
        Set<Integer> positiveDiagonal = new HashSet(); // (row + column)
        Set<Integer> negativeDiagonal = new HashSet(); // (row - column)

        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
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
    private void backtrack(
        char board[][],
        List<List<String>> result,
        Set<Integer> columnSet,
        Set<Integer> positiveDiagonal,
        Set<Integer> negativeDiagonal,
        int nSize,
        int currentRow) {
            if(currentRow == nSize) {
                result.add(createBoard(board, nSize));
                return;
            }
            for(int column = 0; column < nSize; column++) {
                int pDiagonal = currentRow + column;
                int nDiagonal = currentRow - column;
                if(
                    columnSet.contains(column) ||
                    positiveDiagonal.contains(pDiagonal) ||
                    negativeDiagonal.contains(nDiagonal)) {
                        continue;
                    }
                columnSet.add(column);
                positiveDiagonal.add(pDiagonal);
                negativeDiagonal.add(nDiagonal);
                board[currentRow][column] = 'Q';
                backtrack(
                    board,
                    result,
                    columnSet,
                    positiveDiagonal,
                    negativeDiagonal,
                    nSize,
                    currentRow + 1
                );

                columnSet.remove(column);
                positiveDiagonal.remove(pDiagonal);
                negativeDiagonal.remove(nDiagonal);
                board[currentRow][column] = '.';
            }
        }
    private List<String> createBoard(char[][] charBoard, int n) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < n; row++) {
            String current_row = new String(charBoard[row]);
            board.add(current_row);
        }
        
        return board;
    }
}