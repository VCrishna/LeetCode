class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to count occurrences of each element in arr1
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // Initialize the result array and an index to keep track of position
        int[] result = new int[arr1.length];
        int index = 0;
        
        // Process the elements of arr2 and place them in the result array
        for (int i : arr2) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                while (count > 0) {
                    result[index++] = i;
                    count--;
                }
                map.remove(i);  // Remove the element from the map once processed
            }
        }
        
        // For the remaining elements in map, sort them and add to result array
        List<Integer> remainingElements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                remainingElements.add(key);
                count--;
            }
        }
        
        // Sort the remaining elements
        Collections.sort(remainingElements);
        
        // Add the sorted remaining elements to the result array
        for (int elem : remainingElements) {
            result[index++] = elem;
        }
        
        return result;
    }
}
