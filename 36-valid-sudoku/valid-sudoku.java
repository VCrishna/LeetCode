class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Maps to keep track of numbers in rows, columns, and squares.
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        // Looping through each cell in the Sudoku board.
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                char current = board[row][column];

                // Skipping if the current cell is empty.
                if (current == '.') {
                    continue;
                }

                // Checking if the current number has already been seen
                // in the same row, column, or square.
                if ((rows.containsKey(row) && rows.get(row).contains(current)) ||
                        (columns.containsKey(column) && columns.get(column).contains(current)) ||
                        (squares.containsKey((row / 3) * 3 + column / 3)
                                && squares.get((row / 3) * 3 + column / 3).contains(current))) {
                    return false; // If any condition is violated, the board is invalid.
                }

                // Updating the sets in the maps with the current number
                // for the corresponding row, column, and square.
                rows.computeIfAbsent(row, k -> new HashSet<>()).add(current);
                columns.computeIfAbsent(column, k -> new HashSet<>()).add(current);
                squares.computeIfAbsent((row / 3) * 3 + column / 3, k -> new HashSet<>()).add(current);
            }
        }
        // If the loop completes without finding any violations,
        // the Sudoku board is valid.
        return true;
    }

    public boolean isValidSudoku_CONSTANT_SPACE(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int val = num - '0' - 1;
                    int boxIndex = (i / 3) * 3 + j / 3;

                    if (rows[i][val] || cols[j][val] || boxes[boxIndex][val]) {
                        return false;
                    }

                    rows[i][val] = true;
                    cols[j][val] = true;
                    boxes[boxIndex][val] = true;
                }
            }
        }
        return true;
    }
}
