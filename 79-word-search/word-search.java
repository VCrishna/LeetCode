class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        // Iterating through each cell on the board
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // If the current cell matches the first character of the word, performing DFS
                if (board[row][column] == word.charAt(0) && dfs(board, row, column, 0, word)) {
                    return true; // If DFS returns true, the word exists on the board
                }
            }
        }
        // If no match is found, the word does not exist on the board
        return false;
    }

    // Depth-First Search (DFS) function
    public boolean dfs(char[][] board, int row, int column, int count, String word) {
        // Base case: If all characters in the word are found, return true
        if (count == word.length()) {
            return true;
        }

        // Base case: If the current cell is out of bounds or does not match the word
        // character, return false
        if (row < 0 || row >= board.length ||
                column < 0 || column >= board[0].length ||
                board[row][column] != word.charAt(count)) {
            return false;
        }
        // Storing the current cell's character before modification
        char visited = board[row][column];
        // Marking the cell as visited (using a placeholder character)
        board[row][column] = ' ';

        // Recursively checking neighboring cells in all four directions
        boolean found = dfs(board, row + 1, column, count + 1, word) ||
                dfs(board, row - 1, column, count + 1, word) ||
                dfs(board, row, column + 1, count + 1, word) ||
                dfs(board, row, column - 1, count + 1, word);

        // Restoring the original character after DFS exploration
        board[row][column] = visited;
        return found;
    }
}
