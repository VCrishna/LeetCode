class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                if (rows.containsKey(r) && rows.get(r).contains(board[r][c]) ||
                        cols.containsKey(c) && cols.get(c).contains(board[r][c]) ||
                        squares.containsKey((r / 3) * 3 + c / 3)
                                && squares.get((r / 3) * 3 + c / 3).contains(board[r][c])) {
                    return false;
                }

                cols.computeIfAbsent(c, k -> new HashSet<>()).add(board[r][c]);
                rows.computeIfAbsent(r, k -> new HashSet<>()).add(board[r][c]);
                squares.computeIfAbsent((r / 3) * 3 + c / 3, k -> new HashSet<>()).add(board[r][c]);
            }
        }

        return true;
    }
}