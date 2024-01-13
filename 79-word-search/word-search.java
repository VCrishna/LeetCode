class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(board[row][column] == word.charAt(0) && dfs(board, row, column, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int row, int column, int count, String word) {
        if(count == word.length()) {
            return true;
        }
        if(
            row < 0 || row >= board.length ||
            column < 0 || column >= board[0].length ||
            board[row][column] != word.charAt(count)
        ) {
            return false;
        }

        char visited = board[row][column];
        board[row][column] = ' ';
        boolean found = dfs(board, row + 1, column, count + 1, word) ||
                        dfs(board, row - 1, column, count + 1, word) ||
                        dfs(board, row, column + 1, count + 1, word) ||
                        dfs(board, row, column - 1, count + 1, word);
        board[row][column] = visited;
        return found;
    }
}