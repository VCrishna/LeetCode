class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = Arrays.asList(1);
        result.add(firstRow);

        for(int i = 1; i < rowIndex + 1; i++) {
            List<Integer> prevList = result.get(i-1);
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            for(int j = 1; j < prevList.size(); j++) {
                subList.add(prevList.get(j - 1) + prevList.get(j));
            }
            subList.add(1);
            result.add(subList);
        }
        return result.get(rowIndex);
    }
}