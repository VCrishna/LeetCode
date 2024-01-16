class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        // Creating first row and populating it with one element and
        // adding it to result variable
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascal.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // getting previous row
            List<Integer> prevRow = pascal.get(i - 1);
            // as the first and last elements in each row are 1
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            pascal.add(row);
        }
        return pascal;
    }
}