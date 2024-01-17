class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for(int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[row].length; column++) {
                char current = board[row][column];
                if(current == '.') {
                    continue;
                }

                if((rows.containsKey(row) && rows.get(row).contains(current)) ||
                   (columns.containsKey(column) && columns.get(column).contains(current)) ||
                    (squares.containsKey((row / 3) * 3 + column / 3) && squares.get((row / 3) * 3 + column / 3).contains(current))
                ) {
                    return false;
                }
                rows.computeIfAbsent(row, k -> new HashSet<>()).add(current);
                columns.computeIfAbsent(column, k -> new HashSet<>()).add(current);
                squares.computeIfAbsent((row / 3) * 3 + column / 3, k -> new HashSet<>()).add(current);
            }
        }
        return true;
    }
}