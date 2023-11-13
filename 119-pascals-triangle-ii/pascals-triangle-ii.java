class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        // adding 1 to the beginning of the row
        row.add(1);
        // iterating from 1 to rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            // filling elements in between first and last element in the row
            for (int j = row.size() - 1; j > 0; j--) {
                // getting last and before last element and placing at last index of the row
                row.set(j, (row.get(j) + row.get(j - 1)));
            }
            // adding 1 to the end of row
            row.add(1);
        }
        return row;
    }
}
